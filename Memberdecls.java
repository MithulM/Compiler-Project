class Memberdecls extends Token {
    Fielddecls fielddecls;
    Methoddecls methoddecls;

    public Memberdecls(Fielddecl f, Memberdecls mds) {
        mds.fielddecls.add(f);
        this.fielddecls = mds.fielddecls;
        this.methoddecls = mds.methoddecls;
    }

    public Memberdecls(Fielddecls fs, Methoddecls ms) {
        fielddecls = fs;
        methoddecls = ms;
    }

    public Memberdecls(Methoddecls ms) {
        fielddecls = new Fielddecls();
        methoddecls = ms;
    }

    public String toString(int nest) {
        return fielddecls.toString(nest) + methoddecls.toString(nest);
    }
}