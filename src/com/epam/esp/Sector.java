package com.epam.esp;

import java.util.Arrays;

public class Sector {
    private final CellState[][] data;
    private Size size;

    public Sector(CellState[][] data) {
        this.size = new Size(data.length, data[0].length);
        this.data = new CellState[size.getHeight()][size.getWidth()];
        for (int height = 0; height < size.getHeight(); height++) {
            for (int width = 0; width < size.getWidth(); width++) {
                this.data[height][width] = data[height][width];
            }
        }
    }

    public Sector(Size size) {
        this.size = size.clone();
        data = new CellState[size.getHeight()][size.getWidth()];
        for (int height = 0; height < size.getHeight(); height++) {
            for (int width = 0; width < size.getWidth(); width++) {
                data[height][width] = CellState.EMPTY;
            }
        }
    }

    public Size getSize() {
        return size.clone();
    }


    public CellState[][] getData() {
        return data.clone();
    }

    public CellState getCellState(Position position) {
        if (!position.entrySize(size)) {
            throw new ArrayIndexOutOfBoundsException("getCellState");
        }
        return data[position.getHeight()][position.getWidth()];
    }

    public void setCellState(Position position, CellState state) {
        if (!position.entrySize(size)) {
            throw new ArrayIndexOutOfBoundsException("getCellState");
        }
        data[position.getHeight()][position.getWidth()] = state;
    }

    public boolean equals(Object compareSector) {
        Sector compare = (Sector) compareSector;
        return size.equals(compare.getSize()) && Arrays.deepEquals(data, compare.getData());
    }

    @Override
    public Sector clone() {
        Sector result = new Sector(size);
        for (int height = 0; height < size.getHeight(); height++) {
            for (int width = 0; width < size.getWidth(); width++) {
                result.setCellState(new Position(height, width), getCellState(new Position(height, width)));
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int height = 0; height < size.getHeight(); height++) {
            for (int width = 0; width < size.getWidth(); width++) {
                if (data[height][width] == CellState.HUMAN) {
                    result += "HUMAN ";
                } else {
                    result += "EMPTY ";
                }
            }
            result += "\n";
        }
        return result;
    }
}