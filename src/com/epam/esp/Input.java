package com.epam.esp;

public class Input {
    private Size size;
    private double fillFactor;

    public Input(Size size, double fillFactor) {
        this.size = size.clone();
        this.fillFactor = fillFactor;
    }

    public Size getSize() {
        return size;
    }

    public double getFillFactor() {
        return fillFactor;
    }

    public boolean equals(Object compareInput) {
        Input compare = (Input) compareInput;
        return size.equals(compare.getSize()) && fillFactor == compare.getFillFactor();
    }

    @Override
    public Input clone() {
        return new Input(size, fillFactor);
    }
}

