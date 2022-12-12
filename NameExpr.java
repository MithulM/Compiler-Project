public class NameExpr extends Expr {
    Name name;

    public NameExpr(Name n) {
        name = n;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        return name.typeCheck();
    }
}
