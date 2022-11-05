public class ScopeStmt extends Stmt {
    Stmts sts;

    public ScopeStmt(Stmts sts) {
        this.sts = sts;
    }

    @Override
    public String toString(int depth) {
        String result = "";
        result += sts.toString(depth + 1) + "\n";
        return getTabs(depth) + "{\n" + result + getTabs(depth) + "}";
    }
}
