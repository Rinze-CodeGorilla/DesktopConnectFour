package four;

import javax.swing.*;
import java.awt.*;

import static four.CellState.*;

public class ConnectFour extends JFrame {
    final int WIDTH = 7;
    final int HEIGHT = 6;
    final int CELL_SIZE = 60;

    CellState currentPlayer = X;

    Cell[][] grid = new Cell[HEIGHT][WIDTH];

    boolean isFinished = false;

    public ConnectFour() {
        var helpers = new Helpers(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        setSize(WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE + 50);
        var g = new JPanel(new GridLayout(HEIGHT, WIDTH));
        add(g);
        var b = new JButton("Reset");
        b.setName("ButtonReset");
        b.setAlignmentX(0.5f);
        b.setBackground(new Color(0xcccc44));
        b.addActionListener(e -> {
            for (var line : grid) {
                for (var cell : line) {
                    cell.reset();
                }
            }
            isFinished = false;
            currentPlayer = X;
        });
        add(b);

        setTitle("Connect Four");
        for (int y = HEIGHT - 1; y >= 0; y--) {
            for (int x = 0; x < WIDTH; x++) {
                var cell = new Cell(x, y);
                grid[y][x] = cell;
                cell.addActionListener(e -> {
                    if (isFinished) return;
                    var firstEmpty = helpers.freeCellForColumn(cell.getColumn());
                    if (firstEmpty == null) {
                        return;
                    }
                    firstEmpty.setState(currentPlayer);
                    isFinished = helpers.checkWin(firstEmpty);
                    currentPlayer = currentPlayer == X ? O : X;
                });
                g.add(cell);
            }
        }
        setVisible(true);
    }

}
