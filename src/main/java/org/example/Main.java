package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static String getRandom(int count) {
        Random random = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(random.nextInt(0, 9));
        }
        return s.toString();
    }

    // 6-digit opt no duplicate
    // 0 1 2 3 4 5 6 7 8 9
    // 1 4 5 6 9 0 2 3 8 7
    // [           ]
    // TC: O(n). SC: O(n). n=10
    public static String getRandomNoDuplicate(int count) {
        int size = 10;
        if (count > size) return "-1";

        String[] digits = new String[size];
        for (int i = 0; i < size; i++) {
            digits[i] = String.valueOf(i);
        }

        shuffle(digits);
        String[] res = Arrays.copyOfRange(digits, 0, count);
        return String.join("", res);
    }

    private static void shuffle(String[] digits) {
        Random random = new Random();
        for (int i = 0; i < digits.length; i++) {
            swap(digits, i, random.nextInt(i, digits.length));
        }
    }

    private static void swap(String[] digits, int i, int j) {
        String temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(getRandom(6));
        System.out.println(getRandomNoDuplicate(6));
        System.out.println(getRandomNoDuplicate(11));
    }
}
