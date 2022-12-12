public class UnaryOpExpr extends Expr {
    Expr exr;
    String op;

    public UnaryOpExpr(Expr exr, String op) {
        this.exr = exr;
        this.op = op;
    }

    @Override
    public String toString() {
        return "(" + op + exr.toString() + ")";
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        SymbolTable.Type exrType = exr.typeCheck();
        if (op.equals("~")) {
            if (!exrType.coercible("bool"))
                throw new UTDLangException("~ unary operator only works on 'bool' and 'int'");
        } else if (!exrType.coercible("float"))
            throw new UTDLangException("+/- unary operator only works on 'float' and 'int'");
        return new SymbolTable.Type(exrType.type, "", null);
    }
}
