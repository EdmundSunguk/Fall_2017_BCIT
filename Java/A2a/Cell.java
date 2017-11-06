package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Cell.java
 * Cell class that extends JPanel can be either plant or herbivore.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Cell extends JPanel {
    
    private static final Color LINE_COLOR = Color.black;
    private static final Color CELL_COLOR = Color.white;
//    private static int counter = 0;
    private int row;
    private int column;
    private final World world;
    private final Point location;
    private Creature creature;
    private LifeForm lifeForm;

    /**
     * Constructor that makes a cell inside the world.
     * @param world is the base of the cell
     * @param column number of the Cell
     * @param row number of the Cell
     */
    public Cell(World world, int column, int row) {
        this.row = row;
        this.column = column;
        this.world = world;
        location = new Point(row, column);
        lifeForm = LifeForm.NATURE;
        setBorder(BorderFactory.createLineBorder(LINE_COLOR));
    }
    
    /**
     * gets creature object.
     * @return creature
     */
    public Creature getCreature() {
        return creature;
    }
    
    /**
     * called by world.takeTurn() method, make creature act if exists.
     */
    public void takeTurn() {
        if (creature != null && !creature.getBaby()) {
            creature.act();
        }
    }
    
    /**
     * initializes Cell, based on the type of the lifeForm.
     */
    public void init() {
        if (getLifeForm() == LifeForm.PLANT) {
//            System.out.println(getLifeForm());
            creature = new Plant(this);
            this.setBackground(Color.green);
        }
        if (getLifeForm() == LifeForm.HERBIVORE) {
//            System.out.println(getLifeForm());
            creature = new Herbivore(this);
            this.setBackground(Color.yellow);
        }
        if (getLifeForm() == LifeForm.NATURE) {
//            System.out.println(getLifeForm());
            this.setBackground(CELL_COLOR);
        }
    }
    
    /**
     * gets lifeForm enum type.
     * @return lifeForm enum type
     */
    public LifeForm getLifeForm() {
        return lifeForm;
    }
    
    /**
     * sets lifeForm enum type.
     * @param lifeForm enum type
     */
    public void setLifeForm(LifeForm lifeForm) {
        this.lifeForm = lifeForm;
    }
    
    /**
     * gets lifeForm enum type.
     * @return lifeForm enum type
     */
    public Point getLocation() {
        return location;
    }
    
    /**
     * gets array of adjacent Cell. length can be 3, 5, or 8.
     * @return returnCells which is the array of adjacent Cells
     */
    public Cell[] getAdjacentCells() {
        Cell[] returnCells;
        ArrayList<Cell> tempCells = new ArrayList<Cell>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (row + j >= 0 
                        && row + j <= world.getRowCount()-1
                        && column + i >= 0 
                        && column + i <= world.getColumnCount()-1
                        && !(row + j == row
                        && column + i == column)) {
                    tempCells.add(world.getCellAt(column + i, row + j));
                }
            }
        }
        
        returnCells = new Cell[tempCells.size()];
        for (int i = 0; i < returnCells.length; i++) {
            returnCells[i] = tempCells.get(i);                
        }
        
        return returnCells;
    }
    
    /**
     * gets row number of the Cell.
     * @return row number of the cell
     */
    public int getRow() {
        return row;
    }
    
    /**
     * gets column number of the Cell.
     * @return column number of the cell
     */
    public int getColumn() {
        return column;
    }
    
    /**
     * gets the base world of the cell.
     * @return world of the cell
     */
    public World getWorld() {
        return world;
    }
    
    /**
     * sets the plant object, and make it baby.
     * @param plant object which acts like plants
     */
    public void setPlant(Plant plant) {
        creature = plant;
        creature.setBaby(true);
        lifeForm = LifeForm.PLANT;
    }
    
    /**
     * removes plant object.
     */
    public void removePlant() {
        this.creature = null;
        lifeForm = LifeForm.NATURE;
    }
    
    /**
     * sets the herbivore object, and make it baby.
     * @param herbivore object which acts like herbivore
     */
    public void setHerbivore(Herbivore herbivore) {
        creature = herbivore;
        creature.setBaby(true);
        lifeForm = LifeForm.HERBIVORE;
    }
    
    /**
     * removes herbivore object.
     */
    public void removeHerbivore() {
        this.creature = null;            
        lifeForm = LifeForm.NATURE;
    }
}
