package com.interview.leetcodes;

import java.text.MessageFormat;

public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder b = new StringBuilder();
        // div and mod
        // constraints state 3999 is max val and 1 is minval

        // break down the number into it's composite values.

        Thousands thousands = new Thousands();
        int rem = thousands.collect(num);

        Hundreds hundreds = new Hundreds();
        rem = hundreds.collect(rem);

        Tens tens = new Tens();
        rem = tens.collect(rem);

        Ones ones = new Ones();
        ones.collect(rem);



        b.append(this.romanize(thousands, hundreds));
        b.append(this.romanize(hundreds, tens));
        b.append(romanize(tens, ones));
        b.append(romanize(ones, null));

        return b.toString();
    }

    private String romanize(RomanBase romanBase, RomanBase nextBase) {
        MessageFormat f = new MessageFormat("{0}{1}");

        if (romanBase.value == 1 && nextBase.value == 9) {
            romanBase.value=0;
            nextBase.value= 0;
            f.applyPattern("");
        } else if (value == 1) {
            b.append("M");
        }

        while (value > 1) {
            b.append(base.getValue());
            value--;
        }
        return value;
    }

    private interface IRomanBase {
        String getValue();

        String getModifier();

        String getFiver();
    }

    private abstract class RomanBase implements IRomanBase {
        protected int value;

        protected abstract int getBaseValue();

        public int collect(int value) {
            this.value = value / this.getBaseValue();
            return value % this.getBaseValue();
        }
    }

    private class Thousands extends RomanBase {
        @Override
        protected int getBaseValue() {
            return 1000;
        }

        public String getFiver() {
            return null;
        }

        public String getValue() {
            return "M";
        }

        public String getModifier() {
            return "C";
        }
    }

    private class Hundreds extends RomanBase {
        @Override
        protected int getBaseValue() {
            return 100;
        }

        public String getFiver() {
            return "L";
        }

        public String getValue() {
            return "C";
        }

        public String getModifier() {
            return "X";
        }
    }

    private class Tens extends RomanBase {
        @Override
        protected int getBaseValue() {
            return 10;
        }

        public String getValue() {
            return "X";
        }

        public String getModifier() {
            return "I";
        }

        public String getFiver() {
            return "L";
        }
    }

    private class Ones extends RomanBase {
        @Override
        protected int getBaseValue() {
            return 1;
        }

        public String getFiver() {
            return "V";
        }

        public String getValue() {
            return "I";
        }

        public String getModifier() {
            return "";
        }
    }
}
