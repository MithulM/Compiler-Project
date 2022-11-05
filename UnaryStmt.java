public class UnaryStmt extends AbstractStmt{
    Name name;
    String op;

    public UnaryStmt(Name name, String op) {
        this.name = name;
        this.op = op;
    }

    @Override
    public String toString(int depth) {
        return getTabs(depth) + name.toString() + op + ";";
    }
}
