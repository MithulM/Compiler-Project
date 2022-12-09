public class IfStmt extends Stmt {
    Expr exp;
    Fielddecls fielddecls;
    Stmts ifSts;
    IfEnd elseSts;

    public IfStmt(Expr exp, Fielddecls fielddecls, Stmts ifSts, IfEnd elseSts) {
        this.exp = exp;
        this.fielddecls = fielddecls;
        this.ifSts = ifSts;
        this.elseSts = elseSts;
    }

    @Override
    public String toString(int nest) {
        String res = getTabs(nest) + "if (" + exp.toString() + ") {\n" +
                fielddecls.toString(nest + 1) +
                ifSts.toString(nest + 1) +
                getTabs(nest) + "}";
        if (elseSts != null) {
            res += elseSts.toString(nest);
        }
        return res;
    }
}
