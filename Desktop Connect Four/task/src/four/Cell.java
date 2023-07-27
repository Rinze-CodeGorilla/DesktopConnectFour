package four;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private final int x;
    private final int y;
    private CellState state;

    static boolean toggle = false;
    public Cell(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        setName("Button%c%d".formatted('A' + x, y + 1));
        setFocusPainted(false);
        reset();
    }

    public void setState(CellState state) {
        this.state = state;
        this.setText(state.symbol);
    }

    public CellState getState() {
        return state;
    }

    public int getColumn() {
        return x;
    }

    public int getRow() {
        return y;
    }

    public void reset() {
        setBackground(new Color(toggle ? 0xbbffbb : 0xaaeeaa));
        setState(CellState.EMPTY);
//        toggle = !toggle;
    }
}
