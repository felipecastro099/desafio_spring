# Desafio Spring Boot

Repositório que contém a solução do desafio spring boot

- POST ```` /users/buyer ````
- adiciona um buyer no array
    - body request:
    ````
    {
	    "userName": "Felipe Castro"
    }
    ````
    - body response
    ````
    {
      "userID": 1,
      "userName": "Felipe Castro"
    }
    ````

- POST ```` /users/seller ````
- adiciona um seller no array
    - body request:
    ````
    {
	    "userName": "Felipe Castro"
    }
    ````
    - body response
  ````
  {
    "userID": 1,
    "userName": "Felipe Castro"
  }
  ````

- POST ```` /users/{buyerId}/follow/{sellerId} ````
- US001: Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor
    - body response
    ````
  Status Code 200 (tudo OK)
  ````
  
- GET ```` /users/{sellerId}/followers/count/ ````
- US002: Obter o resultado do número de usuários que seguem um determinado vendedor
  - body response
  ````
  {
    "userID": 1,
    "userName": "Felipe Castro",
    "followers_count": 1
  }
  ````
- GET ```` /users/{sellerId}/followers/list ````
- US003: Obter uma lista de todos os usuários que seguem um determinado vendedor (quem me segue?)
  - body response
  ````
  {
    "userId": 1,
    "userName": "Felipe Castro",
    "followers": [
      {
        "userID": 1,
        "userName": "Comprador 1"
      }
    ]
  }
  ````
  
- GET ```` /users/{buyerId}/followed/list ````
- US004: Obter uma lista de todos os vendedores que um determinado usuário segue (quem estou seguindo?)
  - body response
  ````
  {
    "userID": 1,
    "userName": "Comprador 1",
    "followed": [
      {
        "userID": 1,
        "userName": "Felipe Castro"
      }
    ]
  }
  ````
  
- POST ```` /products/category ````
- O Cadastro de categoria é obrigatorio para a criação de um post, já que o produto recebe um objeto do tipo Categoria
  - body request
  ````
  {
	  "categoryName": "outros"
  }
  ````
  - body response
  ````
  {
    "categoryId": 1,
    "categoryName": "outros"
  }
  ````
  
- POST ```` /products/newpost ````
- US005: Cadastrar uma nova publicação
  - body request
  ````
  {
      "userId": 1,
      "date": "27-06-2021",
      "detail": {
          "productName": "Cadeira Gamer",
          "type": "Gamer",
          "brand": "Racer",
          "color": "black",
          "notes": "Special Edition"
      },
      "category": 1,
      "price": 1500.0
  }
  ````
  - body response
  ````
  {
      "userId": 1,
      "date": "27-06-2021",
      "detail": {
          "productName": "Cadeira Gamer",
          "type": "Gamer",
          "brand": "Racer",
          "color": "black",
          "notes": "Special Edition"
      },
      "category": 1,
      "price": 1500.0
  }
  ````
- POST ```` /products/followed/{buyerId}/list ````
- US006: Obter uma lista das publicações feitas pelos vendedores que um usuário segue nas últimas duas semanas (para isso, ter em conta ordenação por data, a maioria das publicações recentes primeiro).
  - body response
  ````
  {
  "userId": 1,
  "posts": [
      {
        "id_post": 2,
        "date": "2021-06-29T00:00:00.000+00:00",
        "detail": {
          "product_id": 2,
          "productName": "Cadeira Gamer",
          "type": "Gamer",
          "brand": "Racer",
          "color": "black",
          "notes": "Special Edition"
        },
        "category": 1,
        "price": 1500.0
      },
      {
        "id_post": 1,
        "date": "2021-06-27T00:00:00.000+00:00",
        "detail": {
          "product_id": 1,
          "productName": "Cadeira Gamer",
          "type": "Gamer",
          "brand": "Racer",
          "color": "black",
          "notes": "Special Edition"
        },
        "category": 1,
        "price": 1500.0
      }
    ]
  }
  ````
  - POST ```` /users/{buyerId}/unfollow/{sellerId} ````
  - US007: Ser capaz de realizar a ação de “Deixar de seguir” (parar de seguir) um determinado vendedor.
    - body response
    ````
    Status Code 200 (tudo OK)
    ````
    
  - GET
   ````
  /users/{UserID}/followers/list?order=name_asc

  /users/{UserID}/followers/list?order=name_desc

  /users/{UserID}/followed/list?order=name_asc

  /users/{UserID}/followed/list?order=name_desc
  ````
  - US008: Ordem alfabética crescente e decrescente
    - body response
    ````
        {
          "userId": 1,
          "userName": "Vendedor 1",
          "followers": [
              {
                "userID": 2,
                "userName": "Comprador 1"
              },
              {
                "userID": 1,
                "userName": "Comprador 2"
              },
              {
                "userID": 3,
                "userName": "Comprador 3"
              }
          ]
        }
    
    ````
    
  - GET
  ````
    /products/followed/{userId}/list?order=date_asc

    /products/followed/{userId}/list?order=date_desc 
  ````
  - US009: Classificar por data crescente e decrescente
    - body response
    ```` 
      {
        "userId": 1,
        "posts": [
          {
            "id_post": 2,
            "date": "2021-06-29T00:00:00.000+00:00",
            "detail": {
            "product_id": 2,
            "productName": "Cadeira Gamer",
            "type": "Gamer",
            "brand": "Racer",
            "color": "black",
            "notes": "Special Edition"
          },
          "category": 1,
          "price": 1500.0
        },
        {
          "id_post": 1,
          "date": "2021-06-27T00:00:00.000+00:00",
          "detail": {
          "product_id": 1,
          "productName": "Cadeira Gamer",
          "type": "Gamer",
          "brand": "Racer",
          "color": "black",
          "notes": "Special Edition"
        },
        "category": 1,
        "price": 1500.0
        }
      ]
    }
    ````
  
    