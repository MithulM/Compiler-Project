public class UnaryOpExpr extends Expr {

    Expr e;
    String op;

    public UnaryOpExpr(Expr e, String op) {
        this.e = e;
        this.op = op;
    }

    @Override
    public String toString() {
        return "(" + op + e.toString() + ")";
    }
}
