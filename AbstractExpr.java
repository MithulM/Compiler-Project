/*
Name: Mithul Manivannan
Date: 10/2/22
Section: CS 4386.001
*/

import java.util.ArrayList;

class AbstractExpr extends Expr {
    int production;
    String charStr, id;
    int intlit;
    float floatlit;
    Name name;
    boolean bool;
    Expr expr[];
    BinaryOp binOp;
    String unaryOp, castType;
    ArrayList<Expr> args;

    public AbstractExpr(String i, char isStr) { // PROD 5,6 - strlit
        charStr = i;
        production = isStr == 's' ? 0 : 12;
    }

    public AbstractExpr(int i) { // PROD 4 - intlit
        intlit = i;
        production = 1;
    }

    public AbstractExpr(float i) { // PROD 7 - floatlit
        floatlit = i;
        production = 2;
    }

    public AbstractExpr(boolean b) { // PROD 8,9 - booleans
        bool = b;
        production = 4;
    }

    public AbstractExpr(Expr e) { // PROD 10 - paren
        expr = new Expr[] { e };
        production = 5;
    }

    public AbstractExpr(Expr e, String op) { // PROD 11,12,13 - prefix expr
        unaryOp = op;
        expr = new Expr[] { e };
        production = 6;
    }

    public AbstractExpr(String ct, Expr e) { // PROD 14 - cast
        castType = ct;
        expr = new Expr[] { e };
        production = 7;
    }

    public AbstractExpr(Expr e1, BinaryOp bOp, Expr e2) { // PROD 15 - binop
        expr = new Expr[] { e1, e2 };
        binOp = bOp;
        production = 8;
    }

    public AbstractExpr(Expr e1, Expr e2, Expr e3) { // PROD 16 - ternary
        expr = new Expr[] { e1, e2, e3 };
        production = 9;
    }

    public AbstractExpr(String id, ArrayList<Expr> args) { // PROD 3 - func(args)
        this.id = id;
        this.args = args;
        production = 10;
    }

    public AbstractExpr(String id, boolean isMethod) { // PROD 2 - func()
        this.id = id;
        production = 11;
    }

    public String toString() {
        switch (this.production) {
            case 0:
            case 12:
                return charStr;
            case 1:
                return "" + intlit;
            case 2:
                return "" + floatlit;
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