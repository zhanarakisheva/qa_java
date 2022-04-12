package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineGetKittensWithArgumentsTest {

    private Feline feline;
    private final int kittensCount;
    private final int expected;

    public FelineGetKittensWithArgumentsTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Before
    public void setUp() throws Exception {
        feline = new Feline();
    }

    @Parameterized.Parameters
    public static Object[] getParameters() {
        return new Object[][]{
                {1, 1},
                {-1, -1},
                {0, 0},
                {2147483647,2147483647},
                {-2147483648, -2147483648},// передали тестовые данные
        };
    }

    @Test
    public void kittensCount() {
        Assert.assertEquals(expected, feline.getKittens(kittensCount));
    }
}
