package lesson5PrefixSums;

/*
Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A <= i <= B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:
A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A <= B.
*/

public class CountDiv {

	public static int solution(int A, int B, int K) {
		
		int res = 0; // result

		// check every number
		for (int i = A; i <= B; i++)
			if (i % K == 0)
				res++;

		return res;
	}

	public static int altSolution(int A, int B, int K) {
		
		// find first and last integer divisible by K in range [A..B]
		int firstDivisible = -1, lastDivisible = -1;

		for (int i = A; i <= B; i++) {
			if (i % K == 0) {
				firstDivisible = i;
				break;
			}
		}

		for (int i = B; i >= A; i--) {
			if (i % K == 0) {
				lastDivisible = i;
				break;
			}
		}
		//

		//System.out.println("< " + firstDivisible + ", " + lastDivisible + " >");

		if (firstDivisible == -1 || lastDivisible == -1)
			return 0;

		// using arithmetic sequence formula:
		// a(n) == a(1) + (n-1) * r
		// lastDivisible == firstDivisible + (n-1) * K
		// n == (lastDivisible - firstDivisible) / K + 1

		return ((lastDivisible - firstDivisible) / K) + 1;
	}

	public static void main(String[] args) {

		System.out.println("A = 6 , B = 11, K = 2");
		System.out.println(altSolution(6, 11, 2));
		System.out.println("");
		System.out.println("A = 3 , B = 19, K = 3");
		System.out.println(altSolution(3, 19, 3));
		System.out.println("");
		System.out.println("A = 6 , B = 20, K = 2");
		System.out.println(altSolution(6, 20, 2));
		System.out.println("");
		System.out.println("A = 1 , B = 1, K = 11");
		System.out.println(altSolution(1, 1, 11));
		System.out.println("");
	}

}
