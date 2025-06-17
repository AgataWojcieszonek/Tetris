package tetris;

import java.util.List;

public class MoveValidator {

    public boolean canGoLeft(List<Cell> pieceCoordinates, List<Cell> cellsList) {
        for (Cell cell : pieceCoordinates) {
            int column = cell.getColumn();
            if (column == 0) {
                return false;
            }
            Cell cellLeft = new Cell(cell.getRow() + 1, cell.getColumn() - 1);
            if (cellsList.contains(cellLeft)) {
                return false;
            }
        }
        return true;
    }

    public boolean canGoRight(List<Cell> pieceCoordinates, List<Cell> cellsList, int columns) {
        for (Cell cell : pieceCoordinates) {
            int column = cell.getColumn();
            if (column == columns - 1) {
                return false;
            }
            Cell cellRight = new Cell(cell.getRow() + 1, cell.getColumn() + 1);
            if (cellsList.contains(cellRight)) {
                return false;
            }
        }
        return true;
    }

    public boolean canGoDown(List<Cell> pieceCoordinates, List<Cell> cellsList, int rows) {
        for (Cell cell : pieceCoordinates) {
            int row = cell.getRow();
            if (row == rows - 1) {
                return false;
            }
            Cell cellDown = new Cell(cell.getRow() + 1, cell.getColumn());
            if (cellsList.contains(cellDown)) {
                return false;
            }

        }
        return true;
    }

    public boolean canRotate(List<Cell> pieceCoordinates, List<Cell> cellsList, int rows, int countAllMoves, int countLeftRight) {
        for (Cell cell : pieceCoordinates) {
            int row = cell.getRow() + countAllMoves;
            int column = cell.getColumn() + countLeftRight;

            if (row == rows - 1) {
                return false;
            }
            if (column < 0 || column > 9) {
                return false;
            }
            Cell cellRotate = new Cell(row, column);
            if (cellsList.contains(cellRotate)) {
                return false;
            }
        }
        return true;
    }

    public void checkingGameOver(int columns, int rows, List<Cell> cellsWithO) {
        for (int i = 0; i < columns; i++) {
            int count = 0;
            for (int j = 0; j < rows; j++) {
                Cell cell = new Cell(j, i);
                if (cellsWithO.contains(cell)) {
                    count++;
                }

            }
            if (count == rows) {
                System.out.println("Game Over!");
                System.exit(0);
            }
        }
    }
}
