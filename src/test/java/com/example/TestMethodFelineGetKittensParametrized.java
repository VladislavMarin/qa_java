package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestMethodFelineGetKittensParametrized {
    private final int kittens;
    private final int expected;

    public TestMethodFelineGetKittensParametrized(int kittens, int expected){
        this.kittens = kittens;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getData(){
      return new Object[][]{
              {1, 1},
              {0, 0},
              {-1, -1},
              {1234567890, 1234567890},
              {-1234567890, -1234567890}

      };
    }

    /**
     * Параметризованный тест {@link Feline#getKittens(int)}.
     * Тест расширяет дипазон значений параметров для {@link TestFeline#TestMethodFelineGetKittensWithParam()}
     */
    @Test
    public void TestMethodFelineGetKittensParametrizedTest(){
        Feline feline = new Feline();
        int actual = feline.getKittens(kittens);
        Assert.assertEquals(actual, expected);
    }
}
