package com.interview.leetcodes;

import java.util.HashMap;

public class ValidParens {
    private HashMap<Character, Character> map;
    public ValidParens(){
        this.map = new HashMap<Character, Character>();
        this.map.put(')', '(');
        this.map.put('}', '{');
        this.map.put(']', '[');
    }
}
