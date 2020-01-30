package com.epam.esp;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class LocatorEpsTest {
    public static List<RiskGroup> getPossibleRiskGroups() {
        return Arrays.asList(new RiskGroup("NONE", new Range(1, 2)), new RiskGroup("MINOR", new Range(3, 4)),
                new RiskGroup("NORMAL", new Range(5, 7)), new RiskGroup("MAJOR", new Range(8, 13)),
                new RiskGroup("CRITICAL", new Range(14, Integer.MAX_VALUE)));
    }

    @Test
    public void testFindOutSituation() throws Exception {
        Locator locator = new LocatorEps(getPossibleRiskGroups());
        CellState[][] cellStates = {{CellState.HUMAN, CellState.EMPTY},
                {CellState.EMPTY, CellState.HUMAN}};
        Sector sector = new Sector(cellStates);
        locator.findOutSituation(sector);
        String map = locator.toStringGroups();
        String result = "NONE 2\n" +
                "MINOR 0\n" +
                "NORMAL 0\n" +
                "MAJOR 0\n" +
                "CRITICAL 0\n";
        assertTrue(map.equals(result));
    }

    @Test
    public void testMinorFindOutSituation() throws Exception {
        Locator locator = new LocatorEps(getPossibleRiskGroups());
        CellState[][] cellStates = {{CellState.EMPTY, CellState.HUMAN, CellState.HUMAN},
                {CellState.HUMAN, CellState.HUMAN, CellState.EMPTY}};
        Sector sector = new Sector(cellStates);
        locator.findOutSituation(sector);
        String map = locator.toStringGroups();
        String result = "NONE 0\n" +
                "MINOR 1\n" +
                "NORMAL 0\n" +
                "MAJOR 0\n" +
                "CRITICAL 0\n";
        assertTrue(map.equals(result));
    }

    @Test
    public void testNormalFindOutSituation() throws Exception {
        Locator locator = new LocatorEps(getPossibleRiskGroups());
        CellState[][] cellStates = {{CellState.EMPTY, CellState.HUMAN, CellState.HUMAN},
                {CellState.HUMAN, CellState.HUMAN, CellState.EMPTY},
                {CellState.EMPTY, CellState.HUMAN, CellState.HUMAN}};
        Sector sector = new Sector(cellStates);
        locator.findOutSituation(sector);
        String map = locator.toStringGroups();
        String result = "NONE 0\n" +
                "MINOR 0\n" +
                "NORMAL 1\n" +
                "MAJOR 0\n" +
                "CRITICAL 0\n";
        assertTrue(map.equals(result));
    }

    @Test
    public void testMajorFindOutSituation() throws Exception {
        Locator locator = new LocatorEps(getPossibleRiskGroups());
        CellState[][] cellStates = {{CellState.EMPTY, CellState.HUMAN, CellState.HUMAN, CellState.EMPTY, CellState.EMPTY},
                {CellState.HUMAN, CellState.HUMAN, CellState.EMPTY, CellState.EMPTY, CellState.EMPTY},
                {CellState.EMPTY, CellState.HUMAN, CellState.HUMAN, CellState.EMPTY, CellState.EMPTY},
                {CellState.HUMAN, CellState.HUMAN, CellState.EMPTY, CellState.EMPTY, CellState.EMPTY},
                {CellState.EMPTY, CellState.EMPTY, CellState.EMPTY, CellState.EMPTY, CellState.EMPTY}};
        Sector sector = new Sector(cellStates);
        locator.findOutSituation(sector);
        String map = locator.toStringGroups();
        String result = "NONE 0\n" +
                "MINOR 0\n" +
                "NORMAL 0\n" +
                "MAJOR 1\n" +
                "CRITICAL 0\n";
        assertTrue(map.equals(result));
    }

    @Test
    public void testCriticalFindOutSituation() throws Exception {
        Locator locator = new LocatorEps(getPossibleRiskGroups());
        CellState[][] cellStates = {{CellState.EMPTY, CellState.HUMAN, CellState.HUMAN, CellState.HUMAN, CellState.EMPTY},
                {CellState.HUMAN, CellState.HUMAN, CellState.EMPTY, CellState.EMPTY, CellState.EMPTY},
                {CellState.EMPTY, CellState.HUMAN, CellState.HUMAN, CellState.HUMAN, CellState.HUMAN},
                {CellState.HUMAN, CellState.HUMAN, CellState.EMPTY, CellState.EMPTY, CellState.EMPTY},
                {CellState.EMPTY, CellState.HUMAN, CellState.HUMAN, CellState.HUMAN, CellState.HUMAN}};
        Sector sector = new Sector(cellStates);
        locator.findOutSituation(sector);
        String map = locator.toStringGroups();
        String result = "NONE 0\n" +
                "MINOR 0\n" +
                "NORMAL 0\n" +
                "MAJOR 0\n" +
                "CRITICAL 1\n";
        assertTrue(map.equals(result));
    }
}
