class Name extends Token {
    String id;
    Expr idx;

    public Name(String name) {
        this.id = name;
        this.idx = null;
    }

    public Name(String name, Expr e) {
        this.id = name;
        this.idx = e;
    }

    public String toString() {
        return id + (hasIndex() ? "[" + idx.toString() + "]" : "");
    }

    private boolean hasIndex() {
        return idx != null;
    }
}