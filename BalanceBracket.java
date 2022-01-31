package Com;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBracket {

	// function to check if brackets are balanced
	static boolean areBracketsBalanced(String Brck) {
		Stack<Character> stack = new Stack<>();

		// Traversing the Expression
		for (int i = 0; i < Brck.length(); i++) {
			char ch = Brck.charAt(i);

			if (ch == '(' || ch == '[' || ch == '{') {
				// Push the element in the stack
				stack.push(ch);
				continue;
			}
			if (stack.isEmpty()) {

				return false;
			}
			char check;
			switch (ch) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		// Check Empty Stack
		return (stack.isEmpty());
	}

	// Driver code
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");

		String Brck = sc.next();
		// Function call
		boolean result = BalanceBracket.areBracketsBalanced(Brck);
		if (result) {
			System.out.println("String is Balanced");
		} else {
			System.out.println("String is Not Balanced ");
		}
	}
}
