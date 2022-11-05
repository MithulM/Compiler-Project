public class ReturnStmt extends Stmt{

    Expr exp;

    public ReturnStmt(Expr exp) {
        this.exp = exp;
    }

    public ReturnStmt() {
        this.exp = null;
    }

    @Override
    public String toString(int depth) {
        return getTabs(depth) + "return" + ((exp != null) ? " " + exp.toString() : "") + ";";
    }
}
