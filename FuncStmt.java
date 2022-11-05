import java.util.ArrayList;

public class FuncStmt extends AbstractStmt {
    String name;
    ArrayList args;

    public FuncStmt(String name, ArrayList args) {
        this.name = name;
        this.args = args;
    }

    @Override
    public String toString(int depth) {
        String list = "";
        for (Token e : (ArrayList<Token>)args) {
            list += e.toString(depth + 1) + ", ";
        }
        list = list.substring(0, list.length() > 0 ? list.length() - 2 : 0);
        return getTabs(depth) + name + "(" + list + ");";
    }
}
