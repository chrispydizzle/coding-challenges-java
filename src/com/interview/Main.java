package com.interview;

import com.interview.leetcodes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        threeSumClose s = new threeSumClose();

        Write(s.threeSumClosest(new int[] { -1, 2, 1, -4, 1}, 1));

        Scanner in = new Scanner(System.in);
        String input  = in.nextLine();
    }

    public static void Write(Object val) {
        System.out.println(val);
    }
}
