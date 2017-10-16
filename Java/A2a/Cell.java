package ca.bcit.comp2526.a2a;

import java.awt.Component;
import java.awt.Point;

/**
 * Cell.java
 * Cell class that extends Component can be either plant or herbivore.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Cell extends Component {
    
    private static final float PLANT_PERCENTAGE = 0.3f;
    private static final float HERBIVORE_PERCENTAGE = 0.2f;
    private final int row;
    private final int column;
    private final World world;
    private final Point location;
    private Plant plant;
    private Herbivore herbivore;

    /**
     * Constructor that makes a cell inside the world.
     * @param world is the base of the cell
     * @param xCoordinate of the cell
     * @param yCoordinate of the cell
     */
    public Cell(World world, int xCoordinate, int yCoordinate) {
        
        row = xCoordinate;
        column = yCoordinate;
        location = new Point(row, column);
        this.world = world;
    }
    
    /**
     * initializes Cell, based on the world size.
     */
    public void init() {
        
    }
    
    public Point getLocation() {
        return location;
        
    }
    
    public Cell[] getAdjacentCells() {
        return null;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getColumn() {
        return column;
    }
    
    public World getWorld() {
        return world;
    }
    
    public void setPlant(Plant plant) {
        this.plant = plant;
    }
    
    public Plant getPlant() {
        return plant;
    }
    
    public void removePlant() {
        plant = null;
    }
    
    public void setHerbivore(Herbivore herbivore) {
        this.herbivore = herbivore;
    }
    
    public Herbivore getHerbivore() {
        return herbivore;
    }
    
    public void removeHerbivore() {
        herbivore = null;
    }
}
