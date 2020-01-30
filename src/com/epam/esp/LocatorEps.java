package com.epam.esp;

import java.util.*;

public class LocatorEps implements Locator {
    private Map<RiskGroup, Integer> result;
    private List<RiskGroup> possibleRiskGroups;
    private Sector copyData;
    private Size size;
    private Stack<Position> positions;

    public LocatorEps(List<RiskGroup> possibleRiskGroups) {
        this.possibleRiskGroups = possibleRiskGroups;
        result = new HashMap<>();
        for (RiskGroup possibleRiskGroup : possibleRiskGroups) {
            result.put(possibleRiskGroup, 0);
        }
    }

    public Map<RiskGroup, Integer> findOutSituation(Sector sector) {
        copyData = sector.clone();
        size = sector.getSize();
        positions = new Stack<>();
        rankGroups();
        return result;
    }

    public String toStringGroups() {
        String res = "";
        for (RiskGroup e : possibleRiskGroups) {
            res += e.getName();
            for (Map.Entry<RiskGroup, Integer> entry : result.entrySet()) {
                if (entry.getKey().getName().equals(e.getName())) {
                    res += " " + entry.getValue() + "\n";
                }
            }
        }
        return res;
    }

    private void rankGroups() {
        for (int height = 0; height < size.getHeight(); height++) {
            for (int width = 0; width < size.getWidth(); width++) {
                if (copyData.getCellState(new Position(height, width)) == CellState.HUMAN) {
                    exploreGroup(new Position(height, width));
                }
            }
        }
    }

    private void exploreGroup(Position position) {
        Position cur;
        int count;
        positions.push(position);
        copyData.setCellState(position, CellState.EMPTY);
        for (count = 0; !positions.empty(); count++) {
            cur = positions.pop();
            addPositionsAround(cur);
        }
        addRisk(count);
    }

    private void addPositionsAround(Position cur) {
        if (checkPosition(new Position(cur.getHeight(), cur.getWidth() - 1))) {
            addStack(new Position(cur.getHeight(), cur.getWidth() - 1));
        }
        if (checkPosition(new Position(cur.getHeight(), cur.getWidth() + 1))) {
            addStack(new Position(cur.getHeight(), cur.getWidth() + 1));
        }
        if (checkPosition(new Position(cur.getHeight() - 1, cur.getWidth()))) {
            addStack(new Position(cur.getHeight() - 1, cur.getWidth()));
        }
        if (checkPosition(new Position(cur.getHeight() + 1, cur.getWidth()))) {
            addStack(new Position(cur.getHeight() + 1, cur.getWidth()));
        }
    }

    private boolean checkPosition(Position position) {
        return position.entrySize(size) && copyData.getCellState(position) == CellState.HUMAN;
    }

    private void addStack(Position position) {
        positions.push(new Position(position.getHeight(), position.getWidth()));
        copyData.setCellState(position, CellState.EMPTY);
    }

    private void addRisk(int risk) {
        int index = searchGroupNumber(risk);
        int sum = result.get(possibleRiskGroups.get(index)) + 1;
        result.put(possibleRiskGroups.get(index), sum);
    }

    private int searchGroupNumber(int count) {
        int index = 0;
        for (RiskGroup possibleRiskGroup : possibleRiskGroups) {
            if (possibleRiskGroup.getRange().in(count)) {
                return index;
            }
            index++;
        }
        return 0;
    }
}

