public class NameStmt extends AbstractStmt{
    Name name;
    Expr exp;

    public NameStmt(Name name, Expr exp) {
        this.name = name;
        this.exp = exp;
    }

    @Override
    public String toString(int depth) {
        return getTabs(depth) + name.toString() + " = " + exp.toString() + ";";
    }
}
