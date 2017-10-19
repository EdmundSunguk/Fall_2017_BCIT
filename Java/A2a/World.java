package ca.bcit.comp2526.a2a;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * World.java
 * World class that construct the world of cells.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class World {
    
    private static final int MAX_PERCENTAGE = 99;
    private static final int PERCENTAGE_HERBIVORE = 80;
    private static final int PERCENTAGE_PLANT = 50;
    private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();;
    private final int widthOfCell;
    private final int heightOfCell;
    private final Cell[][] cell;
    private int worldSizeRow;
    private int worldSizeColumn;

    /**
     * Constructor that creates the world.
     * @param worldSize width of the world
     * @param worldSize2 height of the world
     */
    public World(int worldSize, int worldSize2) {
        
        final Dimension screenSize;
        screenSize = TOOLKIT.getScreenSize();
        widthOfCell = screenSize.width / worldSize2;
        heightOfCell = screenSize.height / worldSize;
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
                int randomNumber = RandomGenerator.nextNumber(MAX_PERCENTAGE);
                if (randomNumber >= PERCENTAGE_HERBIVORE) {
                    cell[i][j] = new Herbivore(new Cell(this,
                            widthOfCell, heightOfCell));
                } else if (randomNumber >= PERCENTAGE_PLANT) {
                    cell[i][j] = new Plant(new Cell(this,
                            widthOfCell, heightOfCell));
                } else {
                    cell[i][j] = new Cell(this, widthOfCell, heightOfCell);
                }
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
        return cell[colInput][rowInput];
    }

    /**
     * removes dead herbivores, checks each plant to see if it seeds
     * and then moves remaining living Herbivores one Cell.
     * (and they eat, if possible)
     */
    public void takeTurn() {
        // TODO Auto-generated method stub
        
    }

}
