class Argdecl extends Token {
    String type, id, isArr;

    public Argdecl(String type, String id, String isArr) {
        this.type = type;
        this.id = id;
        this.isArr = isArr;
    }

    @Override
    public String toString() {
        return type + " " + id + isArr;
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        SymbolTable.Type t = new SymbolTable.Type(type, isArr, null);
        symbolTable.addVar(id, t);
        return t;
    }
}