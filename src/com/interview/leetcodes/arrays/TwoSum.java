package com.interview.leetcodes.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoSum {
    public int[] twoSum (int[] nums, int target) {
        int[] result = new int[2];
        int[] diffStream = Arrays.stream(nums)
                                 .map(num -> target - num)
                                 .toArray();
        for (int i = 0; i < diffStream.length - 1; i++) {
            for (int j = i + 1; j < diffStream.length; j++) {
                if (diffStream[i] + diffStream[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return result;
    }
}
