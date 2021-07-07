package com.example.praticaspringboot.utils.generators;

public class GenereteID {
    private static long idBuyer = 1L;
    private static long idSeller = 1L;
    private static long idProduct = 1L;
    private static long idCategory = 1L;
    private static long idPost = 1L;

    public static long generateIDBuyer() {
        return idBuyer++;
    }

    public static long generateIDSeller() {
        return idSeller++;
    }

    public static long generateIDProduct() {
        return idProduct++;
    }

    public static long generateIDCategory() {
        return idCategory++;
    }

    public static long generateIDPost() {
        return idPost++;
    }
}
