package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestMethodDoesHaveManeLionParametrized {
    private final String hasMane;
    private final boolean expected;


    public TestMethodDoesHaveManeLionParametrized(String hasMane, boolean expected) {
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
     * Параметризованный тест метода {@link Lion#doesHaveMane()}.
     * Сделал этот тест, тк требуется параметризованный тест для проверки задания.
     * Такие же проверки выполняются в {@link TestLion#testConstrLion()} при тестировании конструктора класса Lion
     * @throws Exception
     */
    @Test
    public void TestMethodLionDoesHaveMane() throws Exception {
        Lion lion = new Lion(hasMane);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(actual, expected);

    }
}