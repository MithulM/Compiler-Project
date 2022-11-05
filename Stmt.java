/*
Name: Mithul Manivannan
Date: 10/2/22
Section: CS 4386.001
*/

import java.util.ArrayList;

class Stmt extends AbstractStmt {
    int production;
    boolean isLoop, hasSemi;
    Stmts stmts;
    ArrayList funclist;
    ArrayList<Expr> args;
    Expr expr;
    AbstractStmt stmt, elsestmt;
    Name name;
    String id;
    String unaryOp;

    public Stmt(Stmts sts, boolean semi) {
        stmts = sts;
        hasSemi = semi;
        production = 9;
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

    public Stmt() {
        production = 0;
    }

    public String toString(int depth) {
        switch (this.production) {
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
            default:
                return "";
        }
    }
}