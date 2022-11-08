public class NameStmt extends Stmt {
    Name name;
    Expr exp;

    public NameStmt(Name name, Expr exp) {
        this.name = name;
        this.exp = exp;
    }

    @Override
    public String toString(int nest) {
        return getTabs(nest) + name.toString() + " = " + exp.toString() + ";";
    }
}
