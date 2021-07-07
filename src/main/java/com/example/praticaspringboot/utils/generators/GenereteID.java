package com.example.praticaspringboot.utils.generators;

public class GenereteID {
    private static long idBuyer = 1L;
    private static long idSeller = 1L;

    public static long generateIDBuyer() {
        return idBuyer++;
    }

    public static long generateIDSeller() {
        return idSeller++;
    }
}
