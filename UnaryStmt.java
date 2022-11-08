public class UnaryStmt extends Stmt {
    Name name;
    String op;

    public UnaryStmt(Name name, String op) {
        this.name = name;
        this.op = op;
    }

    @Override
    public String toString(int nest) {
        return getTabs(nest) + name.toString() + op + ";";
    }
}
