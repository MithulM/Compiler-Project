public class ScopeStmt extends Stmt {
    Fielddecls fs;
    Stmts sts;

    public ScopeStmt(Fielddecls fs, Stmts sts) {
        this.fs = fs;
        this.sts = sts;
    }

    @Override
    public String toString(int nest) {
        return getTabs(nest) + "{\n" + fs.toString(nest + 1) + sts.toString(nest + 1) + getTabs(nest) + "}";
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        symbolTable.startScope();
        fs.typeCheck();
        sts.typeCheck();
        symbolTable.endScope();
        return new SymbolTable.Type("newScope", "", null);
    }
}
