package com.example.praticaspringboot.utils.sorter;

import com.example.praticaspringboot.entities.Buyer;
import com.example.praticaspringboot.entities.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByName {
    public static void sortByNameAsc(List<Buyer> users) {
        Collections.sort(users, Comparator.comparing(User::getName));
    }
}
