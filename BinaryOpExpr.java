public class BinaryOpExpr extends Expr {
    Expr l, r;
    BinaryOp op;

    public BinaryOpExpr(Expr l, BinaryOp op, Expr r) {
        this.l = l;
        this.op = op;
        this.r = r;
    }

    @Override
    public String toString() {
        return "(" + l.toString() + " " + op.toString() + " " + r.toString() + ")";
    }
}
