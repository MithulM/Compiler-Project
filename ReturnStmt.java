public class ReturnStmt extends Stmt {
    Expr exp;

    public ReturnStmt(Expr exp) {
        this.exp = exp;
    }

    public ReturnStmt() {
        this.exp = null;
    }

    @Override
    public String toString(int nest) {
        return getTabs(nest) + "return" + ((exp != null) ? " " + exp.toString() : "") + ";";
    }

    public SymbolTable.Type typeCheck(String type) throws UTDLangException {
        SymbolTable.Type t = null;
        if (exp != null) {
            t = exp.typeCheck();
            if (!t.coercible(type))
                throw new UTDLangException("Incompatible returns from " + t.type + " to " + type);
            return t;
        }
        return new SymbolTable.Type("void", "", null);
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        if (exp != null)
            return exp.typeCheck();
        return new SymbolTable.Type("void", "", null);
    }
}
