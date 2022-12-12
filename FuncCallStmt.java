public class FuncCallStmt extends Stmt {
    String id;
    Exprs args;

    public FuncCallStmt(String id) {
        this.id = id;
        this.args = new Exprs();
    }

    public FuncCallStmt(String id, Exprs ag) {
        this.id = id;
        args = ag;
    }

    @Override
    public String toString(int nest) {
        String list = args.toString();
        return getTabs(nest) + id + "(" + list + ");";
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        SymbolTable.Type methodType = symbolTable.get(id), argType = args.typeCheck();
        if (!methodType.isMethod())
            throw new UTDLangException(id + " is not a method.");
        if (!methodType.args.equals(argType.args))
            throw new UTDLangException("Can't call method " + id + " with given args.");
        return new SymbolTable.Type(methodType.type, "", null);
    }
}
