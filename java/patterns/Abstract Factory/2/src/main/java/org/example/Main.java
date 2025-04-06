package org.example;

import org.example.app.Application;
import org.example.factories.ArtdecoFactory;
import org.example.factories.Factory;
import org.example.factories.ModernFactory;
import org.example.factories.VictorianFactory;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Application configureApplication() {
        Application app;
        Factory factory;
        System.out.println("Enter style of furniture: modern, victorian, artdeco");
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        if (Objects.equals(type, "modern")) {
            factory = new ModernFactory();
        }
        else if(Objects.equals(type, "victorian")){
            factory = new VictorianFactory();
        }
        else {
            factory = new ArtdecoFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        Boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while(flag)
        {
            System.out.println("Enter count of furniture you want to build:\n3 items = full complect\n2 items\n1 item");
            Integer count = sc.nextInt();
            switch (count) {
                case 3:
                    app.build();
                    break;
                case 2:
                    System.out.println("Enter 2 types of furniture you want to build(they could be equal):\nsofa\narmchair\ntable");
                    String it1 = sc.next();
                    String it2 = sc.next();
                    app.build(it1, it2);
                    break;
                case 1:
                    System.out.println("Enter type of furniture you want to build:\nsofa\narmchair\ntable");
                    String it = sc.next();
                    app.build(it);
                    break;
            }
            System.out.println("Do you want build more furniture?(yes/no)");
            String ans = sc.next();
            if(Objects.equals(ans, "no"))
            {
                flag = false;
            }
        }

    }
}