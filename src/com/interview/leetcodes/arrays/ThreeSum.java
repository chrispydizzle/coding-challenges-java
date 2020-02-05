package com.interview.leetcodes.arrays;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum (@NotNull int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> untouched = Arrays.stream(nums).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        // now it's just twosum to make numbers that exist in nums, and we add back in the base numbers later.
        List<int[]> triedCombos = new ArrayList<>();
        List<Integer> oldList = new ArrayList<>(untouched);
        for (int i = 0; i < nums.length - 1; i++) {
            int num1 = oldList.get(i);
            int num2 = oldList.get(i + 1);

            if (triedCombos.size() > 0) {
                if (num1 < num2 && triedCombos.stream().anyMatch(m -> m[0] == num1 && m[1] == num2)) {
                    continue;
                } else if (num1 < num2 && triedCombos.stream().anyMatch(m -> m[0] == num2 && m[1] == num1)) {
                    continue;
                }
            }
            List<Integer> potentials = new ArrayList<>();
            potentials.add(num1);
            potentials.add(num2);

            oldList.remove(0);
            while (oldList.size() > 1) {
                int newValue = num1 + num2;
                oldList.remove(0);
                potentials.add(-newValue);
                potentials.sort(Integer::compareTo);
                List<Integer> finalPotentials = potentials;
                while (oldList.contains(-newValue) && result.stream().noneMatch(r -> r.get(0).equals(finalPotentials.get(0)) && r.get(1).equals(finalPotentials.get(1)) && r.get(2).equals(finalPotentials.get(2)))) {
                    int windex = oldList.lastIndexOf(-newValue);
                    oldList.remove(windex);
                    int uindex = untouched.lastIndexOf(-newValue);
                    if (uindex != i && uindex != i + 1) {
                        result.add(potentials);
                    } else {
                        triedCombos.add(new int[]{potentials.get(0), potentials.get(1)});
                    }

                    potentials = new ArrayList<>();
                    potentials.add(nums[i]);
                    potentials.add(nums[i + 1]);
                }
            }
            oldList = new ArrayList<>(untouched).subList(i);
        }

        return result;
    }
}
