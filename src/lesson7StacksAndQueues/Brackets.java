package lesson7StacksAndQueues;

/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
*/

public class Brackets {

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
			if (S.charAt(i) == '{' && S.charAt(i + 1) == '}') {
				if (i > 0)
					return solution(S.substring(0, i) + S.substring(i + 2, S.length()));
				else
					return solution(S.substring(i + 2, S.length()));
			}

			if (S.charAt(i) == '[' && S.charAt(i + 1) == ']') {
				if (i > 0)
					return solution(S.substring(0, i) + S.substring(i + 2, S.length()));
				else
					return solution(S.substring(i + 2, S.length()));
			}

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

			//System.out.println("\"" + S + "\""); //

			if (S.isEmpty())
				return 1;			

			Sprev = new String(S);

			for (int i = 0; i < S.length() - 1; i++) {
				if (S.isEmpty())
					break;

				if ((S.charAt(i) == '{' && S.charAt(i + 1) == '}') || (S.charAt(i) == '[' && S.charAt(i + 1) == ']')
						|| (S.charAt(i) == '(' && S.charAt(i + 1) == ')')) {
					
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
	
	public static void main(String[] args) {

		System.out.println("S = \"{[()]}\"");
		System.out.println(altSolution("{[()]}"));
		System.out.println("");
		System.out.println("S = \"()\"");
		System.out.println(altSolution("()"));
		System.out.println("");
		System.out.println("S = \"()()\"");
		System.out.println(altSolution("()()"));
		System.out.println("");
		System.out.println("S = \"(()())\"");
		System.out.println(altSolution("(()())"));
		System.out.println("");
		System.out.println("S = \"(())\"");
		System.out.println(altSolution("(())"));
		System.out.println("");
		System.out.println("S = \"[(())]\"");
		System.out.println(altSolution("[(())]"));
		System.out.println("");
		System.out.println("S = \"((()))\"");
		System.out.println(altSolution("((()))"));
		System.out.println("");
		System.out.println("S = \"({{({}[]{})}}[]{})\"");
		System.out.println(altSolution("({{({}[]{})}}[]{})"));
		System.out.println("");
		System.out.println("S = \"([)()]");
		System.out.println(altSolution("([)()]"));
		System.out.println("");
		System.out.println("S = \"()(()())((()())(()()))\"");
		System.out.println(altSolution("()(()())((()())(()()))"));
		System.out.println("");
	}

}
