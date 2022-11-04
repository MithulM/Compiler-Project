import java.util.ArrayList;

public class Stmts extends Token{

    ArrayList<AbstractStmt> sts;

    public Stmts() {
        sts = new ArrayList<>();
    }

    public void add(AbstractStmt st) {
        sts.add(0, st);
    }

    public String toString(int depth) {
        String res = "";
        for (AbstractStmt st: sts) {
            res += st.toString(depth) + "\n";
        }
        return res;
    }
}
