public abstract class Stmt extends Token {
    public abstract String toString(int nest);

    @Override
    abstract SymbolTable.Type typeCheck() throws UTDLangException;
}
