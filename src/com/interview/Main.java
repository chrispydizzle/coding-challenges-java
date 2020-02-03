package com.interview;

// import com.interview.leetcodes.*;
import com.interview.leetcodes.arrays.ThreeSum;
import com.interview.leetcodes.arrays.ThreeSumClose;
import com.interview.leetcodes.arrays.TwoSum;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        ThreeSum twoSum = new ThreeSum();
        List<List<Integer>> result3 = twoSum.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        List<List<Integer>> result = twoSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> result2 = twoSum.threeSum(new int[]{1,2,-2,-1});



        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
    }

    public static void mainOld (String[] args) {
        ThreeSumClose s = new ThreeSumClose();

        Write(s.threeSumClosest(new int[]{-1, 2, 1, -4, 1}, 1));

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
    }

    public static void Write (Object val) {
        System.out.println(val);
    }
}
