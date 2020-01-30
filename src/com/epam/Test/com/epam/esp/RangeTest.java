package com.epam.esp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RangeTest {

    @Test
    public void testIn() throws Exception {
        Range range = new Range(2, 19);
        assertTrue(range.in(2));
        assertTrue(range.in(5));
        assertTrue(range.in(19));
        assertFalse(range.in(232));
        assertFalse(range.in(-23));
    }

    @Test
    public void reflexiveEquals() throws Exception {
        assertTrue(new Range(2, 19).equals(new Range(2, 19)));
    }

    @Test
    public void differDimenEquals() throws Exception {
        assertFalse(new Range(2, 19).equals(new Range(2, 83)));
        assertFalse(new Range(2, 83).equals(new Range(2, 19)));
    }

    @Test
    public void testClone() throws Exception {
        Range range = new Range(2, 19);
        Range copy = (Range) range.clone();
        assertTrue(range.equals(copy));
    }
}