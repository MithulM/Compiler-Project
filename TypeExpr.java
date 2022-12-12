public class TypeExpr extends Expr {
    char type;
    String literal;

    public TypeExpr(String literal, char type) {
        this.literal = literal;
        this.type = type;
    }

    @Override
    public String toString() {
        switch (this.type) {
            case 's':
            case 'c':
            case 'f':
            case 'i':
            case 'b':
                return this.literal;
            default:
                return "no implementation for " + this.literal;
        }
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        switch (this.type) {
            case 's':
                return new SymbolTable.Type("string", "", null);
            case 'c':
                return new SymbolTable.Type("char", "", null);
            case 'f':
                return new SymbolTable.Type("float", "", null);
            case 'i':
                return new SymbolTable.Type("int", "", null);
            case 'b':
                return new SymbolTable.Type("bool", "", null);
            default:
                throw new UTDLangException("no implementation for " + this.literal);
        }
    }
}
