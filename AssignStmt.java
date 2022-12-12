public class AssignStmt extends Stmt {
    Name name;
    Expr exp;

    public AssignStmt(Name name, Expr exp) {
        this.name = name;
        this.exp = exp;
    }

    @Override
    public String toString(int nest) {
        return getTabs(nest) + name.toString() + " = " + exp.toString() + ";";
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        SymbolTable.Type var = name.typeCheck(), e = exp.typeCheck();
        if (var.typeOfType.equals("final"))
            throw new UTDLangException("Can't reassign a final variable");
        if (!e.coercible(var)) {
            throw new UTDLangException("Right side can't be converted to left implicitly");
        }
        return var;
    }
}
