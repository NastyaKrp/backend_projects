package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> info = new ArrayList<>();
        info.add("Hello"); info.add("Bye");
        DB db = new DB();
        db.getConnection();
        System.out.println(db.getData());
        DB db2 = new DB();
        db2.getInstance(info);
        System.out.println(db.getData());
    }
}