package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 * Cell.java
 * Cell class that extends Component can be either plant or herbivore.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Cell extends JPanel {
    
    private static final Color BACKGROUND_COLOR = Color.white;
    private static final Color LINE_COLOR = Color.black;
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
    
    public void paintComponent(Graphics g) {
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, row, column);
        g.setColor(LINE_COLOR);
        g.drawRect(0, 0, row, column);
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
