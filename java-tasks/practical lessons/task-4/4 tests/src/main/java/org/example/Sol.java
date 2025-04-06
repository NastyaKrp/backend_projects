package org.example;

import java.util.*;

class Sol
{
    public static String[] lex1(String str, String div)
    {
        return str.split(div);
    }

    public static String[] lex2(String str, String div)
    {
        String[] words = new String[str.length()];
        StringTokenizer string_tokenizer = new StringTokenizer(str, div);
        int i = 0;
        while (string_tokenizer.hasMoreTokens()) {
            words[i] = string_tokenizer.nextToken();
            i++;
        }
        return words;
    }

    public static String[] lex(String str, String div)
    {
        String[] words = new String[str.length()];
        if(div.length() == 1) {
            words = lex1(str, div);
        }
        else {
            words = lex2(str, div);
        }
        List<String> list = new ArrayList<>(Arrays.asList(words));
        list.removeAll(Arrays.asList("", null));
        words = list.toArray(new String[0]);
        return words;
    }

    public static ArrayList<Integer> numb(String[] lex)
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String s : lex) {
            if (isNum(s)) {
                if (isNum(s, 10)){
                    numbers.add(Integer.parseInt(s));
                }
            }
        }
        return numbers;
    }

    public static ArrayList<String> sep_words(String[] lex)
    {
        ArrayList<String> sep_words = new ArrayList<>();
        for (String s : lex) {
            if (!isNum(s)) {
                sep_words.add(s);
            }
        }
        return sep_words;
    }
    public static String Contains(String str, Integer p)
    {
        if(str.contains(Integer.toString(p)))
        {
            return "P index in string is " + str.indexOf(Integer.toString(p));
        }
        else
        {
            return "There is no such number";
        }
    }

    public static ArrayList<String> equal(ArrayList<String> sep_words)
    {
        ArrayList<String> eq = new ArrayList<>();
        for(String word: sep_words)
        {
            int temp = 0;
            for (int k = 0; k < word.length() - 1; ++k)
            {
                if (word.charAt(k) == word.charAt(k + 1))
                {
                    temp++;
                }
            }
            if(temp == word.length() - 1)
            {
                eq.add(word);
            }
        }
        return eq;
    }

    public static String del_pun(String str)
    {
        str = str.replaceAll("[!,.?:;']","");
        return str;
    }

    public static String dbl_num(String str, Integer change)
    {
        str = str.substring(0, str.indexOf(Integer.toString(change)) + Integer.toString(change).length()) + Integer.toString(change) + str.substring(str.indexOf(Integer.toString(change)) + Integer.toString(change).length());
        return str;
    }

    public static List<String> sort(List<String> words)
    {
        Collections.sort(words, (o1, o2) -> String.valueOf(o1.charAt(o1.length() - 1)).compareTo(String.valueOf(o2.charAt(o2.length() - 1))));
        return words;
    }

    public static boolean isNum(String str) {
        try {
            int num = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isNum(String str, int rad) {
        try {
            int num = Integer.parseInt(str, rad);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}