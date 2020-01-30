package com.epam.esp;

public class Size {
    private int height;
    private int width;

    public Size() {
        height = 1;
        width = 1;
    }

    public Size(int height, int width) {
        if (height < 1 || width < 1) {
            throw new IllegalArgumentException("Wrong size matrix (" + height + " " + width + ")");
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

    public boolean checkSquare() {
        return height == width;
    }

    public boolean entryPosition(int height, int width) {
        return (height >= 0 && width >= 0) && (height < this.height && width < this.width);
    }

    public boolean equals(Object compareSize) {
        Size compare = (Size) compareSize;
        return height == compare.getHeight() && width == compare.getWidth();
    }

    @Override
    public Size clone() {
        return new Size(this.height, this.width);
    }
}
