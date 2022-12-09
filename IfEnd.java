public class IfEnd extends Stmt {
    Fielddecls fielddecls;
    Stmts sts;

    public IfEnd(Fielddecls fielddecls, Stmts sts) {
        this.fielddecls = fielddecls;
        this.sts = sts;
    }

    @Override
    public String toString(int nest) {
        return getTabs(nest) + " else {\n" +
                fielddecls.toString(nest + 1) +
                sts.toString(nest + 1) +
                getTabs(nest) + "}";
    }
}
