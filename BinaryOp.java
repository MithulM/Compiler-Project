class BinaryOp extends Token {
    String op;

    public BinaryOp(String op) {
        this.op = op;
    }

    public String toString() {
        return op;
    }
}