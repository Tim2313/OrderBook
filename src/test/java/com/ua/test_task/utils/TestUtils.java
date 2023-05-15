package com.ua.test_task.utils;

public class TestUtils {

    public static void testFailed(String description) {
        throw new AssertionError(description);
    }

    public static void assertEquals(int actual, int expected) {
        if (actual != expected) {
            String massagePattern = "\nactual = '%d'\nexpected = '%d'\nThere are not the same!";
            String massage = String.format(massagePattern, actual, expected);
            throw new AssertionError(massage);
        }
    }

    public static void assertEquals(String actual, String expected) {
        if (!actual.equals(expected)) {
            String massagePattern = "\nactual = '%s'\nexpected = '%s'\nThere are not the same!";
            String massage = String.format(massagePattern, actual, expected);
            throw new AssertionError(massage);
        }
    }

    public static void assertEquals(boolean actual, boolean expected) {
        if (actual != expected) {
            String massagePattern = "\nactual = '%b'\nexpected = '%b'\nThere are not the same!";
            String massage = String.format(massagePattern, actual, expected);
            throw new AssertionError(massage);
        }
    }

}
