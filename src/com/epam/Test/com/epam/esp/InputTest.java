package com.epam.esp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputTest {

    @Test
    public void testGetSize() throws Exception {
        Input input = new Input(new Size(3, 4), 0.5);
        assertTrue(new Size(3, 4).equals(input.getSize()));
    }

    @Test
    public void testGetFillFactor() throws Exception {
        Input input = new Input(new Size(3, 4), 0.5);
        assertTrue(0.5 == input.getFillFactor());
    }

    @Test
    public void testNegativeGetFillFactor() throws Exception {
        Input input = new Input(new Size(3, 4), -2);
        assertTrue(-2 == input.getFillFactor());
    }

    @Test
    public void testMoreOneGetFillFactor() throws Exception {
        Input input = new Input(new Size(3, 4), 4);
        assertTrue(4 == input.getFillFactor());
    }

    @Test
    public void testReflexivityEquals() throws Exception {
        assertTrue(new Input(new Size(3, 4), 1).equals(new Input(new Size(3, 4), 1)));
    }

    @Test
    public void testDifferentSizeEquals() throws Exception {
        assertFalse(new Input(new Size(3, 4), 1).equals(new Input(new Size(91, 4), 1)));
    }

    @Test
    public void testDifferentFillFactorEquals() throws Exception {
        assertFalse(new Input(new Size(3, 4), 0).equals(new Input(new Size(91, 4), 1)));
    }

    @Test
    public void testClone() throws Exception {
        Input input = new Input(new Size(3, 3), 1);
        Input copy = input.clone();
        assertTrue(input.equals(copy));
    }
}