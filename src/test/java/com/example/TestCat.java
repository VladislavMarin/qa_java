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
public class TestCat {

    Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Mock
    Feline feline;

    /**
     * Тестирование метода {@link Cat#getSound()}
     */
    @Test
    public void testMethodCatGetSound() {
        Assert.assertEquals(cat.getSound(), "Мяу");
    }

    /**
     * Тестирование метода {@link Cat#getFood()}
     */
    @Test
    public void testMethodCatGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(cat.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }
}
