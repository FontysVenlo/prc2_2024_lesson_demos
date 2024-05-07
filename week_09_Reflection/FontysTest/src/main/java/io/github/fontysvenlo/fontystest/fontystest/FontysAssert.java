package io.github.fontysvenlo.fontystest.fontystest;

public class FontysAssert {

    public static <T> void assertEquals(T expected, T actual) {
        if (expected.equals(actual)) {
            System.out.println("GREEN TEST :)");
        }else{
            System.out.println("RED TEST Expected: " + expected + " Actual: " + actual);
        }
    }

}
