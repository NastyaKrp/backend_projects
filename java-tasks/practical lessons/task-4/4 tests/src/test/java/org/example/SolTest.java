package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


public class SolTest {

    @Test
    public void lex1()
    {
        String str = "helloDmyD3892389283DnameDis9938DsssssD???sDfnmgnfm";
        String ans = "hello my 3892389283 name is9938 sssss ???s fnmgnfm ";
        String res = "";
        String[] words = Sol.lex(str, "D");
        for(String word: words)
        {
            res += word + " ";
        }
        assertEquals(res, ans);
    }

    @Test
    public void lex2()
    {
        String str = "helloDmyF3892389283GnameDis9938FsssssF???sGfnmgnfm";
        String ans = "hello my 3892389283 name is9938 sssss ???s fnmgnfm ";
        String res = "";
        String[] words = Sol.lex(str, "DFG");
        for(String word: words)
        {
            res += word + " ";
        }
        assertEquals(res, ans);
    }

    @Test
    public void numb1() {
        String str = "helloDmyF4738478GnameDisD9938FsssssF???sGfnmgnfmF8894";
        String[] words = Sol.lex(str, "DFG");
        ArrayList<Integer> numbers = Sol.numb(words);
        String res = "";
        for(Integer num: numbers)
        {
            res += Integer.toString(num) + " ";
        }
        String ans = "4738478 9938 8894 ";
        assertEquals(res, ans);
    }

    @Test
    public void numb2() {
        String str = "hello2342Dmy3FnameDisD9938FsssssF???2sGfnmgnfmF8894";
        String[] words = Sol.lex(str, "DFG");
        ArrayList<Integer> numbers = Sol.numb(words);
        String res = "";
        for(Integer num: numbers)
        {
            res += Integer.toString(num) + " ";
        }
        String ans = "9938 8894 ";
        assertEquals(res, ans);
    }

    @Test
    public void sep_words1() {
        String str = "helloDmyF4738478GnameDisD9938FsssssF???sGfnmgnfmF8894";
        String[] words = Sol.lex(str, "DFG");
        ArrayList<String > sep_words = Sol.sep_words(words);
        String res = "";
        for(String w: sep_words)
        {
            res += w + " ";
        }
        String ans = "hello my name is sssss ???s fnmgnfm ";
        assertEquals(res, ans);
    }

    @Test
    public void sep_words2() {
        String str = "hello2342Dmy3FnameDisD9938FsssssF???2sGfnmgnfmF8894";
        String[] words = Sol.lex(str, "DFG");
        ArrayList<String > sep_words = Sol.sep_words(words);
        String res = "";
        for(String w: sep_words)
        {
            res += w + " ";
        }
        String ans = "hello2342 my3 name is sssss ???2s fnmgnfm ";
        assertEquals(res, ans);
    }

    @Test
    public void contains1() {
        String str = "hello2342Dmy3FnameDisD9938FsssssF???2sGfnmgnfmF8894";
        String ans = "There is no such number";
        String res = Sol.Contains(str,1012);
        assertEquals(res, ans);
    }

    @Test
    public void contains2() {
        String str = "hello2342Dmy3F1012DnameDisD9938FsssssF???2sGfnmgnfmF8894";
        String ans = "P index in string is 14";;
        String res = Sol.Contains(str,1012);
        assertEquals(res, ans);
    }

    @Test
    public void equal() {
        String str = "helloDmmmmmmFyyyyyG4738478GnameDisD9938FsssssF???sGfnmgnfmF8894";
        String[] words = Sol.lex(str, "DFG");
        ArrayList<String > sep_words = Sol.sep_words(words);
        ArrayList<String> equal = Sol.equal(sep_words);
        String res = "";
        for(String w: equal)
        {
            res += w + " ";
        }
        String ans = "mmmmmm yyyyy sssss ";
        assertEquals(res, ans);
    }

    @Test
    public void del_pun1() {
        String str = "helloDmmmmmmF??.,4738478GnameDisD9938FsssssF???sGfnmgnfmF8894";
        String ans = "helloDmmmmmmF4738478GnameDisD9938FsssssFsGfnmgnfmF8894";
        str = Sol.del_pun(str);
        assertEquals(str, ans);
    }

    @Test
    public void del_pun2() {
        String str = "hell???!!oDmm:mmm:?mF??.,4738!!478GnameDisD99?38FsssssF???sGfnmgnfmF..8894";
        String ans = "helloDmmmmmmF4738478GnameDisD9938FsssssFsGfnmgnfmF8894";
        str = Sol.del_pun(str);
        assertEquals(str, ans);
    }

    @Test
    public void dbl_num() {
        String str = "helloDmmmmmmFyyyyyG4738478GnameDisD9938FsssssF???sGfnmgnfmF8894";
        str = Sol.dbl_num(str, 9938);
        String res = "helloDmmmmmmFyyyyyG4738478GnameDisD99389938FsssssF???sGfnmgnfmF8894";
        assertEquals(str, res);
    }

    @Test
    public void sort() {
        String str = "helloDmmmmmmFyyyyyG4738478GnameDisD9938FsssssF???sGfnmgnfmF8894";
        String[] words = Sol.lex(str, "DFG");
        List<String> list = new ArrayList<>(Arrays.asList(words));
        list = Sol.sort(list);
        String res = "";
        for(String lex: list)
        {
            res += lex + " ";
        }
        String ans = "8894 4738478 9938 name mmmmmm fnmgnfm hello is sssss ???s yyyyy ";
        assertEquals(ans, res);
    }

    @Test
    public void isNum1() {
        String res = "10012BBBs";
        assertEquals(false, Sol.isNum(res));
    }

    @Test
    public void isNum2() {
        String res = "10012";
        assertEquals(true, Sol.isNum(res));
    }

    @Test
    public void testIsNum1() {
        String res = "10012243";
        assertTrue(Sol.isNum(res, 10));
    }

    @Test
    public void testIsNum2() {
        String res = "3C6A";
        assertEquals(false, Sol.isNum(res, 10));
    }
}