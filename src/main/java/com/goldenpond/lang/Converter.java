package com.goldenpond.lang;

public class Converter {

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);            
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
