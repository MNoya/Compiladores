import java.io.*;
import ast.*;
import parser.*;

public class Main {
	public static void main(String[] args) throws Exception {
		State s = new State();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("> ");
			for (String line; (line = in.readLine()) != null ;) {
				line = line.trim();
				try {
					if (line.length() > 0) {
						Stmt prog = (Stmt)(Parser.parse(line).value);
						System.out.print("\t"+ prog +"\n> ");
						System.out.print("\t"+ prog.evaluate(s) +"\n> ");
					}
				} catch (Exception err) {
					System.err.print(err);
					err.printStackTrace();
				}
			}
	}
}