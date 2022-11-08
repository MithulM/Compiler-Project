import java.util.ArrayList;

public class FuncCallStmt extends Stmt {
    String id;
    Exprs args;

    public FuncCallStmt(String id) {
        this.id = id;
        this.args = new Exprs();
    }

    public FuncCallStmt(String id, Exprs ag) {
        this.id = id;
        args = ag;
    }

    @Override
    public String toString(int nest) {
        String list = args.toString();
        return getTabs(nest) + id + "(" + list + ");";
    }
}
