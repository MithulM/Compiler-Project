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
}
