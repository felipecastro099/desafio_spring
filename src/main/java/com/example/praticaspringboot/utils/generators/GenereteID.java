package com.example.praticaspringboot.utils.generators;

public class GenereteID {
    private static long idBuyer = 1l;
    private static long idSeller = 1l;

    public static long generateIDBuyer() {
        return idBuyer++;
    }

    public static long generateIDSeller() {
        return idSeller++;
    }
}
