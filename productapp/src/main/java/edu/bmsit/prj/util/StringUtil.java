package edu.bmsit.prj.util;

public class StringUtil {

    public static boolean isPalindrome(String str) {
//        if (str == null) return false;
//
//        String cleanStr = str.toLowerCase();
//        String reversedStr = new StringBuilder(cleanStr).reverse().toString();
//
//        return cleanStr.equals(reversedStr);

        if (str == null) return false;

        // Convert to lowercase to make it case-insensitive
        str = str.toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Mismatch found
            }
            left++;
            right--;
        }
        return true; // All characters matched
    }
}
