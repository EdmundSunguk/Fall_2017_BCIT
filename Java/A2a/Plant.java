package ca.bcit.comp2526.a2a;

import java.awt.Color;

/**
 * Plant.java
 * Plant that extends creature and acts like plants.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Plant extends Creature {

    private static final Color PLANT_COLOR = Color.green;
    private static final int MIN_EMPTY_ADJACENT_CELL = 3;
    private World world;
    private Cell location;
    private int row;
    private int column;
    private LifeForm lifeForm;
    private Cell[] adjacentCells;
    private Cell newLocation;
    private boolean baby;
    
    /**
     * Construct Plant object.
     * @param location of the plant
     */
    public Plant(Cell location) {
//        super(location);
        this.location = location;
        world = location.getWorld();
        row = location.getRow();
        column = location.getColumn();
        lifeForm = LifeForm.PLANT;
        baby = true;
    }
    
    /**
     * Empty method for the future use.
     * @param deathCounter of the plant
     */
    public void setDeathCounter(int deathCounter) {
        
    }
    
    /**
     * Empty method for the future use.
     * @return deathCoutner
     */
    public int getDeathCounter() {
        return 0;
    }
    
    /**
     * acts like plants i.e. seeds to the empty cells.
     */
    public void act() {
        adjacentCells = location.getAdjacentCells();
        for (int i = 0; i < adjacentCells.length; i++) {
            int randomNum = RandomGenerator.nextNumber(adjacentCells.length);
            if (!this.isHerbivore(adjacentCells[randomNum])
                    && this.countNearPlant(adjacentCells[randomNum]) >= 2
                    && this.countNearNature(adjacentCells[randomNum])
                    >= MIN_EMPTY_ADJACENT_CELL) {
//                newLocation = adjacentCells[randomNum];
                adjacentCells[randomNum].setPlant(this);
//                newLocation.setPlant(this);
                break;
            }            
        }
    }
    
    private boolean isHerbivore(Cell target) {
            if (target.getLifeForm() == LifeForm.HERBIVORE) {
                return true;
            }
        return false;
    }
    
    private int countNearPlant(Cell target) {
        int counter = 0;
        
        Cell[] adjacentTempCells = target.getAdjacentCells();
        for (int i = 0; i < adjacentTempCells.length; i++) {
            if (adjacentTempCells[i].getLifeForm() == LifeForm.PLANT) {
                counter++;
            }
        }
        
        return counter;
    }
    
    private int countNearNature(Cell target) {
        int counter = 0;
        
        Cell[] adjacentTempCells = target.getAdjacentCells();
        for (int i = 0; i < adjacentTempCells.length; i++) {
            if (adjacentTempCells[i].getLifeForm() == LifeForm.NATURE) {
                counter++;
            }
        }
        
        return counter;
    }
    
}
