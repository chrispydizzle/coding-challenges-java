package com.interview.leetcodes.strings;

//I've just massively overcomplicated this but only because I'm trying to get more familiar with Java and see how it stacks up to C#
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
        b.append(this.romanize(tens, ones));
        b.append(this.romanize(ones, null));

        return b.toString();
    }

    private String romanize(RomanBase romanBase, RomanBase nextBase) {
        StringBuilder b = new StringBuilder();
        while (romanBase.numericValue > 0) {
            if (romanBase.numericValue > 5) {
                b.append(romanBase.getFiver());
                romanBase.numericValue-=5;
            }
            else if (romanBase.numericValue == 5) {
                b.append(romanBase.getFiver());
                romanBase.numericValue = 0;
            } else if (romanBase.numericValue == 4) {
                b.append(romanBase.getValue());
                b.append(romanBase.getFiver());
                romanBase.numericValue = 0;
            } else if (romanBase.numericValue == 1 && nextBase == null) {
                b.append(romanBase.getValue());
                return b.toString();
            } else if (romanBase.numericValue == 1) {
                b.append(romanBase.getValue());
                romanBase.numericValue = 0;
            } else {
                while (romanBase.numericValue > 1) {
                    b.append(romanBase.getValue());
                    romanBase.numericValue--;
                }
            }
        }

        if (nextBase != null && romanBase.numericValue == 0 && nextBase.numericValue == 9) {
            nextBase.numericValue = 0;
            b.append(romanBase.getModifier());
            b.append(romanBase.getValue());
            return b.toString();
        }

        return b.toString();
    }

    private interface IRomanBase {
        String getValue ();

        String getModifier ();

        String getFiver ();
    }

    public abstract static class RomanBase implements IRomanBase {
        protected int numericValue;

        protected abstract int getBaseValue();

        public int collect(int value) {
            this.numericValue = value / this.getBaseValue();
            return value % this.getBaseValue();
        }
    }

    private static class Thousands extends RomanBase {
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

    private static class Hundreds extends RomanBase {
        @Override
        protected int getBaseValue() {
            return 100;
        }

        public String getFiver() {
            return "D";
        }

        public String getValue() {
            return "C";
        }

        public String getModifier() {
            return "X";
        }
    }

    private static class Tens extends RomanBase {
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

    private static class Ones extends RomanBase {
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
