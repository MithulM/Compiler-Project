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

    @Override
    public String toString(int nest) {
        return fielddecls.toString(nest) + methoddecls.toString(nest);
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        symbolTable.startScope();
        fielddecls.typeCheck();
        methoddecls.typeCheck();
        symbolTable.endScope();
        return new SymbolTable.Type("class", "", null);
    }
}