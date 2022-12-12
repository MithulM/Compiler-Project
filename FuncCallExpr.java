public class FuncCallExpr extends Expr {
    String id;
    Exprs args;

    public FuncCallExpr(String id) {
        this.id = id;
        this.args = new Exprs();
    }

    public FuncCallExpr(String id, Exprs ag) {
        this.id = id;
        args = ag;
    }

    @Override
    public String toString() {
        String list = args.toString();
        return id + "(" + list + ")";
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
