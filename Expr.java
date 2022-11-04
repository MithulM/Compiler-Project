/*
Name: Mithul Manivannan
Date: 10/2/22
Section: CS 4386.001
*/

import java.util.ArrayList;

class Expr extends Token {
    int typeNumber;
    String charStr, id;
    int intlit;
    float floatlit;
    Name name;
    boolean bool;
    Expr expr[];
    BinaryOp binOp;
    String unaryOp, castType;
    ArrayList<Expr> args;

    public Expr(String i, char isStr) { // PROD 5,6 - strlit
        charStr = i;
        typeNumber = isStr == 's' ? 0 : 12;
    }

    public Expr(int i) { // PROD 4 - intlit
        intlit = i;
        typeNumber = 1;
    }

    public Expr(float i) { // PROD 7 - floatlit
        floatlit = i;
        typeNumber = 2;
    }

    public Expr(Name n) { // PROD 1 - name
        name = n;
        typeNumber = 3;
    }

    public Expr(boolean b) { // PROD 8,9 - booleans
        bool = b;
        typeNumber = 4;
    }

    public Expr(Expr e) { // PROD 10 - paren
        expr = new Expr[] { e };
        typeNumber = 5;
    }

    public Expr(Expr e, String op) { // PROD 11,12,13 - prefix expr
        unaryOp = op;
        expr = new Expr[] { e };
        typeNumber = 6;
    }

    public Expr(String ct, Expr e) { // PROD 14 - cast
        castType = ct;
        expr = new Expr[] { e };
        typeNumber = 7;
    }

    public Expr(Expr e1, BinaryOp bOp, Expr e2) { // PROD 15 - binop
        expr = new Expr[] { e1, e2 };
        binOp = bOp;
        typeNumber = 8;
    }

    public Expr(Expr e1, Expr e2, Expr e3) { // PROD 16 - ternary
        expr = new Expr[] { e1, e2, e3 };
        typeNumber = 9;
    }

    public Expr(String id, ArrayList<Expr> args) { // PROD 3 - func(args)
        this.id = id;
        this.args = args;
        typeNumber = 10;
    }

    public Expr(String id, boolean isMethod) { // PROD 2 - func()
        this.id = id;
        typeNumber = 11;
    }

    public String toString() {
        switch (this.typeNumber) {
            case 0:
            case 12:
                return charStr;
            case 1:
                return "" + intlit;
            case 2:
                return "" + floatlit;
            case 3:
                return name.toString();
            case 4:
                return bool ? "true" : "false";
            case 5:
                return expr[0].toString();
            case 6:
                return "(" + unaryOp + " " + expr[0].toString() + ")";
            case 7:
                return "(" + castType + ")" + expr[0].toString();
            case 8:
                return "(" + expr[0].toString() + " " + binOp.toString() + " " + expr[1].toString() + ")";
            case 9:
                return "( " + expr[0].toString() + " ? " + expr[1].toString() + " : " + expr[2].toString() + " )";
            case 10:
                String ret = "";
                for (Expr e : args) {
                    ret += e.toString() + ", ";
                }
                ret = ret.substring(0, ret.length() > 0 ? ret.length() - 2 : 0);
                return id + "(" + ret + ")";
            case 11:
                return id + "()";
            default:
                return "";
        }
    }
}