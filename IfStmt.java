public class IfStmt extends AbstractStmt {
    public Expr exp;
    Stmts sts;
    AbstractStmt elst;

    public IfStmt(Expr exp, Stmts sts, AbstractStmt elst) {
        this.exp = exp;
        this.sts = sts;
        this.elst = elst;
        production = 11;
    }

    @Override
    public String toString(int depth) {
        return getTabs(depth) +
        "if (" + exp.toString() + ")\n" +
        sts.toString(depth + 1) +
        (elst != null
                ? "\n" + getTabs(depth) + "else\n"
                        + (elst.production == 9 ? elst.toString(depth)
                                : getTabs(depth) + "{\n" + elst.toString(depth + 1) + "\n"
                                        + getTabs(depth) + "}")
                : "");
    }
}
