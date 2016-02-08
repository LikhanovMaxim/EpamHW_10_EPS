package com.epam.esp;

public class Range {
    private final int min;
    private final int max;

    public Range(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("In the constructor Range min(" + min + ") more than max(" + max + ")");
        }
        this.min = min;
        this.max = max;
    }

    public boolean in(int value) {
        return value >= min && value <= max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    protected Object clone() {
        return new Range(min, max);
    }

    @Override
    public boolean equals(Object obj) {
        Range comp = (Range) obj;
        return comp.getMin() == min && comp.getMax() == max;
    }
}
