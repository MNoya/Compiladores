package parser;

import java_cup.runtime.Symbol;
import java.util.*;
import java.io.*;

%%
 
%unicode
%line
%column
%class Lexer
%cupsym Tokens
%cup
%implements Tokens

%{:

    public static List<Symbol> tokens(Reader input) throws IOException {
        Lexer lexer = new Lexer(input);
        List<Symbol> result = new ArrayList<Symbol>();
        for (Symbol token = lexer.next_token(); token.sym != Tokens.EOF; token = lexer.next_token()) {
            result.add(token);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Lexer lexer;
        if (args.length < 1) args = new String[]{ "" };
        for (int i = 0; i < args.length; ++i) {
            lexer = new Lexer(new InputStreamReader(args[i].length() > 0 ? new FileInputStream(args[i]) : System.in, "UTF8"));
            System.out.println(args[i] +":");
            for (Symbol token = lexer.next_token(); token.sym != Tokens.EOF; token = lexer.next_token()) {
                System.out.println("\t#"+ token.sym +" "+ token.value);
            }
        }
    }

%}

%%
"("
    { return new Symbol(LEFT_PARENTHESIS, yyline, yycolumn, yytext()); }
")"
    { return new Symbol(RIGHT_PARENTHESIS, yyline, yycolumn, yytext()); }
":"
    { return new Symbol(COLON, yyline, yycolumn, yytext()); }
","
    { return new Symbol(COMMA, yyline, yycolumn, yytext()); }
"{{"
    { return new Symbol(DOUBLE_LEFT_CURLY_BRACKET, yyline, yycolumn, yytext()); }
"}}"
    { return new Symbol(DOUBLE_RIGHT_CURLY_BRACKET, yyline, yycolumn, yytext()); }
"{"
    { return new Symbol(LEFT_CURLY_BRACKET, yyline, yycolumn, yytext()); }
"}"
    { return new Symbol(RIGHT_CURLY_BRACKET, yyline, yycolumn, yytext()); }
"class"
    { return new Symbol(CLASS, yyline, yycolumn, yytext()); }
[rwc]
	{ return new Symbol(GET_SET_CON, yyline, yycolumn, yytext()); }
"output"
	{ return new Symbol(OUTPUT, yyline, yycolumn, yytext()); }
[a-zA-Z_][a-zA-Z0-9_]*
    { String $1 = yytext(); String $0;
      $0 = $1;
      return new Symbol(ID, yyline, yycolumn, $0); }
[ \t\r\n\f\v]+
    { /* Ignore */ }
\/\*+([^\*]|\*+[^\/])*\*+\/
    { /* Ignore */ }
\/\/[^\n]*\n
    { /* Ignore */ }