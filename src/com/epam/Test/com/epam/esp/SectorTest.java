package com.epam.esp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SectorTest {

    @Test
    public void testConstructorSize() throws Exception {
        CellState[][] data = {{CellState.HUMAN, CellState.EMPTY},
                {CellState.EMPTY, CellState.EMPTY}};
        Sector sector = new Sector(data);
        assertTrue(new Size(2, 2).equals(sector.getSize()));
        assertTrue(Arrays.deepEquals(data, sector.getData()));
    }

    @Test
    public void testGetSize() throws Exception {
        Sector sector = new Sector(new Size(2, 2));
        assertTrue(new Size(2, 2).equals(sector.getSize()));
    }

    @Test
    public void testGetData() throws Exception {
        Sector sector = new Sector(new Size(2, 2));
        CellState[][] result = {{CellState.EMPTY, CellState.EMPTY},
                {CellState.EMPTY, CellState.EMPTY}};
        assertTrue(Arrays.deepEquals(result, sector.getData()));
    }

    @Test
    public void testGetCellState() throws Exception {
        Sector sector = new Sector(new Size(2, 2));
        assertTrue(CellState.EMPTY == sector.getCellState(new Position(0, 0)));
    }

    @Test
    public void testSetCellState() throws Exception {
        Sector sector = new Sector(new Size(2, 2));
        sector.setCellState(new Position(1, 1), CellState.HUMAN);
        assertTrue(CellState.HUMAN == sector.getCellState(new Position(1, 1)));
    }

    @Test
    public void reflexiveEquals() throws Exception {
        assertTrue(new Sector(new Size(2, 2)).equals(new Sector(new Size(2, 2))));
    }

    @Test
    public void differDimenEquals() throws Exception {
        assertFalse(new Sector(new Size(3, 2)).equals(new Sector(new Size(2, 2))));
        assertFalse(new Sector(new Size(2, 2)).equals(new Sector(new Size(3, 2))));
    }

    @Test
    public void testClone() throws Exception {
        Sector sector = new Sector(new Size(2, 2));
        Sector copy = sector.clone();
        assertTrue(sector.equals(copy));
        sector.setCellState(new Position(1, 1), CellState.HUMAN);
        assertFalse(sector.equals(copy));
    }
}