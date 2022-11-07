public class IfStmt extends Stmt {
    Expr exp;
    Stmts ifSts;
    Stmts elseSts;

    public IfStmt(Expr exp, Stmts ifSts, Stmts elseSts) {
        this.exp = exp;
        this.ifSts = ifSts;
        this.elseSts = elseSts;
    }

    @Override
    public String toString(int depth) {
        String res = getTabs(depth) + "if (" + exp.toString() + ") {\n" +
                ifSts.toString(depth + 1) +
                getTabs(depth) + "}";
        if (elseSts != null) {
            res += " else {\n" +
                    elseSts.toString(depth + 1) +
                    getTabs(depth) + "}";
        }
        return res;
    }
}
