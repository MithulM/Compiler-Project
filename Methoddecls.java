import java.util.ArrayList;

public class Methoddecls extends Token {

    ArrayList<Methoddecl> methoddecls;

    public Methoddecls() {
        methoddecls = new ArrayList<>();
    }

    public void add(Methoddecl methoddecl) {
        methoddecls.add(0, methoddecl);
    }

    @Override
    public String toString(int nest) {
        String res = "";
        for (Methoddecl methoddecl : methoddecls) {
            res += methoddecl.toString(nest) + "\n";
        }
        return res;
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        for (Methoddecl methoddecl : methoddecls) {
            methoddecl.typeCheck();
        }
        return new SymbolTable.Type("Methods", "", null);
    }
}