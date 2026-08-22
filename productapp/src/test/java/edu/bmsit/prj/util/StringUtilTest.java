package edu.bmsit.prj.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilTest {
    @Test
    public void testPalindrome() {
        String str = "madam";
        boolean expected = true;
        boolean result = StringUtil.isPalindrome(str);

        assertEquals(expected, result);
    }
}
