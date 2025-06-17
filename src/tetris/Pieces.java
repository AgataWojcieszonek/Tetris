package tetris;

public enum Pieces {
    O(new Cell[][] {{new Cell(0,4),new Cell(1,4),new Cell(1,5), new Cell(0,5)}}),

    I(new Cell[][]{{new Cell(0,4),new Cell(1,4),new Cell(2,4), new Cell(3,4)},
            {new Cell(0,3),new Cell(0,4),new Cell(0,5), new Cell(0,6)}}),

    S(new Cell[][]{{new Cell(0,5),new Cell(0,4),new Cell(1,4), new Cell(1,3)},
            {new Cell(0,4),new Cell(1,4),new Cell(1,5), new Cell(2,5)}}),

    Z(new Cell[][]{{new Cell(0,4),new Cell(0,5),new Cell(1,5), new Cell(1,6)},
            {new Cell(0,5),new Cell(1,5),new Cell(1,4), new Cell(2,4)}}),

    L(new Cell[][]{{new Cell(0,4),new Cell(1,4),new Cell(2,4), new Cell(2,5)},
            {new Cell(0,5),new Cell(1,5),new Cell(1,4), new Cell(1,3)},
            {new Cell(0,4),new Cell(0,5),new Cell(1,5), new Cell(2,5)},
            {new Cell(0,6),new Cell(0,5),new Cell(0,4), new Cell(1,4)}}),

    J(new Cell[][]{{new Cell(0,5),new Cell(1,5),new Cell(2,5), new Cell(2,4)},
            {new Cell(1,5),new Cell(0,5),new Cell(0,4), new Cell(0,3)},
            {new Cell(0,5),new Cell(0,4),new Cell(1,4), new Cell(2,4)},
            {new Cell(0,4),new Cell(1,4),new Cell(1,5), new Cell(1,6)}}),

    T(new Cell[][]{{new Cell(0,4),new Cell(1,4),new Cell(2,4), new Cell(1,5)},
            {new Cell(0,4),new Cell(1,3),new Cell(1,4), new Cell(1,5)},
            {new Cell(0,5),new Cell(1,5),new Cell(2,5), new Cell(1,4)},
            {new Cell(0,4),new Cell(0,5),new Cell(0,6), new Cell(1,5)}});


    final Cell[][] cells;

    Pieces(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

}
