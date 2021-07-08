package com.example.praticaspringboot.services;

import com.example.praticaspringboot.dto.buyers.BuyerDTO;
import com.example.praticaspringboot.dto.buyers.BuyerListPostDTO;
import com.example.praticaspringboot.dto.post.PostDTO;
import com.example.praticaspringboot.dto.post.PostListDTO;
import com.example.praticaspringboot.entities.*;
import com.example.praticaspringboot.exceptions.NotFoundException;
import com.example.praticaspringboot.repositories.*;
import com.example.praticaspringboot.utils.convertor.buyers.BuyerListPostMapper;
import com.example.praticaspringboot.utils.convertor.posts.PostListMapper;
import com.example.praticaspringboot.utils.convertor.posts.PostMapper;
import com.example.praticaspringboot.utils.convertor.pruducts.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    public PostDTO create (PostDTO postDTO) {
        Seller seller = sellerRepository.findById(postDTO.getUserId());
        ProductCategory category = categoryRepository.findById(postDTO.getCategory());

        if (seller == null) {
            throw new NotFoundException("Vendedor não encontrado");
        }

        if (category == null) {
            throw new NotFoundException("Categoria não encontrada");
        }

        Product product = ProductMapper.toEntity(postDTO.getDetail(), postDTO, category);

        Post post = PostMapper.toEntity(postDTO, seller, product);

        productRepository.create(product);
        postRepository.create(post);

        return PostMapper.toDto(post, category, product);
    }

    public BuyerListPostDTO getPostsPerBuyerAndFiltred(long id, String order) {
        Buyer buyer = buyerRepository.findById(id);

        if (buyer == null) {
            throw new NotFoundException("Comprador não encontrado");
        }

        List<PostListDTO> posts = getPostFromTwoWeeks(id);

        BuyerListPostDTO buyerListPostDTO = BuyerListPostMapper.toDto(buyer, posts);

        if(order.equals("date_asc")) {
            Collections.sort(posts, Comparator.comparing(PostListDTO::getDate));
        }

        if(order.equals("date_desc")) {
            Collections.sort(posts, Comparator.comparing(PostListDTO::getDate).reversed());
        }

        return buyerListPostDTO;
    }

    public List<PostListDTO> getPostFromTwoWeeks(long id) {
        // capturando instância de data
        Date localDate = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.of("America/Sao_Paulo")).toInstant());
        Date localDateAfterTwoWeeks = Date.from(LocalDate.now().plus(-2, ChronoUnit.WEEKS).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        // capturando os posts dos vendedores de um determinado comprador
        List<Post> posts = getPostsFromBuyer(id);

        //gerando um array de posts filtrados com os dois periodos solicitados
        List<Post> postsFiltred = posts.stream().filter(post -> post.getDate().before(localDate) && post.getDate().after(localDateAfterTwoWeeks)).collect(Collectors.toList());
        List<PostListDTO> postDTOS = new ArrayList<>();

        postsFiltred.forEach(post -> {
            postDTOS.add(PostListMapper.toDto(post, post.getProduct().getCategory(), post.getProduct()));
        });

        return postDTOS;
    }

    public List<Post> getPostsFromBuyer(long id) {
        Buyer buyer = buyerRepository.findById(id);

        List<Seller> buyerSellers = buyer.getFollowed();

        List<Post> posts = postRepository.findAll();

        List<Post> postSellers = new ArrayList<>();

        buyerSellers.forEach(seller -> {
            posts.forEach(post -> {
                if (post.getSeller() == seller) {
                    postSellers.add(post);
                }
            });
        });

        return postSellers;
    }
}
