public class WhileStmt extends AbstractStmt {
    Expr exp;
    Stmts sts;

    public WhileStmt(Expr exp, Stmts sts) {
        this.exp = exp;
        this.sts = sts;
        production = 8;
    }

    @Override
    public String toString(int depth) {
        String tabs = getTabs(depth);
        return tabs + "while (" + exp.toString() + ") {\n" + sts.toString(depth + 1) + tabs + "}";
    }
}
