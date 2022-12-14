public class BinaryOpExpr extends Expr {
    Expr l, r;
    BinaryOp op;

    public BinaryOpExpr(Expr l, BinaryOp op, Expr r) {
        this.l = l;
        this.op = op;
        this.r = r;
    }

    @Override
    public String toString() {
        return "(" + l.toString() + " " + op.toString() + " " + r.toString() + ")";
    }

    @Override
    public SymbolTable.Type typeCheck() throws UTDLangException {
        SymbolTable.Type lType = l.typeCheck(), rType = r.typeCheck();
        if (lType.isArr() || rType.isArr() || lType.isMethod() || rType.isMethod()) {
            throw new UTDLangException("Can't do operation on arrays and methods.");
        }
        if (op.isAdd()) {
            if (lType.type.equals("string") || rType.type.equals("string")) {
                if (!(lType.coercible("string") && rType.coercible("string")))
                    throw new UTDLangException(
                            "Can't implicitly cast to a string: " + lType + " and " + rType);
                return new SymbolTable.Type("string", "", null);
            }
        }
        if (op.isMath()) {
            if (!(lType.coercible("float") && rType.coercible("float"))) {
                throw new UTDLangException("Can't do mathematical operation with non-number types");
            }
            if (lType.type.equals("int") && rType.type.equals("int"))
                return new SymbolTable.Type("int", "", null);
            return new SymbolTable.Type("float", "", null);
        }
        if (op.isRel()) {
            if (!(lType.coercible("float") && rType.coercible("float"))) {
                throw new UTDLangException("Trying to compare non-number types");
            }
        }
        if (op.isLogic()) {
            if (!(lType.coercible("bool") && rType.coercible("bool"))) {
                throw new UTDLangException("Logic operator only works on bools");
            }
        }
        return new SymbolTable.Type("bool", "", null);
    }
}
