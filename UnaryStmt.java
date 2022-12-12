public class UnaryStmt extends Stmt {
    Name name;
    String op;

    public UnaryStmt(Name name, String op) {
        this.name = name;
        this.op = op;
    }

    @Override
    public String toString(int nest) {
        return getTabs(nest) + name.toString() + op + ";";
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        SymbolTable.Type nameType = name.typeCheck();
        if (nameType.isFinal())
            throw new UTDLangException("Error: Variable is final");
        if (!nameType.coercible("float"))
            throw new UTDLangException("Unary operator only works on 'float' and 'int'");
        return new SymbolTable.Type(nameType.type, "", null);
    }
}
