public class IfStmt extends Stmt {
    Expr exp;
    Fielddecls fielddecls;
    Stmts ifSts;
    IfEnd elseSts;

    public IfStmt(Expr exp, Fielddecls fielddecls, Stmts ifSts, IfEnd elseSts) {
        this.exp = exp;
        this.fielddecls = fielddecls;
        this.ifSts = ifSts;
        this.elseSts = elseSts;
    }

    @Override
    public String toString(int nest) {
        String res = getTabs(nest) + "if (" + exp.toString() + ") {\n" +
                fielddecls.toString(nest + 1) +
                ifSts.toString(nest + 1) +
                getTabs(nest) + "}";
        if (elseSts != null) {
            res += elseSts.toString(nest);
        }
        return res;
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        if (!exp.typeCheck().coercible("bool"))
            throw new UTDLangException("Expected bool in 'if' expression");
        symbolTable.startScope();
        fielddecls.typeCheck();
        ifSts.typeCheck();
        symbolTable.endScope();
        if (elseSts != null)
            elseSts.typeCheck();
        return new SymbolTable.Type("if", "", null);
    }
}
