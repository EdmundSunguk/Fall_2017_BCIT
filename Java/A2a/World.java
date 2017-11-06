package ca.bcit.comp2526.a2a;

import java.awt.Color;

/**
 * World.java
 * World class that construct the world of cells.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class World {
    
    private static final int MAX_PERCENTAGE = 100;
    private static final int PERCENTAGE_HERBIVORE = 80;
    private static final int PERCENTAGE_PLANT = 50;
    private Cell[][] cell;
    private int worldSizeRow;
    private int worldSizeColumn;
    private int random;

    /**
     * Constructor that creates the world.
     * @param worldSize width of the world
     * @param worldSize2 height of the world
     */
    public World(int worldSize, int worldSize2) {
        this.worldSizeRow = worldSize2;
        this.worldSizeColumn = worldSize;   
        cell = new Cell[worldSizeColumn][worldSizeRow];
    }

    /**
     * initializes world objects.
     */
    public void init() {

        for (int i = 0; i < worldSizeColumn; i++) {
            for (int j = 0; j < worldSizeRow; j++) {
                random = RandomGenerator.nextNumber(MAX_PERCENTAGE);
                cell[i][j] = new Cell(this, i, j);
                if (random > PERCENTAGE_HERBIVORE) {
//                    cell[i][j] = new Herbivore(new Cell(this, i, j));
                    cell[i][j].setLifeForm(LifeForm.HERBIVORE);
                } else if (random > PERCENTAGE_PLANT) {
//                    cell[i][j] = new Plant(new Cell(this, i, j));
                    cell[i][j].setLifeForm(LifeForm.PLANT);
                } else {
//                    cell[i][j] = new Cell(this, i, j);
                    cell[i][j].setLifeForm(LifeForm.NATURE);
                }
                cell[i][j].init();
            }
        }
    }

    /**
     * gets row number.
     * @return row number
     */
    public int getRowCount() {
        return worldSizeRow;
    }
    
    /**
     * gets column number.
     * @return column number
     */
    public int getColumnCount() {
        return worldSizeColumn;
    }

    /**
     * gets one specific Cell.
     * @param rowInput used for identifying specific Cell element in an array
     * @param colInput used for identifying specific Cell element in an array
     * @return one element of the cell array
     */
    public Cell getCellAt(int colInput, int rowInput) {
        
//        System.out.println(cell[colInput][rowInput].getClass());
//        System.out.println(cell[colInput][rowInput].getLifeForm());
        return cell[colInput][rowInput];
    }
    
    /**
     * removes dead herbivores, checks each plant to see if it seeds
     * and then moves remaining living Herbivores one Cell.
     * (and they eat, if possible)
     */
    public void takeTurn() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if (cell[i][j].getCreature() != null) {
                    cell[i][j].getCreature().setBaby(false);                                    
                }
            }
        }
        for (int i = 0; i < worldSizeColumn; i++) {
            for (int j = 0; j < worldSizeRow; j++) {
                cell[i][j].takeTurn();
                cell[i][j].init();
            }
        }
//        System.out.println("-----------------");
//        System.out.println(cell[0][0].getClass());
//        System.out.println(cell[0][0].getLifeForm());
//        cell[0][0].setLifeForm(LifeForm.NATURE);
//        cell[0][0].init();
//        cell[0][0].takeTurn();
//        System.out.println(cell[0][0].getLifeForm());
//        System.out.println(cell[0][0].getClass());
    }   
}
