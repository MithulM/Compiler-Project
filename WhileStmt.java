public class WhileStmt extends Stmt {
    Expr exp;
    Stmts sts;

    public WhileStmt(Expr exp, Stmts sts) {
        this.exp = exp;
        this.sts = sts;
    }

    @Override
    public String toString(int nest) {
        String tabs = getTabs(nest);
        return tabs + "while (" + exp.toString() + ") {\n" + sts.toString(nest + 1) + tabs + "}";
    }
}
