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
        return getTabs(depth) + "while (" + exp.toString() + ") " + sts.toString(depth + 1);
    }
}
