class Fielddecl extends Token {
    boolean isFinal;
    String type, id;
    int arrLength;
    Expr opex;
    int declType;

    public Fielddecl(String type, String id, Expr opex, boolean isFinal) {
        this.type = type;
        this.id = id;
        this.opex = opex;
        this.isFinal = isFinal;
        declType = 0;
    }

    public Fielddecl(String type, String id, int len) {
        this.type = type;
        this.id = id;
        this.arrLength = len;
        declType = 1;
    }

    public String toString(int nest) {
        switch (declType) {
            case 0:
                return getTabs(nest) + (isFinal ? "final " : "") + type + " " + id
                        + (opex != null ? " = " + opex.toString() : "") + ";";
            case 1:
                return getTabs(nest) + type + " " + id + "[" + arrLength + "]" + ";";
            default:
                return "";
        }
    }
}