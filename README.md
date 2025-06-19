# Tetris

## Short Description

This is a **console-based version of Tetris** implemented in **Java**.
The game features the classic mechanics of falling tetrominoes that the player
can rotate and move to complete full horizontal lines.
Once a line is filled, it disappears, and the player earns points.
The game ends when there is no more space to spawn a new piece.

This project focuses on strengthening understanding of:
- **2D arrays and grid-based logic**
- **Object-oriented programming**
- **Real-time game loops**
- **Collision detection and user input handling**

It's a fun and challenging way to practice building an interactive game using **Java** and logic-driven rendering in the terminal.

## Program Flow

1. **Game Initialization**:
    - A 2D game board is initialized.
    - The first tetromino is spawned at the top of the board.
2. **Game Loop**:
    - The active tetromino automatically falls at regular intervals.
    - The player can enter commands to move left/right, rotate, or drop the tetromino.
3. **Collision Handling**:
    - The game checks for collisions when moving or rotating.
    - When a tetromino can no longer move down, it is fixed in place and a new piece is spawned.
4. **Line Clearing**:
    - If a horizontal line is completely filled, it is removed and all rows above shift down.
5. **Game Over**:
    - The game ends when new pieces can no longer be placed on the board.
