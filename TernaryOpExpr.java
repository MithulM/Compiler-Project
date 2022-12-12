public class TernaryOpExpr extends Expr {
    Expr e1, e2, e3;

    public TernaryOpExpr(Expr e1, Expr e2, Expr e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    @Override
    public String toString() {
        return "( " + e1.toString() + "  ?  " + e2.toString() + "  :  " + e3.toString() + " )";
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        SymbolTable.Type e1Type = e1.typeCheck(), e2Type = e2.typeCheck(), e3Type = e3.typeCheck();
        if (!e1Type.coercible("bool"))
            throw new UTDLangException("Expected boolean in conditional test.");
        if (!(e2Type.equals(e3Type)))
            throw new UTDLangException("Terneray operator must return a single coercible type.");
        return e2Type;
    }
}
