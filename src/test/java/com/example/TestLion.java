package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;


@RunWith(MockitoJUnitRunner.class)

public class TestLion {


    // Изолирование класса Lion от Feline в тестах
    @Mock
    Feline feline;

    /**
     * Тестирование конструктора класса {@link Lion}
     *
     * @throws Exception
     */
    @Test
    public void testConstrLion() throws Exception {
        Lion lion = new Lion("Самец");
        Assert.assertTrue(lion.doesHaveMane());
        Lion lionFemale = new Lion("Самка");
        Assert.assertFalse(lionFemale.doesHaveMane());
        try {
            new Lion("123");
            Assert.fail("Внештатная ситуация ситуация");
        } catch (Exception t) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", t.getMessage());
        }
    }

    /**
     * Тестирование метода {@link Lion#getKittens()}
     */
    @Test
    public void testMethodLionGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline);
        Assert.assertEquals(lion.getKittens(), 1);
    }

    /**
     * Тестирование метода {@link Lion#getFood()}
     */
    @Test
    public void testMethodLionGetFood() {
        // Кейс когда в метод getFood() класса Lion возвращается "List.of("Животные", "Птицы", "Рыба")"
        try {
            Mockito.when(feline.getFood(any())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Lion lion = new Lion(feline);
            Assert.assertEquals(lion.getFood(), List.of("Животные", "Птицы", "Рыба"));
        } catch (Exception e) {
            Assert.fail("Внештатная ситуация");
        }

        // Кейс когда в метод getFood() класса Lion возвращается Exception
        try {
            Mockito.when(feline.getFood(any())).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
            new Lion(feline).getFood();
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }
}