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
//    Feline feline;
    Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Mock
    Feline feline;

    @Test
    public void testMethodCatGetSound() {
        Assert.assertEquals(cat.getSound(), "Мяу");
    }

    @Test
    public void testMethodCatGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(cat.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }
}
