package com.epam.esp;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SectorSourceTest {

    @Test
    public void testOneGetSector() throws Exception {
        CellState[][] data = {{CellState.HUMAN, CellState.HUMAN},
                {CellState.HUMAN, CellState.HUMAN}};
        Sector result = new Sector(data);
        SectorSource source = new SectorSource(new Size(2, 2), 1);
        assertTrue(result.equals(source.getSector()));
    }

    @Test
    public void testZeroGetSector() throws Exception {
        CellState[][] data = {{CellState.EMPTY, CellState.EMPTY},
                {CellState.EMPTY, CellState.EMPTY}};
        Sector result = new Sector(data);
        SectorSource source = new SectorSource(new Size(2, 2), 0);
        assertTrue(result.equals(source.getSector()));
    }
}