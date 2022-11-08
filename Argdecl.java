class Argdecl extends Token {
    String type, id;

    public Argdecl(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public String toString() {
        return type + " " + id;
    }
}