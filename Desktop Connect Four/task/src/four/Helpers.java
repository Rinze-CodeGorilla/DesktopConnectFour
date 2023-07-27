package four;

import java.awt.*;

public class Helpers {
    private final ConnectFour game;

    final static int[][] directions = {{1, 0}, {0, 1}, {1, 1}, {-1, 1},};

    Helpers(ConnectFour game) {
        this.game = game;
    }

    Cell freeCellForColumn(int column) {
        for (var y = 0; y < game.HEIGHT; y++) {
            var cell = game.grid[y][column];
            if (cell.getState() == CellState.EMPTY) {
                return cell;
            }
        }
        return null;
    }

    boolean checkWin(Cell cell) {
        for (var direction : directions) {
            int streak = 0;
            var winningCells = new Cell[4];
            for (int i = 0; i < 7; i++) {
                var x = cell.getColumn() - i * direction[0];
                var y = cell.getRow() - i * direction[1];
                if (x < 0 || y < 0 || x >= game.WIDTH || y >= game.HEIGHT) {
                    continue;
                }
                winningCells[streak] = game.grid[y][x];
                if (winningCells[streak].getState() == cell.getState()) {
                    if (++streak == 4) {
                        for (var j = 0; j < 4; j++) {
                            winningCells[j].setBackground(new Color(0x00ff00));
                        }
                        return true;
                    }
                } else {
                    streak = 0;
                }
            }
        }
        return false;
    }
}
