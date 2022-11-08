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
    public String toString(int nest) {
        String res = getTabs(nest) + "if (" + exp.toString() + ") {\n" +
                ifSts.toString(nest + 1) +
                getTabs(nest) + "}";
        if (elseSts != null) {
            res += " else {\n" +
                    elseSts.toString(nest + 1) +
                    getTabs(nest) + "}";
        }
        return res;
    }
}
