import static java.lang.System.out;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Math;

public class PostfixInfixStacks {
	private static Scanner input;
	public static Stack<String> expressionIn = new Stack<String>();
	public static double z;
	public static Stack<String> expressionOut = new Stack<String>();
	public static String k = new String();
	public static String l = new String();
	public static String m = new String();
	public static double result = 0;
	
	public static double parseExpression(String expression) {
		String s = new String();
		
		for(int i=0; i<expression.length(); i++) {
			char j = expression.charAt(i);
			if(j==' ') {
				expressionIn.push(s);
				s = "";
			} else {
				if(i==(expression.length()-1)) {
					expressionIn.push(j + "");
				} else {
					s = s + j;
				}
			}
		}
		
		processExpression();
		result = Double.parseDouble(expressionIn.peek());
		
		return result;
	}
	
	public static void processExpression() {
		k = expressionIn.peek();
		
		if(k.equals("+") || k.equals("-") || k.equals("*") || k.equals("/") || k.equals("^")) {
			expressionIn.pop();
			l = expressionIn.peek();
			if(isInteger(l)) {
				expressionIn.pop();
				m = expressionIn.peek();
				if(isInteger(m)) {
					expressionIn.pop();
					if(k.equals("+")) {
						expressionOut.push((Double.parseDouble(l) + Double.parseDouble(m)) + "");
					}
					if(k.equals("-")) {
						expressionOut.push((Double.parseDouble(l) - Double.parseDouble(m)) + "");
					}
					if(k.equals("*")) {
						expressionOut.push((Double.parseDouble(l) * Double.parseDouble(m)) + "");
					}
					if(k.equals("/")) {
						expressionOut.push((Double.parseDouble(l) / Double.parseDouble(m)) + "");
					}
					if(k.equals("^")) {
						expressionOut.push((Math.pow(Double.parseDouble(l), Double.parseDouble(m))) + "");
					}
					processExpression();
				}
			} else {
				expressionOut.push(k);
				processExpression();
			}
		} else {
			for(int h = 0; h<=expressionOut.size(); h++) {
				expressionIn.push(expressionOut.peek());
				expressionOut.pop();
			}
			
			k = expressionIn.peek();
			expressionIn.pop();
			l = expressionIn.peek();
			expressionIn.pop();
			m = expressionIn.peek();
			expressionIn.pop();
			if(k.equals("+")) {
				expressionIn.push((Double.parseDouble(l) + Double.parseDouble(m)) + "");
			}
			if(k.equals("-")) {
				expressionIn.push((Double.parseDouble(l) - Double.parseDouble(m)) + "");
			}
			if(k.equals("*")) {
				expressionIn.push((Double.parseDouble(l) * Double.parseDouble(m)) + "");
			}
			if(k.equals("/")) {
				expressionIn.push((Double.parseDouble(l) / Double.parseDouble(m)) + "");
			}
			if(k.equals("^")) {
				expressionIn.push((Math.pow(Double.parseDouble(l), Double.parseDouble(m))) + "");
			}
		}
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}
	
	public static void main(String args[]) {
		input = new Scanner(System.in);
		out.print("Enter your postfix expression: ");
		String expressionIn = input.nextLine();
		
		parseExpression(expressionIn);
		out.println(result);
	}
}
