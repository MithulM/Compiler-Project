import java.util.ArrayList;

public class FuncCallStmt extends AbstractStmt {
    String id;
    ArrayList<Expr> args;

    public FuncCallStmt(String id) {
        this.id = id;
        this.args = new ArrayList<>();
    }

    public FuncCallStmt(String id, ArrayList<Expr> ag) {
        this.id = id;
        args = ag;
    }

    @Override
    public String toString(int depth) {
        String list = "";
        for (Expr e : args) {
            list += e.toString() + ", ";
        }
        list = list.substring(0, list.length() > 0 ? list.length() - 2 : 0);
        return getTabs(depth) + id + "(" + list + ");";
    }
}
