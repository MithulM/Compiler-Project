/*
Name: Mithul Manivannan
Date: 10/2/22
Section: CS 4386.001
*/

import java.util.ArrayList;

class Stmt extends Token {
    int production;
    boolean isLoop, hasSemi;
    Stmts stmts;
    ArrayList funclist;
    ArrayList<Expr> args;
    Expr expr;
    Stmt stmt, elsestmt;
    Name name;
    String id;
    String unaryOp;

    public Stmt(Expr e, Stmts st, Stmt elsest) {
        expr = e;
        stmts = st;
        elsestmt = elsest;
        production = 11;
    }

    public Stmt(String id, ArrayList<Expr> ag, boolean func) {
        this.id = id;
        args = ag;
        production = 10;
    }

    public Stmt(Stmts sts, boolean semi) {
        stmts = sts;
        hasSemi = semi;
        production = 9;
    }

    public Stmt(Expr e, Stmts st) {
        expr = e;
        stmts = st;
        production = 8;
    }

    public Stmt(Name n, Expr e) {
        name = n;
        expr = e;
        production = 7;
    }

    public Stmt(String func, ArrayList lst) {
        id = func;
        funclist = lst;
        production = (func == "read" ? 6 : (func == "print" ? 5 : 4));
    }

    public Stmt(Name n, String unary) {
        name = n;
        unaryOp = unary;
        production = 3;
    }

    public Stmt(Expr e) {
        expr = e;
        production = 2;
    }

    public Stmt(String id) {
        this.id = id;
        production = 1;
    }

    public Stmt() {
        production = 0;
    }

    public String toString(int depth) {
        switch (this.production) {
            case 11:
                return getTabs(depth) +
                        "if (" + expr.toString() + ")\n" +
                        stmts.toString(depth + 1) +
                        (elsestmt != null
                                ? "\n" + getTabs(depth) + "else\n"
                                        + (elsestmt.production == 9 ? elsestmt.toString(depth)
                                                : getTabs(depth) + "{\n" + elsestmt.toString(depth + 1) + "\n"
                                                        + getTabs(depth) + "}")
                                : "");
            case 10:
                String list = "";
                for (Expr e : args) {
                    list += e.toString() + ", ";
                }
                list = list.substring(0, list.length() > 0 ? list.length() - 2 : 0);
                return getTabs(depth) + id + "(" + list + ");";
            case 9:
                String result = "";
                result += stmts.toString(depth + 1) + "\n";
                return getTabs(depth) + "{\n" + result + getTabs(depth) + "}";
            case 8:
                return getTabs(depth) +
                        "while (" + expr.toString() + ")\n{" + stmts.toString(depth + 1) + "}\n";
            case 7:
                return getTabs(depth) +
                        name.toString() + " = " + expr.toString() + ";";
            case 6:
                list = "";
                for (Name n : (ArrayList<Name>) funclist) {
                    list += n.toString() + ", ";
                }
                list = list.substring(0, list.length() > 0 ? list.length() - 2 : 0);
                return getTabs(depth) + id + "(" + list + ");";
            case 5:
                list = "";
                for (Expr e : (ArrayList<Expr>) funclist) {
                    list += e.toString() + ", ";
                }
                list = list.substring(0, list.length() > 0 ? list.length() - 2 : 0);
                return getTabs(depth) + id + "(" + list + ");";
            case 4:
                list = "";
                for (Expr e : (ArrayList<Expr>) funclist) {
                    list += e.toString() + ", ";
                }
                list = list.substring(0, list.length() > 0 ? list.length() - 2 : 0);
                return getTabs(depth) + id + "(" + list + ");";
            case 3:
                return getTabs(depth) + name.toString() + unaryOp + ";";
            case 2:
                return getTabs(depth) + "return " + expr.toString() + ";";
            case 1:
                return getTabs(depth) + id + "();";
            case 0:
                return getTabs(depth) + "return;";
            default:
                return "";
        }
    }

    public boolean isReturn() {
        return this.production == 2 | this.production == 0;
    }

}