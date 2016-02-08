package com.epam.esp;

import java.util.List;
import java.util.Map;

public class Reporter {
    public String createReport(List<RiskGroup> possibleGroups, double fillFactor, Sector sector, Map<RiskGroup, Integer> situation) {
        StringBuilder result = new StringBuilder();
        result.append(sector.getSize().getHeight()).append(" ").append(sector.getSize().getWidth()).append("\n");
        result.append(fillFactor).append("\n");
        result.append(getSituation(possibleGroups, situation)).append("\n");
        result.append(getHeader());
        result.append(getLine());
        result.append(getLine());
        result.append(getSectorView(sector));
        result.append(getAfterSector());
        result.append(getLine());
        result.append(getSituationView(possibleGroups, situation));
        return result.toString();
    }

    private String getSituation(List<RiskGroup> situation, Map<RiskGroup, Integer> result) {
        String res = "";
        for (RiskGroup e : situation) {
            res += e.getName();
            for (Map.Entry<RiskGroup, Integer> entry : result.entrySet()) {
                if (entry.getKey().getName().equals(e.getName())) {
                    res += " " + entry.getValue() + "\n";
                }
            }
        }
        return res;
    }

    private String getSituationView(List<RiskGroup> situation, Map<RiskGroup, Integer> result) {
        String res = "";
        for (RiskGroup e : situation) {
            res += e.getName() + ": ";
            for (Map.Entry<RiskGroup, Integer> entry : result.entrySet()) {
                if (entry.getKey().getName().equals(e.getName())) {
                    res += entry.getValue() + " groups;\n";
                }
            }
        }
        return res;
    }

    private String getSectorView(Sector sector) {
        StringBuilder result = new StringBuilder();
        result.append("   ");
        for (int width = 0; width < sector.getSize().getWidth(); width++) {
            result.append(" " + width + " ");
        }
        result.append("\n");
        for (int height = 0; height < sector.getSize().getHeight(); height++) {
            result.append(" " + height + " ");
            for (int width = 0; width < sector.getSize().getWidth(); width++) {
                result.append(getCellView(sector.getCellState(new Position(height, width))));
            }
            result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    private String getCellView(CellState cellState) {
        String ret = "";
        switch (cellState) {
            case HUMAN:
                ret = "|X|";
                break;
            case EMPTY:
                ret = " - ";
                break;
        }
        return ret;
    }

    private String getHeader() {
        return "Emergency Prevention System\n";
    }

    private String getLine() {
        return "------------------------------------------------------------\n";
    }

    public String getAfterSector() {
        return "Risk groups report:\n";
    }


}
