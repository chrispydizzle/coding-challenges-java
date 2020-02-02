package com.interview;

import com.interview.leetcodes.IntToRoman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntToRoman s = new IntToRoman();
        Write(s.intToRoman(3));
        Write(s.intToRoman(3999));
        Write(s.intToRoman(3455));
        Write(s.intToRoman(3444));
        Write(s.intToRoman(1));
        Write(s.intToRoman(4));

        Write(s.intToRoman(1999));
        Scanner in = new Scanner(System.in);
        String input  = in.nextLine();
    }

    public static void Write(Object val) {
        System.out.println(val);
    }
}
