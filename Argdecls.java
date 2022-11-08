import java.util.ArrayList;

public class Argdecls extends Token {

    ArrayList<Argdecl> argdecls;

    public Argdecls() {
        argdecls = new ArrayList<>();
    }

    public void add(Argdecl argdec) {
        argdecls.add(0, argdec);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Argdecl argdecl : argdecls) {
            res.append(argdecl.toString() + ", ");
        }
        return res.substring(0, Math.max(res.length() - 2, 0)).toString();
    }
}