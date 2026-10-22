package model;

public enum Operator {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/"),
    POW("^"),
    EQUAL("=");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator fromString(String op) {
        if (op == null) {
            return null;
        }
        for (Operator o : values()) {
            if (o.symbol.equals(op)) {
                return o;
            }
        }
        return null;
    }
}
