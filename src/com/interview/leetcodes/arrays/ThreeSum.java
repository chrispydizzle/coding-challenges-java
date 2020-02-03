package com.interview.leetcodes.arrays;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum (@NotNull int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> untouched = Arrays.stream(nums)
                                        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        List<Integer> diffOfTarget = Arrays.stream(nums)
                                           .map(i -> -i)
                                           .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        // now it's just twosum to make numbers that exist in nums, and we add back in the base numbers later.
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> oldList = Arrays.stream(nums)
                                              .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
                List<Integer> tempList = new ArrayList<>(diffOfTarget);
                int newValue = nums[i] + nums[j];

                List<Integer> potentials = new ArrayList<>();
                potentials.add(nums[i]);
                potentials.add(nums[j]);

                tempList.remove(i);
                tempList.remove(i);
                oldList.remove(i);
                oldList.remove(i);

                while (oldList.contains(-newValue)) {
                    int windex = oldList.indexOf(-newValue);

                    potentials.add(-newValue);
                    tempList.remove(windex);
                    oldList.remove(windex);
                    potentials.sort(Integer::compareTo);
                    int uindex = untouched.indexOf(-newValue);
                    List<Integer> finalPotentials = potentials;
                    if (result.stream()
                              .noneMatch(integers -> integers.containsAll(finalPotentials)) && uindex != i && uindex != j) {
                        result.add(potentials);
                    }

                    potentials = new ArrayList<>();
                    potentials.add(nums[i]);
                    potentials.add(nums[j]);
                }
            }
        }

        return result;
    }
}
