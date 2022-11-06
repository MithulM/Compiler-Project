public class TernaryOpExpr extends Expr {
    Expr e1, e2, e3;

    public TernaryOpExpr(Expr e1, Expr e2, Expr e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    @Override
    public String toString() {
        return "( " + e1.toString() + "  ?  " + e2.toString() + "  :  " + e3.toString() + " )";
    }
}
