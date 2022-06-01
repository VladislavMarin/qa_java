package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class TestLionParametrized {
    private final String hasMane;
    private final boolean expected;


    public TestLionParametrized(String hasMane, boolean expected) {
        this.hasMane = hasMane;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    /**
     * Параметризованный тест 
     * @throws Exception
     */
    @Test
    public void TestMethodLionDoesHaveMane() throws Exception {
        Lion lion = new Lion(hasMane);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(actual, expected);

    }
}