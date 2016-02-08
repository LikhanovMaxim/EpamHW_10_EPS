package com.epam.esp;

import java.util.Random;

public class SectorSource {
    private static Random random = new Random();
    private final Size size;
    private final double fillFactor;

    public SectorSource(Size size, double fillFactor) {
        this.size = size.clone();
        this.fillFactor = fillFactor;
    }

    public Sector getSector() {
        Sector sector = new Sector(size);
        fillArea(sector);
        return sector;
    }

    /*
    *@param sector (in, out)
     */

    private void fillArea(Sector sector) {
        for (int height = 0; height < sector.getSize().getHeight(); height++) {
            for (int width = 0; width < sector.getSize().getWidth(); width++) {
                if (random.nextDouble() < fillFactor) {
                    sector.setCellState(new Position(height, width), CellState.HUMAN);
                } else {
                    sector.setCellState(new Position(height, width), CellState.EMPTY);
                }
            }
        }
    }

}