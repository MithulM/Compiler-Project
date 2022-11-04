import java.util.ArrayList;

public class Stmts extends Token{

    ArrayList<Stmt> sts;

    public Stmts() {
        sts = new ArrayList<>();
    }

    public void add(Stmt st) {
        sts.add(0, st);
    }

    public String toString(int depth) {
        String res = "";
        for (Stmt st: sts) {
            res += getTabs(depth) + "statment: (" + st.toString(depth) + ")\n";
        }
        return res;
    }
}
