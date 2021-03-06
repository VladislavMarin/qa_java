package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Mock
    Feline felineMock;

    /**
     * Тестирование метода класса {@link Feline#eatMeat()}
     */
    @Test
    public void TestMethodFelineEatMeat() {

        //Кейс когда метод eatMeat() класса Feline возвращает "List.of("Животные", "Птицы", "Рыба")"

        try {
            Assert.assertEquals(feline.eatMeat(), List.of("Животные", "Птицы", "Рыба"));
        } catch (Exception e) {
            Assert.fail("Внештатная ситуация");
        }

        //Кейс когда метод eatMeat() класса Feline возвращает Exception

        try {
            Mockito.when(felineMock.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
            felineMock.eatMeat();
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

    /**
     * Тестирование метода класса {@link Feline#getFamily()}
     */
    @Test
    public void TestMethodFelineGetFamily() {
        Assert.assertEquals(feline.getFamily(), "Кошачьи");
    }

    /**
     * Тестирование метода класса {@link Feline#getKittens()}
     */
    @Test
    public void TestMethodFelineGetKittens() {
        Assert.assertEquals(feline.getKittens(), 1);
    }

    /**
     * Тестирование метода класса {@link Feline#getKittens(int)}
     */
    @Test
    public void TestMethodFelineGetKittensWithParam() {
      Assert.assertEquals(feline.getKittens(1), 1);
    }
}
