import java.util.ArrayList;

public class Exprs extends Token {

    ArrayList<Expr> exps;

    public Exprs() {
        exps = new ArrayList<>();
    }

    public void add(Expr exp) {
        exps.add(0, exp);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Expr exp : exps) {
            res.append(exp.toString() + ", ");
        }
        return res.substring(0, Math.max(res.length() - 2, 0)).toString();
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        ArrayList<SymbolTable.Type> args = new ArrayList<>();
        for (Expr exp : exps)
            args.add(exp.typeCheck());
        return new SymbolTable.Type("exprs", "", args);
    }
}