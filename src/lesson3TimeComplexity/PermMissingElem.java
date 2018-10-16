package lesson3TimeComplexity;

/*
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)],
which means that exactly one element is missing.
Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:
  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
*/

import java.util.*;

public class PermMissingElem {

	public static int solution(int[] A) {

		if (A == null)
			return 1;

		if (A.length == 0) // blank array
			return 1;

		if (A.length == 1) { // single item array
			if (A[0] == 1) // A = { 1 }
				return 2;
			else // A = { 2 }
				return 1;
		}

		Arrays.sort(A); // sort array ascending
		
		// 1st item is missing
		if(A[0] != 1)
			return 1;
		//

		// last item is missing
		if (A[A.length - 1] != A.length + 1)
			return A[A.length - 1] + 1;
		//
		
		// typical case
		for (int i = 0; i < A.length - 1; i++) 
			if (A[i] + 1 != A[i + 1])
				return A[i] + 1;
		//
		
		return -1; // error
	}

	public static void main(String[] args) {
		
		System.out.println("A = [2, 3, 1, 5]");
		System.out.println(solution(new int[] { 2, 3, 1, 5 }));
		System.out.println("");
		System.out.println("A = []");
		System.out.println(solution(new int[] {}));
		System.out.println("");
		System.out.println("A = [1]");
		System.out.println(solution(new int[] { 1 }));
		System.out.println("");
		System.out.println("A = [1, 2]");
		System.out.println(solution(new int[] { 1, 2 }));
		System.out.println("");
	}

}
