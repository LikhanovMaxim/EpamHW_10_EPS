package com.epam.esp;

import org.apache.commons.cli.ParseException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static String main(String[] args) {
        String result = "'" + Arrays.toString(args) + "' no commands of this type. See '--help'.";
        try {
            Parser parser = new Parser();
            Input input = parser.commandLine(args);
            SectorSource sectorSource = new SectorSource(input.getSize(), input.getFillFactor());
            Sector sector = sectorSource.getSector();
            Locator locator = new LocatorEps(getPossibleRiskGroups());
            Map<RiskGroup, Integer> situation = locator.findOutSituation(sector);
            Reporter reporter = new Reporter();
            result = reporter.createReport(getPossibleRiskGroups(), input.getFillFactor(), sector, situation);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<RiskGroup> getPossibleRiskGroups() {
        return Arrays.asList(new RiskGroup("NONE", new Range(1, 2)), new RiskGroup("MINOR", new Range(3, 4)),
                new RiskGroup("NORMAL", new Range(5, 7)), new RiskGroup("MAJOR", new Range(8, 13)),
                new RiskGroup("CRITICAL", new Range(14, Integer.MAX_VALUE)));
    }
}
