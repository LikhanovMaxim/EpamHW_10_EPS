package com.epam.esp;

public class Position {
    private int height;
    private int width;

    public Position() {
        height = 0;
        width = 0;
    }

    public Position(int height, int width) {
        if (height < 0 || width < 0) {
            this.height = -1;
            this.width = -1;
        } else {
            this.height = height;
            this.width = width;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean entrySize(Size size) {
        return height >= 0 && width >= 0 && height < size.getHeight() && width < size.getWidth();
    }

    @Override
    public String toString() {
        return getHeight() + " " + getWidth();
    }
}
