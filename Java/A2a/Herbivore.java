package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Herbivore.java
 * Herbivore that extends Creature and acts like Herbivore.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Herbivore extends Creature {
    private static final int MAX_LIFE = 10;
    private World world;
    private Cell location;
    private int row;
    private int column;
    private LifeForm lifeForm;
    private int deathCounter;
    private Cell newLocation;
    private Cell[] adjacentCells;
    private Cell[] adjacentPlantCells;
    private Cell[] adjacentNatureCells;
    private boolean baby;
    
    /**
     * Construct Herbivore object.
     * @param location of the herbivore
     */
    public Herbivore(Cell location) {
//        super(location);
        this.location = location;
        world = location.getWorld();
        row = location.getRow();
        column = location.getColumn();
        lifeForm = LifeForm.HERBIVORE;
        baby = true;
        if (location.getCreature() != null) {
            deathCounter = location.getCreature().getDeathCounter();            
        }
    }
    
    /**
     * acts like herbivore. i.e. eats plants or moves.
     */
    public void act() {
        int randomNum;
        if (!this.die()) {
            if (this.detectPlant()) {
                randomNum = RandomGenerator.nextNumber(
                        adjacentPlantCells.length);
                newLocation = adjacentPlantCells[randomNum];
                location.removeHerbivore();
                location = newLocation;
                location.setHerbivore(this);
                deathCounter = 0;
            } else {
                randomNum = RandomGenerator.nextNumber(
                        adjacentNatureCells.length);
                newLocation = adjacentNatureCells[randomNum];
                location.removeHerbivore();
                location = newLocation;
                location.setHerbivore(this);
                deathCounter++;
            }
        }
    }
    
    private boolean die() {
        if (this.deathCounter == MAX_LIFE) {
            location.removeHerbivore();
            System.out.println("die!");
            return true;
        }
        return false;
    }
    
    private boolean detectPlant() {
        ArrayList<Cell> tempPlantCells = new ArrayList<Cell>();
        ArrayList<Cell> tempNatureCells = new ArrayList<Cell>();
        adjacentCells = location.getAdjacentCells();

        for (int i = 0; i < adjacentCells.length; i++) {
            if (adjacentCells[i].getLifeForm() == LifeForm.PLANT) {
                tempPlantCells.add(adjacentCells[i]);
            }
        }
        
        if (tempPlantCells.size() == 0) {
            for (int i = 0; i < adjacentCells.length; i++) {
                if (adjacentCells[i].getLifeForm() == LifeForm.NATURE) {
                    tempNatureCells.add(adjacentCells[i]);
                }
            }
        }

        adjacentPlantCells = new Cell[tempPlantCells.size()];
        adjacentNatureCells = new Cell[tempNatureCells.size()];
        for (int i = 0; i < adjacentPlantCells.length; i++) {
            adjacentPlantCells[i] = tempPlantCells.get(i);
        }
        for (int i = 0; i < adjacentNatureCells.length; i++) {
            adjacentNatureCells[i] = tempNatureCells.get(i);
        }
        
        return (adjacentPlantCells.length >= 1);
    }

}
