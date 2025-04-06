package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String str = sc.nextLine();
        System.out.println("Enter divider");
        String div = sc.nextLine();
        System.out.println(div);
        System.out.println("Enter P - number to find");
        int p = sc.nextInt();

        //найти индекс числа p
        System.out.println(Sol.Contains(str, p));

        //разделить на лексемы
        String[] words = Sol.lex(str, div);
        System.out.println("---------------------------------");

        // вывести все лексемы
        System.out.println("ALL WORDS: ");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("---------------------------------");

        ArrayList<Integer> numbers = Sol.numb(words);
        ArrayList<String> sep_words = Sol.sep_words(words);

        // проверить
        System.out.println("numbers: ");
        for (Integer num : numbers) {
            System.out.println(num);
        }
        System.out.println("---------------------------------");
        System.out.println("only word: ");
        for (String lex : sep_words) {
            System.out.println(lex);
        }
        System.out.println("---------------------------------");
        //вывод лексем из одного повторяющегося символа
        ArrayList<String> eq = Sol.equal(sep_words);
        System.out.println("Equal:");
        for(String word: eq)
        {
            System.out.println(word);
        }
        System.out.println("---------------------------------");
        int change = 0;
        for(Integer num : numbers)
        {
            change = num;
            break;
        }
        //вывод с удалением всех знаков препинания
        str = Sol.del_pun(str);
        System.out.println("Delete punctuation mark");
        System.out.println(str);
        System.out.println("---------------------------------");

        //дублирование одного числа
        System.out.println("Duble of number");
        str = Sol.dbl_num(str, change);
        System.out.println(str);
        System.out.println("---------------------------------");

        //сортировка по последнему элементу строки
        List<String> list = new ArrayList<>(Arrays.asList(words));
        System.out.println("Lambda collections sort: ");
        list = Sol.sort(list);
        System.out.println(list);
    }
}