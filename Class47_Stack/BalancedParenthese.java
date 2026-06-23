import java.util.Scanner;

public class BalancedParentheses{

	public static boolean isBalancedExpression(String expression){
		// "((()))"
		// idx = 0 -> '('
		Stack<Character> stk = new Stack<>();

		for(int i=0; i<expression.length(); i++){
			char ch = expression.charAt(i);
			if(ch == '('){
				stk.push(ch);
			}
			else{
				if(stk.isEmpty()){
					return false;
				}
				stk.pop();
			}
		}

		return stk.isEmpty();
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.next();

		if(isBalancedExpression(expression)){
			System.out.println("Balanced");
		}
		else{
			System.out.println("Not Balanced");
		}
	}
}