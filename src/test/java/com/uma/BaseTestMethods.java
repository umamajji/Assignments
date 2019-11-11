package com.uma;

import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.Random;

public class BaseTestMethods {
    @Test
    public static String generateName() {

        final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        StringBuilder builder = new StringBuilder();
           for(int i=0;i<7;i++) {
                int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
                builder.append(ALPHA_NUMERIC_STRING.charAt(character));
            }
         return builder.toString().toString();
    }
    @Test
    public static String generatePhone() {

        int length = 10;
        char[] digits = new char[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            digits[i] = (char) ('0' + rand.nextInt(10));
        }
        // phone number cannot be started with '0' or '1'
        if (digits[0] == '0' || digits[0] == '1') {
            digits[0] = '2';
        }
        return new String(digits);
    }
    @Test
    public static String generateZipcode()
    {
        int zip = 123;
        DecimalFormat format = new DecimalFormat("55000");
      //  System.out.println(format.format(zip));
        return format.format(zip);
    }

    public static String Password() {
        return ("tours1234");
    }


}
