package lesson6Sorting;

/*
An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 <= P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:
  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:
  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:
  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1
the function should return 0.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..100,000];
each element of array A is an integer within the range [-2,147,483,648..2,147,483,647].
*/

import java.util.*;

public class Triangle {

	public static int solution(int[] A) {
		
		if (A == null)
			return 0;

		if (A.length < 3)
			return 0;

		long sideAplusSideB = 0; // sum of two shorter sides of triangle

		Arrays.sort(A); // sort array ascending

		for (int i = 0; i < A.length - 2; i++) {

			sideAplusSideB = (long) A[i] + (long) A[i + 1];
			
			// if longest side of triangle is shorter than sum of others
			if ((long) A[i + 2] < sideAplusSideB)
				return 1;
		}

		return 0;
	}

	public static void main(String[] args) {

		System.out.println("A = [10, 2, 5, 1, 8, 20]");
		System.out.println(solution(new int[] { 10, 2, 5, 1, 8, 20 }));
		System.out.println("");
		System.out.println("A = [MAX, MAX, MAX]");
		System.out.println(solution(new int[] { (int) Integer.MAX_VALUE, (int) Integer.MAX_VALUE, (int) Integer.MAX_VALUE }));
		System.out.println("");
	}

}
