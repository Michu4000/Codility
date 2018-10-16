package lesson7StacksAndQueues;

/*
A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
*/

public class Nesting {

	public static int solution(String S) {

		//System.out.println("\"" + S + "\""); //

		if (S == null)
			return 1;

		if (S.isEmpty())
			return 1;

		if (S.length() % 2 != 0) // string length is odd => can't be good
			return 0;
		
		// remove closed brackets from the string
		for (int i = 0; i < S.length() - 1; i++) {

			if (S.charAt(i) == '(' && S.charAt(i + 1) == ')') {
				if (i > 0)
					return solution(S.substring(0, i) + S.substring(i + 2, S.length()));
				else
					return solution(S.substring(i + 2, S.length()));
			}
		}
		//

		return 0;
	}

	public static int altSolution(String S) {

		if (S == null)
			return 1;

		if (S.length() % 2 != 0) // string length is odd => can't be good
			return 0;

		String Sprev = " ";

		// remove closed brackets from the string
		while (!Sprev.equals(S)) {

			if (S.isEmpty())
				return 1;

			Sprev = new String(S);

			for (int i = 0; i < S.length() - 1; i++) {
				if (S.isEmpty())
					break;

				if (S.charAt(i) == '(' && S.charAt(i + 1) == ')') {
					if (i > 0)
						S = S.substring(0, i) + S.substring(i + 2, S.length());
					else
						S = S.substring(i + 2, S.length());
				}
			}
		}
		//

		return 0;
	}
	
	public static int bestSolution(String S) {
		
		if (S == null)
			return 1;

		if (S.isEmpty())
			return 1;

		if (S.length() % 2 != 0) // string length is odd => can't be good
			return 0;
		
		int counter = 0; // count lvl of tree
		
		for(int i = 0; i < S.length(); i++) {
			
			if(S.charAt(i) == '(')
				counter++;
			
			if(S.charAt(i) == ')')
				counter--;
			
			// if lvl < 0 => it's not a tree
			if(counter < 0)
				return 0;
		}
		
		// if final lvl == 0 => it's a tree
		if(counter == 0)
			return 1;
		else
		    return 0;
	}

	public static void main(String[] args) {

		System.out.println("S = \"((()))\"");
		System.out.println(bestSolution("((()))"));
		System.out.println("");
		System.out.println("S = \"()\"");
		System.out.println(bestSolution("()"));
		System.out.println("");
		System.out.println("S = \"()()\"");
		System.out.println(bestSolution("()()"));
		System.out.println("");
		System.out.println("S = \"(()())\"");
		System.out.println(bestSolution("(()())"));
		System.out.println("");
		System.out.println("S = \"(())\"");
		System.out.println(bestSolution("(())"));
		System.out.println("");
		System.out.println("S = \"((()))\"");
		System.out.println(bestSolution("((()))"));
		System.out.println("");
		System.out.println("S = \"((()))\"");
		System.out.println(bestSolution("((()))"));
		System.out.println("");
		System.out.println("S = \"((((()()())))()())\"");
		System.out.println(bestSolution("((((()()())))()())"));
		System.out.println("");
		System.out.println("S = \"(()())");
		System.out.println(bestSolution("(()())"));
		System.out.println("");
		System.out.println("S = \"()(()())((()())(()()))\"");
		System.out.println(bestSolution("()(()())((()())(()()))"));
		System.out.println("");
	}

}
