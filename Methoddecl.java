class Methoddecl extends Token {
    Argdecls as;
    Fielddecls fs;
    Stmts sts;
    String type, id;
    boolean sem;

    public Methoddecl(String type, String id, Argdecls as, Fielddecls fs, Stmts sts, boolean sem) {
        this.type = type;
        this.id = id;
        this.as = as;
        this.fs = fs;
        this.sts = sts;
        this.sem = sem;
    }

    @Override
    public String toString(int nest) {
        return getTabs(nest) + type + " " + id + "(" + as.toString() + ")" + " {\n"
                + fs.toString(nest + 1) + sts.toString(nest + 1) + getTabs(nest) +
                "}" + (sem ? ";" : "") + "\n";
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        symbolTable.startScope();
        SymbolTable.Type args = as.typeCheck();
        SymbolTable.Type method = new SymbolTable.Type(type, "method", args.args);
        symbolTable.addVar(id, method);
        fs.typeCheck();
        sts.typeCheck();
        symbolTable.endScope();
        return method;
    }
}