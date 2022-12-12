import java.util.ArrayList;
import java.util.*;

class SymbolTable {
    ArrayList<HashMap<String, Type>> table;

    public SymbolTable() {
        table = new ArrayList<HashMap<String, Type>>();
        table.add(new HashMap<String, Type>());
    }

    public Type get(String s) throws UTDLangException {
        for (int i = table.size() - 1; i >= 0; --i)
            for (Map.Entry<String, Type> p : table.get(i).entrySet()) {
                if (p.getKey().equals(s))
                    return p.getValue();
            }
        throw new UTDLangException("Error: variable not declared " + s);
    }

    public void addVar(String id, Type t) throws UTDLangException {
        for (Map.Entry<String, Type> p : table.get(table.size() - 1).entrySet()) {
            if (p.getKey().equals(id))
                throw new UTDLangException("Error: tried to redeclare variable " + id);
        }
        table.get(table.size() - 1).put(id, t);
        return;
    }

    public void startScope() {
        table.add(new HashMap<String, Type>());
    }

    public void endScope() {
        table.remove(table.size() - 1);
    }

    public String toString() {
        String ret = "";
        String t = "";
        for (HashMap<String, Type> v : table) {
            for (Map.Entry<String, Type> p : v.entrySet())
                ret += t + p.getKey() + " " + p.getValue().toString() + "\n";
            t += "\t";
        }
        return ret;
    }

    public static class Type {
        String type;
        String typeOfType;
        ArrayList<Type> args;

        public Type(String type, String typeOfType, ArrayList<Type> args) {
            this.type = type;
            this.typeOfType = typeOfType;
            this.args = args;
        }

        public boolean isFinal() {
            return this.typeOfType.equals("final");
        }

        public boolean isArr() {
            return this.typeOfType.equals("[]");
        }

        public boolean isMethod() {
            return this.typeOfType.equals("method");
        }

        public boolean coercible(Type check) {
            if (this.equals(check))
                return true;
            if (!this.typeOfType.equals(check.typeOfType))
                return false;
            return coercibleHelper(check.type);
        }

        public boolean coercible(String check) {
            if (this.typeOfType != "")
                return false;
            return coercibleHelper(check);
        }

        public boolean coercibleHelper(String check) {
            switch (check) {
                case "bool":
                    return this.type.equals("int");
                case "float":
                    return this.type.equals("int");
                case "string":
                    String[] types = { "double", "float", "bool", "int", "short", "char", "byte" };
                    for (String x : types)
                        if (x.equals(this.type))
                            return true;
                default:
                    return this.type.equals(check);
            }
        }
    }
}