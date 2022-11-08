import java.util.ArrayList;

public class Methoddecls extends Token {

    ArrayList<Methoddecl> methoddecls;

    public Methoddecls() {
        methoddecls = new ArrayList<>();
    }

    public void add(Methoddecl methoddecl) {
        methoddecls.add(0, methoddecl);
    }

    public String toString(int nest) {
        String res = "";
        for (Methoddecl methoddecl : methoddecls) {
            res += methoddecl.toString(nest) + "\n";
        }
        return res;
    }
}