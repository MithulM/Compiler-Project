public class CastExpr extends Expr {
    String type;
    Expr e;

    public CastExpr(String type, Expr e) {
        this.type = type;
        this.e = e;
    }

    @Override
    public String toString() {
        return "((" + type + ") " + "(" + e.toString() + "))";
    }
}