package com.interview.leetcodes;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class threeSumClose {
    public int threeSumClosest (@NotNull int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int[] collectedInts = new int[3];

        // alright, naive solution would loop each value in target for every value after it. Let us not do that.
        // instead, we'll take every value in nums and subract it from target, and then treat this like a two sum.
        // the closest factor just means that rather then searching for the target itself, I just need to do a math min on result vs current val

        HashMap<Integer, List<Integer>> d =
                IntStream.of(nums).distinct().boxed()
                         .collect(Collectors
                                 .toMap(c -> c, c -> new ArrayList<>(),
                                         (a, b) -> b, HashMap::new));

        int[] objects = (Integer[]) d.keySet();

        int minvalue = IntStream.of().min().orElse(Integer.MAX_VALUE);

        int[] differenced = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(target - nums[i]);
            differenced[i] = n;
        }

        int i1 = Integer.MAX_VALUE;
        //IntStream distinct = IntStream.iterate(differenced);
        //distinct.i

        // now differenced contains all of the existing value-s differences away from the target. Let's do twosum with a min twist
        for (int i = 0; i < differenced.length; i++) {

        }

        return result;
    }
}
