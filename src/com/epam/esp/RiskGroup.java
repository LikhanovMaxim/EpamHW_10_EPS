package com.epam.esp;

public class RiskGroup {
    private final String name;
    private final Range range;

    public RiskGroup(String name, Range range) {
        this.name = name;
        this.range = range;
    }

    public Range getRange() {
        return range;
    }

    public String getName() {
        return name;
    }

}
