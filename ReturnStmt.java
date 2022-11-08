public class ReturnStmt extends Stmt {
    Expr exp;

    public ReturnStmt(Expr exp) {
        this.exp = exp;
    }

    public ReturnStmt() {
        this.exp = null;
    }

    @Override
    public String toString(int nest) {
        return getTabs(nest) + "return" + ((exp != null) ? " " + exp.toString() : "") + ";";
    }
}
