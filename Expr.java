public abstract class Expr extends Token {
    public abstract String toString();

    @Override
    abstract SymbolTable.Type typeCheck() throws UTDLangException;
}
