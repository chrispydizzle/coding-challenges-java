package com.interview.leetcodes.arrays;

public class ContainerWater {
    public Integer maxArea(int[] height) {
        Integer result = 0;
        Integer pL = 0;

        while (pL < height.length - 1) {
            Integer pR = pL + 1;
            while (pR < height.length) {
                Integer calcedVal = (pR - pL) * Math.min(height[pL], height[pR]);
                result = Math.max(result, calcedVal);
                pR++;
            }
            pL++;
        }


        return result;
    }
}
