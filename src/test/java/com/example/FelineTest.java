package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() throws Exception {
        feline = new Feline();
    }

    @Test
    public void eatMeat() throws Exception {
        List<String> result = feline.eatMeat();
        assertEquals(3, result.size());
        assertEquals("Животные", result.get(0));
        assertEquals("Птицы", result.get(1));
        assertEquals("Рыба", result.get(2));
    }

    @Test
    public void getFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittens() {
        assertEquals(1, feline.getKittens());
    }


}
