import java.util.ArrayList;

public class FuncStmt extends Stmt {
    String name;
    ArrayList args;

    public FuncStmt(String name, ArrayList args) {
        this.name = name;
        this.args = args;
    }

    @Override
    public String toString(int nest) {
        String list = "";
        for (Token e : (ArrayList<Token>) args) {
            list += e.toString() + ", ";
        }
        list = list.substring(0, Math.max(list.length() - 2, 0));
        return getTabs(nest) + name + "(" + list + ");";
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        return null;
    }
}
