# CS4386-Compiler-Design-Project

Mithul Manivannan
CS 4386.001

Full Semester Long Project to Design a Basic Compiler in **Java** with JFlex and Cup

## Running
> All files in the **testfiles** directory are used for the make tests.

`make scannerTests` prints the code back in the structure as it was parsed into an AST

`make typeCheckingTests` prints the parser results plus the result of typechecking the AST

## Grammar
**Program** → class id { Memberdecls }  
**Memberdecls** → Fielddecls Methoddecls  
**Fielddecls** → Fielddecl Fielddecls | λ  
**Methoddecls** → Methoddecl Methoddecls | λ  
**Fielddecl** → Optionalfinal Type id Optionalexpr ; | Type id [ intlit ] ;  
**Optionalfinal** → final | λ  
**Optionalexpr** → = Expr | λ  
**Methoddecl** → Returntype id ( Argdecls ) { Fielddecls Stmts } Optionalsemi  
**Optionalsemi** → ; | λ  
**Returntype** → Type | void  
**Type** → int | char | bool | float  
**Argdecls** → ArgdeclList | λ  
**ArgdeclList** → Argdecl , ArgdeclList | Argdecl  
**Argdecl** → Type id | Type id [ ]  
**Stmts** → Stmt Stmts | λ  
**Stmt** → if (Expr) {Fielddecls Stmt} IfEnd | while (Expr) {Fielddecls Stmt} | Name = Expr;  
| read(Readlist); | print(Printlist); | printline(Printlinelist); | id() ; | id (Args);  
| return; | return Expr; | Name++; | Name--; | {Fielddecls Stmts} Optionalsemi  
**IfEnd** → else Stmt | λ  
**Name** → id | id [ Expr ]  
**Args** → Expr , Args | Expr  
**Readlist** → Name , Readlist | Name  
**Printlist** → Expr , Printlist | Expr  
**Printlinelist** → Printlist | λ  
**Expr** → Name | id ( ) | id ( Args ) | intlit | charlit | strlit | floatlit | true | false  
| ( Expr ) | ~ Expr | - Expr | + Expr | ( Type ) Expr | Expr Binaryop Expr | ( Expr ? Expr : Expr )  
**Binaryop** → * | / | + | - | < | > | <= | >= | == | <> | || | &&  


## Type Rules
**Implicit Coercion**  
- int
  - int → bool (0 → false, !0 → true)
  - int → float
- String
  - All types can be coerced to string with the exception of arrays  
  
**Operators**  
- = (assignment)
  - Left hand side type MUST equal Right hand side type (requires expr eval) (coercion is allowed)
- X() (function)
  - The type of the function when used in an expression is its return type
  - Number of arguments used in call must match number used in definition
    - Each argument in call must have type corresponding to the type in the method definition (coercion is allowed)
- if()
  - Condition must be a bool(or coercible to bool)
- while()
  - Condition must be a bool(or coercible to bool)
- "++"
  - Variable must be int or float (can’t be final)
- "--"
  - Variable must be int or float (can’t be final)
- X[Y] (array access)
  - Y must be an int
- "+"
  - May be used on int or float, produces int or float respectively
- "-"
  - May be used on int or float, produces int or float respectively
- "~"
  - Used on bool (or coercible to bool), produces bool
- " + - * / "
  - Int X int
    - Produces int
  - Int X float (float X int)
    - Produces float
  - Float X float
    - Produces float
- “String lit” + “String lit”
  - "+" can concatenate 2 strings
- < > <= >= == <>
  - Compare a combination of int, float
  - Produces a bool
- || &&
  - Compare two bools (or coercible to bool)
  - Produces bool
- X ? Y : Z
  - X must be a bool or coercible to bool
  - Type of Y must equal type of Z
- Read
  - Does not work on final
  - Does not work on an array(non-dereferenced)
  - Does not work on a function
- Print
  - Does not work on an array(non-dereferenced)
  - Does not work on any void type

## There are a few additional rules that are important to note:
* an identifier has a leading letter followed by zero or more letters or digits
* an integer literal has a digit followed by zero or more digits
* a character literal begins with a ', is followed by a single character description and then is
terminated by a ', a single character description can be any legal character other than ' or \, to
signify those characters they should begin with a \, as in '\'' or '\\', some special characters
include '\t' (tab character), '\n' (newline character)
* a floating point literal consists of one or more digits, followed by a decimal point (.), followed by
one or more digits
* a string literal begins with a ", is followed by zero or more string characters and ends with a ",
the string characters cannot include a newline character, a tab character, a backslash character
or a double quote directly, these must be signified using \ (as in \n for newline, \t for tab
character, \\ for backslash and \"), so "ab\tcd\n\"" is a string consisting of an a, b, tab character,
c, d, newline character and a double quote character
* white space includes space, newline, return and tab characters
* comments are included as follows:
  * on any line the characters \\ start a comment that is ended at the end of that line
  * \\* opens a comment that continues until the first occurrence of *\


## Known Issue
Ouput of typeChecking doesn't get appened to the output file.