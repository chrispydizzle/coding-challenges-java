package com.interview.leetcodes.arrays;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSumClose {
    public int threeSumClosest (@NotNull int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int[] collectedInts = new int[3];

        int[] objects;// = (Integer[]) d.keySet();

        int minvalue = IntStream.of()
                                .min()
                                .orElse(Integer.MAX_VALUE);

        int[] diffOfTarget = Arrays.stream(nums)
                                  .map(i -> target - i)
                                  .toArray();
        // now it's just twosum but to get as close to zero as possible... right?
        for (int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++){

            }
        }

        int i1 = Integer.MAX_VALUE;
        //IntStream distinct = IntStream.iterate(differenced);
        //distinct.i

        // now differenced contains all of the existing value-s differences away from the target. Let's do twosum with a min twist

        return result;
    }
}
