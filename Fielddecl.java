class Fielddecl extends Token {
    boolean isFinal;
    String type, id;
    int arrLength;
    Expr opex;
    int declType;

    public Fielddecl(String type, String id, Expr opex, boolean isFinal) {
        this.type = type;
        this.id = id;
        this.opex = opex;
        this.isFinal = isFinal;
        declType = 0;
    }

    public Fielddecl(String type, String id, int len) {
        this.type = type;
        this.id = id;
        this.arrLength = len;
        declType = 1;
    }

    @Override
    public String toString(int nest) {
        switch (declType) {
            case 0:
                return getTabs(nest) + (isFinal ? "final " : "") + type + " " + id
                        + (opex != null ? " = " + opex.toString() : "") + ";";
            case 1:
                return getTabs(nest) + type + " " + id + "[" + arrLength + "]" + ";";
            default:
                return "";
        }
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        SymbolTable.Type varType, opType;
        switch (declType) {
            case 0:
                varType = new SymbolTable.Type(type, (isFinal ? "final" : ""), null);
                if ((opex != null)) {
                    opType = opex.typeCheck();
                    if (!opType.coercible(new SymbolTable.Type("int", "", null)))
                        throw new UTDLangException(
                                "Incompatable types on both sides of '=': " + varType + " and " + opType);
                }
                symbolTable.addVar(id, varType);
                return varType;
            case 1:
                varType = new SymbolTable.Type(type, "[]", null);
                symbolTable.addVar(id, varType);
                return varType;
            default:
                return null;
        }
    }
}