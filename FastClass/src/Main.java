import java.io.*;
import java.util.Scanner;

import ast.Programa;
import parser.*;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("Loading test cases...");
		
		String input = new Scanner(new File("entrada/test1.txt")).useDelimiter("\\Z").next();
		//System.out.println(content);
		
        try {
            Programa prog = (Programa) Parser.parse(input).value;
            prog.compile();           
            System.out.println("Finished program.");
        } catch (Exception err) {
            System.err.print(err);
            err.printStackTrace();
        }
	
	}
}