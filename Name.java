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

    @Override
    public String toString() {
        return id + (idx != null ? "[" + idx.toString() + "]" : "");
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        SymbolTable.Type t = symbolTable.get(id);
        if ((idx != null) && !t.isArr())
            throw new UTDLangException("Index operation is only for array.");
        if ((idx != null) && !idx.typeCheck().equals(new SymbolTable.Type("int", "", null)))
            throw new UTDLangException("Array's idx must be of type int.");
        if (idx == null)
            return symbolTable.get(id);
        return new SymbolTable.Type(t.type, "", null);
    }
}