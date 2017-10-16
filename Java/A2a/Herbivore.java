package ca.bcit.comp2526.a2a;

import java.awt.Color;

/**
 * Herbivore.java
 * Herbivore that extends cell and acts like Herbivore.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Herbivore extends Cell {

    private static final Color PLANT_COLOR = Color.yellow;
    private World world;
    private Cell location;
    private int row;
    private int column;
    
    /**
     * 
     * @param location
     */
    public Herbivore(Cell location) {
        super(location.getWorld(), location.getRow(), location.getColumn());
        world = location.getWorld();
        this.location = location;
        row = location.getRow();
        column = location.getColumn();
    }
    
    public void setCell(Cell location) {
        
    }
    
    public void move() {
        eat();
    }
    
    private void eat() {
        
    }
    
    public void detectPlant() {
        
    }
    
    public void detectEmpty() {
        
    }

}
