package ca.bcit.comp2526.a2a;

import java.awt.Color;

/**
 * Plant.java
 * Plant that extends cell and acts like plants.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Plant extends Cell {

    private static final Color PLANT_COLOR = Color.green;
    private World world;
    private Cell location;
    private int row;
    private int column;
    
    /**
     * 
     * @param location
     */
    public Plant(Cell location) {
        super(location.getWorld(), location.getRow(), location.getColumn());
        row = location.getRow();
        column = location.getColumn();
        world = location.getWorld();
        this.location = location;
    }
    
    public void init() {
        
    }
    
    public void setCell(Cell location) {
        
    }
    
    public void seed() {
        
    }
}
