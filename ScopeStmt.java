public class ScopeStmt extends Stmt {
    Stmts sts;

    public ScopeStmt(Stmts sts) {
        this.sts = sts;
    }

    @Override
    public String toString(int nest) {
        return getTabs(nest) + "{\n" + sts.toString(nest + 1) + getTabs(nest) + "}";
    }
}
