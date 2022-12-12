class BinaryOp extends Token {
    String op;

    public BinaryOp(String op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return op;
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        return new SymbolTable.Type("operation", "", null);
    }

    public boolean isAdd() {
        return op.equals("+");
    }

    public boolean isMath() {
        return "+-*/".indexOf(op) != -1;
    }

    public boolean isRel() {
        return "==<>=<=".indexOf(op) != -1;
    }

    public boolean isLogic() {
        return "||&&".indexOf(op) != -1;
    }
}