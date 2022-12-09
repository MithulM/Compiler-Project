public class WhileStmt extends Stmt {
    Expr exp;
    Fielddecls fielddecls;
    Stmts sts;

    public WhileStmt(Expr exp, Fielddecls fielddecls, Stmts sts) {
        this.exp = exp;
        this.fielddecls = fielddecls;
        this.sts = sts;
    }

    @Override
    public String toString(int nest) {
        return getTabs(nest) + "while (" + exp.toString() + ") {\n"
                + fielddecls.toString(nest + 1)
                + sts.toString(nest + 1)
                + getTabs(nest) + "}";
    }
}