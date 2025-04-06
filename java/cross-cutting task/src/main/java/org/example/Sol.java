package org.example;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sol {
    String task;
    Integer ans;

    Sol(String t, Integer a)
    {
        this.task = t;
        this.ans = a;
    }

    public static List<String> Sol_M(List<String> info) throws ScriptException {
        List<String> sol = new ArrayList<>();
        //String pattern = [0-9]+([\+\-\*\/][0-9])*
        Pattern pattern = Pattern.compile("[0-9]+([\\+\\-\\*\\/][0-9])*");
        for(String s: info)
        {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find())
            {
                sol.add(String.valueOf(eval(s)));
            }
            else
            {
                sol.add(s);
            }
        }
        return sol;
    }

    static boolean isDelim(char c){
        return c == ' ';
    }
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }
    static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }
    static void processOperator(LinkedList<Integer> st, char op) {
        int r = st.removeLast();
        int l = st.removeLast();
        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
            case '%':
                st.add(l % r);
                break;
        }
    }
    public static int eval(String s) {
        LinkedList<Integer> st = new LinkedList<Integer>();
        LinkedList<Character> op = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st,op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    operand += s.charAt(i++);
                --i;
                st.add(Integer.parseInt(operand));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);
    }
}
