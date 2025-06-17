package tetris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private final UserInput userInput = new UserInput();
    private final MoveValidator moveValidator = new MoveValidator();

    private int rows;
    private int columns;

    private final List<Cell> cellsList = new ArrayList<>();
    private final List<Cell> pieceCells = new ArrayList<>();
    private final List<Cell> cellsRow = new ArrayList<>();

    private Cell[][] piece = null;
    private int countAllMoves = 0;
    private int countRotation = 0;
    private int countLeftRight = 0;

    private Grid createGrid() {
        String[] inputDimensions = userInput.inputDimensions();
        int columns = Integer.parseInt(inputDimensions[0]);
        int rows = Integer.parseInt(inputDimensions[1]);

        return new Grid(rows, columns);
    }

    public void playGame() {
        Grid grid = createGrid();
        rows = grid.getRows();
        columns = grid.getColumns();

        while (true) {
            grid.print();
            String inputAction = userInput.inputAction();
            handleAction(inputAction);

            grid.reset();

            pieceCells.forEach(grid::setSymbolAtCell);

            cellsList.forEach(grid::setSymbolAtCell);

            moveValidator.checkingGameOver(columns, rows, grid.getListOfOccupiedCells());
        }
    }

    private void handleAction(String inputAction) {
        switch (inputAction) {
            case "exit" -> System.exit(0);
            case "break" -> handleBreak();
            case "piece" -> handlePiece();
            case "rotate" -> handleRotate();
            case "left" -> handleLeft();
            case "right" -> handleRight();
            case "down" -> handleDown();
            default -> System.out.println("Wrong input");
        }
    }

    private void handleDown() {
        if (moveValidator.canGoDown(pieceCells, cellsList, rows)) {
            pieceCells.replaceAll(cell -> new Cell(cell.getRow() + 1, cell.getColumn()));
            countAllMoves++;
        }
    }

    private void handleRight() {
        if (moveValidator.canGoDown(pieceCells, cellsList, rows)) {
            if (moveValidator.canGoRight(pieceCells, cellsList, columns)) {
                pieceCells.replaceAll(cell -> new Cell(cell.getRow(), cell.getColumn() + 1));
                countLeftRight++;
            }
            pieceCells.replaceAll(cell -> new Cell(cell.getRow() + 1, cell.getColumn()));
            countAllMoves++;
        }
    }

    private void handleLeft() {
        if (moveValidator.canGoDown(pieceCells, cellsList, rows)) {
            if (moveValidator.canGoLeft(pieceCells, cellsList)) {
                pieceCells.replaceAll(cell -> new Cell(cell.getRow(), cell.getColumn() - 1));
                countLeftRight--;
            }
            pieceCells.replaceAll(cell -> new Cell(cell.getRow() + 1, cell.getColumn()));
            countAllMoves++;
        }
    }

    private void handleRotate() {
        if (moveValidator.canGoDown(pieceCells, cellsList, rows)) {
            countRotation++;
            countAllMoves++;
            pieceCells.clear();
            if (!moveValidator.canRotate(Arrays.asList(piece[countRotation % piece.length]), cellsList, rows, countAllMoves, countLeftRight)) {
                countRotation--;
            }
            pieceCells.addAll(Arrays.asList(piece[countRotation % piece.length]));
            pieceCells.replaceAll(cell -> new Cell(cell.getRow() + countAllMoves, cell.getColumn() + countLeftRight));
        }
    }

    private void handlePiece() {
        resetGameState();

        piece = Pieces.valueOf(userInput.inputPiece()).getCells();
        pieceCells.addAll(Arrays.asList(piece[0]));
    }

    private void handleBreak() {
        resetGameState();

        int countRows = 0;
        int row;
        for (int i = rows - 1; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < columns; j++) {
                Cell cell = new Cell(i, j);
                if (cellsList.contains(cell)) {
                    count++;
                    cellsRow.add(cell);
                }
            }
            if (count == columns) {
                cellsList.removeAll(cellsRow);
                row = i;
                for (int x = 0; x < cellsList.size(); x++) {
                    if (cellsList.get(x).getRow() < row) {
                        Cell cell = new Cell(cellsList.get(x).getRow() + countRows, cellsList.get(x).getColumn());
                        cellsList.set(x, cell);
                    }
                }
            }
            cellsRow.clear();
        }
    }

    private void resetGameState() {
        pieceCells.stream()
                .filter((cell) -> !cellsList.contains(cell))
                .forEach(cellsList::add);

        countAllMoves = 0;
        countRotation = 0;
        countLeftRight = 0;
        pieceCells.clear();
    }
}
