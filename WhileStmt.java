public class WhileStmt extends Stmt {
    Expr exp;
    Stmts sts;

    public WhileStmt(Expr exp, Stmts sts) {
        this.exp = exp;
        this.sts = sts;
    }

    @Override
    public String toString(int depth) {
        String tabs = getTabs(depth);
        return tabs + "while (" + exp.toString() + ") {\n" + sts.toString(depth + 1) + tabs + "}";
    }
}
