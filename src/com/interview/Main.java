package com.interview;

import com.interview.leetcodes.ContainerWater;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    int[] in = new int[] {1,8,6,2,5,4,8,3,7};
        ContainerWater s = new ContainerWater();
        Write(s.maxArea(in));
    }

    public static void Write(Object val){
        System.out.println(val);
    }
}
