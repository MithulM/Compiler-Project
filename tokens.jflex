/*-***
 * Name: Mithul Manivannan
 * Date: 10/2/22
 * Section: CS 4386.001
 *
 * This file defines a stand-alone lexical analyzer for a subset of the Pascal
 * programming language.  This is the same lexer that will later be integrated
 * with a CUP-based parser.  Here the lexer is driven by the simple Java test
 * program in ./PascalLexerTest.java, q.v.  See 330 Lecture Notes 2 and the
 * Assignment 2 writeup for further discussion.
 *
 */
import java_cup.runtime.*;


%%
/*-*
 * LEXICAL FUNCTIONS:
 */

%cup
%line
%column
%unicode
%class Lexer

%{

/**
 * Return a new Symbol with the given token id, and with the current line and
 * column numbers.
 */
Symbol newSym(int tokenId) {
    return new Symbol(tokenId, yyline, yycolumn);
}

/**
 * Return a new Symbol with the given token id, the current line and column
 * numbers, and the given token value.  The value is used for tokens such as
 * identifiers and numbers.
 */
Symbol newSym(int tokenId, Object value) {
    return new Symbol(tokenId, yyline, yycolumn, value);
}

%}


/*-*
 * PATTERN DEFINITIONS:
 */


/**
 * Implement patterns as regex here
 */

alph          = [A-Za-z]
num           = [0-9]
id            = {alph}[{alph}{num}]*

intlit        = {num}+
floatlit      = {intlit}\.{intlit}
char          = [^\\\n\t\"\']|\\.
charlit       = \'{char}\'
strlit        = \"{char}*\"

comment       = \\\\.*[\n\r]?
multi_comment = \\\*([^\*]\\|[^\\])*\*\\
whitespace    = [ \n\t\r]



%%
/**
 * LEXICAL RULES:
 */
class                   {return newSym(sym.CLASS, "class");}
else                    {return newSym(sym.ELSE, "else");}
if                      {return newSym(sym.IF, "if");}
while                   {return newSym(sym.WHILE, "while");}
return                  {return newSym(sym.RETURN, "return");}
";"                     {return newSym(sym.SEMI, ";");}
"="                     {return newSym(sym.ASSIGN, "=");}
","                     {return newSym(sym.COMMA, ",");}
"("                     {return newSym(sym.LPAREN, "(");}
")"                     {return newSym(sym.RPAREN, ")");}
"["                     {return newSym(sym.LSQR, "[");}
"]"                     {return newSym(sym.RSQR, "]");}
"{"                     {return newSym(sym.LCURLY, "{");}
"}"                     {return newSym(sym.RCURLY, "}");}
"~"                     {return newSym(sym.NOT, "~");}
"?"                     {return newSym(sym.QUESTION, "?");}
":"                     {return newSym(sym.COLON, ":");}
read                    {return newSym(sym.READ, "read");}
print                   {return newSym(sym.PRINT, "print");}
printline               {return newSym(sym.PRINTLN, "printline");}
"++"                    {return newSym(sym.INC, "++");}
"--"                    {return newSym(sym.DEC, "--");}
"*"                     {return newSym(sym.MULTI, "*");}
"/"                     {return newSym(sym.DIV, "/");}
"+"                     {return newSym(sym.PLUS, "+");}
"-"                     {return newSym(sym.MINUS, "-");}
"<"                     {return newSym(sym.LT, "<");}
">"                     {return newSym(sym.GT, ">");}
"=="                    {return newSym(sym.EQ, "==");}
"<="                    {return newSym(sym.LTE, "<=");}
">="                    {return newSym(sym.GTE, ">=");}
"<>"                    {return newSym(sym.NE, "<>");}
"||"                    {return newSym(sym.OR, "||");}
"&&"                    {return newSym(sym.AND, "&&");}
true                    {return newSym(sym.TRUE, "true");}
false                   {return newSym(sym.FALSE, "false");}
void                    {return newSym(sym.VOID, "void");}
int                     {return newSym(sym.INT, "int");}
float                   {return newSym(sym.FLOAT, "float");}
bool                    {return newSym(sym.BOOL, "bool");}
char                    {return newSym(sym.CHAR, "char");}
final                   {return newSym(sym.FINAL, "final");}
{intlit}                {return newSym(sym.INTLIT, yytext());}
{floatlit}              {return newSym(sym.FLOATLIT, yytext());}
{charlit}               {return newSym(sym.CHARLIT, yytext());}
{strlit}                {return newSym(sym.STRLIT, yytext());}
{id}                    {return newSym(sym.ID, yytext());}
{whitespace}            {/* whitespace */}
{comment}               {/* comment */}
{multi_comment}         {/* multiline comment */}
.                { System.out.println("Illegal char, '" + yytext() +
                "' line: " + yyline + ", column: " + yychar); }