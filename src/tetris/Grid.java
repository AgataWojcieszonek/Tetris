package tetris;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final Cell[][] matrix;
    private final int columns;
    private final int rows;

    Grid(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;
        this.matrix = createGrid(rows, columns);
    }

    private Cell[][] createGrid(int rows, int columns) {
        Cell[][] grid = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = new Cell(i, j);
                grid[i][j].setSymbol("-");
            }
        }
        return grid;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setSymbolAtCell(Cell cell) {
        matrix[cell.getRow()][cell.getColumn()].setSymbol("0");
    }

    public void reset() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j].setSymbol("-");
            }
        }
    }

    public List<Cell> getListOfOccupiedCells() {
        List<Cell> pieceCoordinates = new ArrayList<>();
        for (Cell[] cells : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                Cell cell = cells[j];
                if (cell.getSymbol().equals("0")) {
                    pieceCoordinates.add(cell);
                }
            }
        }
        return pieceCoordinates;
    }

}
