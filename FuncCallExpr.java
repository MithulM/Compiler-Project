import java.util.ArrayList;

public class FuncCallExpr extends Expr {
    String id;
    Exprs args;

    public FuncCallExpr(String id) {
        this.id = id;
        this.args = new Exprs();
    }

    public FuncCallExpr(String id, Exprs ag) {
        this.id = id;
        args = ag;
    }

    @Override
    public String toString() {
        String list = args.toString();
        return id + "(" + list + ")";
    }
}
