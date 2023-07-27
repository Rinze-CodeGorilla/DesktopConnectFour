package four;

public enum CellState {
    X("X"),
    O("O"),
    EMPTY(" "),
    ;
    public final String symbol;

    CellState(String symbol) {
        this.symbol = symbol;
    }
}
