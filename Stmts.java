import java.util.ArrayList;

public class Stmts extends Token {

    ArrayList<Stmt> sts;

    public Stmts() {
        sts = new ArrayList<>();
    }

    public void add(Stmt st) {
        sts.add(0, st);
    }

    @Override
    public String toString(int nest) {
        String res = "";
        for (Stmt st : sts) {
            res += st.toString(nest) + "\n";
        }
        return res;
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        for (Stmt st : sts)
            st.typeCheck();
        return new SymbolTable.Type("Stmts", "", null);
    }
}