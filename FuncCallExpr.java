import java.util.ArrayList;

public class FuncCallExpr extends Expr {
    String id;
    ArrayList<Expr> args;

    public FuncCallExpr(String id) {
        this.id = id;
        this.args = new ArrayList<>();
    }

    public FuncCallExpr(String id, ArrayList<Expr> ag) {
        this.id = id;
        args = ag;
    }

    @Override
    public String toString() {
        String list = "";
        for (Expr e : args) {
            list += e.toString() + ", ";
        }
        list = list.substring(0, list.length() > 0 ? list.length() - 2 : 0);
        return id + "(" + list + ");";
    }
}
