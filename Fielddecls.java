import java.util.ArrayList;

public class Fielddecls extends Token {

    ArrayList<Fielddecl> fields;

    public Fielddecls() {
        fields = new ArrayList<>();
    }

    public void add(Fielddecl field) {
        fields.add(0, field);
    }

    public String toString(int nest) {
        String res = "";
        for (Fielddecl field : fields) {
            res += field.toString(nest) + "\n";
        }
        return res;
    }
}