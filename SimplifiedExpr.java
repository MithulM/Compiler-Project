public class SimplifiedExpr extends Expr {
    Expr e;

    SimplifiedExpr(Expr e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return e.toString();
    }
}
