package ca.bcit.comp2526.a2a;

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
    private final int row;
    private final int column;
    private final Cell[][] cell;

    /**
     * Constructor that creates the world.
     * @param worldSize width of the world
     * @param worldSize2 height of the world
     */
    public World(int worldSize, int worldSize2) {
        this.row = worldSize;
        this.column = worldSize2;
        cell = new Cell[this.row][this.column];
        
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                if (RandomGenerator.nextNumber(MAX_PERCENTAGE) 
                        >= PERCENTAGE_HERBIVORE) {
                    cell[i][j] = new Herbivore(new Cell(this,
                            this.row, this.column));                    
                } else if (RandomGenerator.nextNumber(MAX_PERCENTAGE) 
                        >= PERCENTAGE_PLANT) {
                    cell[i][j] = new Plant(new Cell(this,
                            this.row, this.column));
                } else {
                    cell[i][j] = new Cell(this, this.row, this.column);
                }
            }
        }
        
        
    }

    /**
     * initializes world objects.
     */
    public void init() {
    }

    /**
     * gets row number.
     * @return row number
     */
    public int getRowCount() {
        return this.row;
    }

    /**
     * gets column number.
     * @return column number
     */
    public int getColumnCount() {
        return this.column;
    }

    /**
     * gets one specific Cell.
     * @param rowInput used for identifying specific Cell element in an array
     * @param colInput used for identifying specific Cell element in an array
     * @return one element of the cell array
     */
    public Cell getCellAt(int rowInput, int colInput) {
        return cell[rowInput][colInput];
    }

    /**
     * removes dead herbivores, checks each plant to see if it seeds
     * and then moves remaining living Herbivores one Cell (and they eat, if possible)
     */
    public void takeTurn() {
        // TODO Auto-generated method stub
        
    }

}
