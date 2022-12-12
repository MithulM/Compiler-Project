class Program extends Token {
    String className;
    Memberdecls memberdecls;

    public Program(String id, Memberdecls m) {
        className = id;
        memberdecls = m;
    }

    @Override
    public String toString(int nest) {
        return "class " + className + " {\n" + memberdecls.toString(nest + 1) + "}\n";
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        return memberdecls.typeCheck();
    }
}