package lesson6Sorting;

/*
A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 <= P < Q < R < N).

For example, array A such that:
  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is -3 * 1 * 2 = -6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:
  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [3..100,000];
each element of array A is an integer within the range [-1,000..1,000].
*/

import java.util.*;

public class MaxProductOfThree {

	public static int solution(int[] A) {

		int N = A.length;
		Arrays.sort(A); // sort array ascending

		// case 1: only non-negative (positives and 0s) values in array
		if (A[0] >= 0)
			return A[N - 1] * A[N - 2] * A[N - 3];
		//
		
		// case 2: only negative values in array
		if (A[N - 1] < 0)
			return A[N - 1] * A[N - 2] * A[N - 3];
		//
		
		// case 3: positives, 0s and negatives in array
		if (A[0] < 0 && A[N - 1] > 0) {
			if (A[0] * A[1] > A[N - 2] * A[N - 3])
				return A[0] * A[1] * A[N - 1];
			else
				return A[N - 1] * A[N - 2] * A[N - 3];
		}
		//
		
		// case 4: non-positive (negatives and 0s) in array
		if (A[0] <= 0 && A[N - 1] == 0)
			return 0;
		//
		
		return -1; // error
	}

	public static void main(String[] args) {

		System.out.println("A = [10, 2, 5, 1, 8, 20]");
		System.out.println(solution(new int[] { 10, 2, 5, 1, 8, 20 }));
		System.out.println("");
		System.out.println("A = [-5, 5, -5, 4]");
		System.out.println(solution(new int[] { -5, 5, -5, 4 }));
		System.out.println("");
		System.out.println("A = [-5, -6, -4, -7, -10]");
		System.out.println(solution(new int[] { -5, -6, -4, -7, -10 }));
		System.out.println("");
	}

}