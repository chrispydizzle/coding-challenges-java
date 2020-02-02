package com.interview.interviews;

import java.util.HashSet;
import java.util.Set;

public class InRhythm {
    public int LongestSubString(String str) {
        if (str.equals("")) return 0;

        int result = 0;
        int st = 0;
        int en = 1;

        Set<Character> uniq = new HashSet<Character>();
        while (en < str.length() && st < en) {

            uniq.add(str.charAt(st));

            while (en < str.length()) {
                Character newCandidate = str.charAt(en);
                if (uniq.contains(newCandidate)) {
                    result = Math.max(result, en - st);
                    break;
                }

                uniq.add(newCandidate);
                en++;
            }

            st++;
        }

        return result;
    }
}