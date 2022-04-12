package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() throws Exception {
        cat = new Cat(feline);
    }

    @Test
    public void getSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
       Mockito.when(feline.eatMeat()).thenReturn(List.of("Съел"));
        List<String> result = cat.getFood();
        assertEquals(1, result.size());
        assertEquals("Съел", result.get(0));
    }

    @Test
    public void predatorEatMeatThrowsException() throws Exception {
        Mockito.when(feline.eatMeat()).thenThrow(new Exception("Тест"));
        try {
            cat.getFood();
        } catch (Exception e) {
            assertEquals("Тест", e.getMessage());
            return;
        }
        fail("Should have thrown an exception");
    }
}
