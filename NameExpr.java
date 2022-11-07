public class NameExpr extends Expr {
    Name name;

    public NameExpr(Name n) {
        name = n;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
