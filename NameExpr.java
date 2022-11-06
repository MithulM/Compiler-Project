public class NameExpr extends Expr {
    Name name;

    public NameExpr(Name n) { // PROD 1 - name
        name = n;
        production = 3;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
