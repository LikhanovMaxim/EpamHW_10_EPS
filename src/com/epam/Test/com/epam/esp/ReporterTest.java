package com.epam.esp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ReporterTest {
    public static List<RiskGroup> getPossibleRiskGroups() {
        return Arrays.asList(new RiskGroup("NONE", new Range(1, 2)), new RiskGroup("MINOR", new Range(3, 4)),
                new RiskGroup("NORMAL", new Range(5, 7)), new RiskGroup("MAJOR", new Range(8, 13)),
                new RiskGroup("CRITICAL", new Range(14, Integer.MAX_VALUE)));
    }

    @Test
    public void testHumanCreateReport() throws Exception {
        CellState[][] data = {{CellState.HUMAN, CellState.HUMAN},
                {CellState.HUMAN, CellState.HUMAN}};
        Sector sector = new Sector(data);
        Locator locator = new LocatorEps(getPossibleRiskGroups());
        Map<RiskGroup, Integer> situation = locator.findOutSituation(sector);
        Reporter reporter = new Reporter();
        String result = "2 2\n" +
                "1.0\n" +
                "NONE 0\n" +
                "MINOR 1\n" +
                "NORMAL 0\n" +
                "MAJOR 0\n" +
                "CRITICAL 0\n" +
                "\n" +
                "Emergency Prevention System\n" +
                "------------------------------------------------------------\n" +
                "------------------------------------------------------------\n" +
                "    0  1 \n" +
                " 0 |X||X|\n" +
                " 1 |X||X|\n" +
                "\n" +
                "Risk groups report:\n" +
                "------------------------------------------------------------\n" +
                "NONE: 0 groups;\n" +
                "MINOR: 1 groups;\n" +
                "NORMAL: 0 groups;\n" +
                "MAJOR: 0 groups;\n" +
                "CRITICAL: 0 groups;\n";
        assertTrue(result.equals(reporter.createReport(getPossibleRiskGroups(), 1, sector, situation)));
    }

    @Test
    public void testEmptyCreateReport() throws Exception {
        CellState[][] data = {{CellState.EMPTY, CellState.EMPTY},
                {CellState.EMPTY, CellState.EMPTY}};
        Sector sector = new Sector(data);
        Locator locator = new LocatorEps(getPossibleRiskGroups());
        Map<RiskGroup, Integer> situation = locator.findOutSituation(sector);
        Reporter reporter = new Reporter();
        String result = "2 2\n" +
                "0.0\n" +
                "NONE 0\n" +
                "MINOR 0\n" +
                "NORMAL 0\n" +
                "MAJOR 0\n" +
                "CRITICAL 0\n" +
                "\n" +
                "Emergency Prevention System\n" +
                "------------------------------------------------------------\n" +
                "------------------------------------------------------------\n" +
                "    0  1 \n" +
                " 0  -  - \n" +
                " 1  -  - \n" +
                "\n" +
                "Risk groups report:\n" +
                "------------------------------------------------------------\n" +
                "NONE: 0 groups;\n" +
                "MINOR: 0 groups;\n" +
                "NORMAL: 0 groups;\n" +
                "MAJOR: 0 groups;\n" +
                "CRITICAL: 0 groups;\n";
        assertTrue(result.equals(reporter.createReport(getPossibleRiskGroups(), 0, sector, situation)));
    }
}