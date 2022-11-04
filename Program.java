class Program extends Token {

    Stmts sts;

    public Program(Stmts sts) {
        this.sts = sts;
    }

    public String toString(int depth) {
        return "Program {\n" + sts.toString(depth + 1) + "}\n";
    }
}