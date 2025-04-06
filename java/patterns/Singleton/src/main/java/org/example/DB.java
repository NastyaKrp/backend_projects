package org.example;

import java.util.List;

public class DB {
    private static DB db = null;
    private static List<String> info;

    DB(){}
    private DB(List<String> i)
    {
        this.info = i;
    }

    public static DB getInstance(List<String> info)
    {
        if(db == null)
        {
            db = new DB(info);
        }
        return db;
    }

    public static void getConnection() {
        System.out.println("DBConnection...");
    }

    public List<String> getData() {
        return this.info;
    }
}
