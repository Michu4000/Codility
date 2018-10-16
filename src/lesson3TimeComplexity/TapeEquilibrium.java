package lesson3TimeComplexity;

/*
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts:
A[0], A[1], ..., A[P - 1] and A[P], A[P + 1], ..., A[N - 1].

The difference between the two parts is the value of:
|(A[0] + A[1] + ... + A[P - 1]) - (A[P] + A[P + 1] + ... + A[N - 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:
  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:
P = 1, difference = |3 - 10| = 7 
P = 2, difference = |4 - 9| = 5 
P = 3, difference = |6 - 7| = 1 
P = 4, difference = |10 - 3| = 7

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:
  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [2..100,000];
each element of array A is an integer within the range [-1,000..1,000].
*/

public class TapeEquilibrium {

	public static int solution(int[] A) {

		int best = (int) Integer.MAX_VALUE; // smallest difference
		int sumA, sumB; // sum of values in first and second array
		int diff; // difference between them

		// just move the cutting point and check differences		
		for (int j = 1; j < A.length; j++) {

			sumA = 0;
			sumB = 0;
			
			for (int i = 0; i < A.length; i++) {
				if (i < j)
					sumA += A[i];
				else
					sumB += A[i];
			}

			//System.out.println("< sumA = " + sumA + " ; sumB = " + sumB + " >");

			diff = Math.abs(sumA - sumB);

			if (diff == 0)
				return 0;

			if (diff < best)
				best = diff;
		}

		return best;
	}

	public static int altSolution(int[] A) {

		int best = (int) Integer.MAX_VALUE; // smallest difference
		int diff; // difference between sum of 1st and 2nd array
		
		// sum of values in first and second array
		int sumA = A[0];
		int sumB = 0;
		//
		
		for (int i = 1; i < A.length; i++)
			sumB += A[i];
		
		// at beginning 1st array contains only first element of original array A, 2nd array contains rest of them
		// then elements from 2nd array go to the 1st, one by one

		for (int i = 1; i < A.length; i++) {
			diff = Math.abs(sumA - sumB);

			if (diff == 0)
				return 0;

			if (diff < best)
				best = diff;

			if (i < A.length - 1) {
				sumA += A[i];
				sumB -= A[i];
			}
		}

		return best;
	}

	public static void main(String[] args) {

		System.out.println("A = [2, 3, 1, 5]");
		System.out.println(altSolution(new int[] { 2, 3, 1, 5 }));
		System.out.println("");
		System.out.println("A = [13, 5]");
		System.out.println(altSolution(new int[] { 13, 5 }));
		System.out.println("");
		System.out.println("A = [-1000, 1000]");
		System.out.println(altSolution(new int[] { -1000, 1000 }));
		System.out.println("");
		System.out.println("A = [3, 1, 2, 4, 3]");
		System.out.println(altSolution(new int[] { 3, 1, 2, 4, 3 }));
		System.out.println("");
	}

}
