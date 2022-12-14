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

    public SymbolTable.Type typeCheck(boolean needsReturn, String type) throws UTDLangException {
        boolean hasReturn = false;
        for (Stmt st : sts) {
            if (st instanceof ReturnStmt) {
                hasReturn = true;
                ReturnStmt rst = (ReturnStmt) st;
                rst.typeCheck(type);
            } else {
                st.typeCheck();
            }
        }
        if (needsReturn && !hasReturn)
            throw new UTDLangException("No return statement!");
        return null;
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        for (Stmt st : sts) {
            st.typeCheck();
        }
        return new SymbolTable.Type("Stmts", "", null);
    }
}