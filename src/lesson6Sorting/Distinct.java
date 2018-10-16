package lesson6Sorting;

/*
Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the number of distinct values in array A.

For example, given array A consisting of six elements such that:
 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..100,000];
each element of array A is an integer within the range [-1,000,000..1,000,000].
*/

import java.util.*;

public class Distinct {

	public static int solution(int[] A) {

		if (A == null)
			return 0;

		if (A.length == 0)
			return 0;

		Arrays.sort(A); // sort array ascending

		int res = 1; // result
		int temp = A[0];

		for (int i = 1; i < A.length; i++)
			if (A[i] != temp) {
				res++;
				temp = A[i];
			}

		return res;
	}

	public static void main(String[] args) {

		System.out.println("A = [2, 1, 1, 2, 3, 1]");
		System.out.println(solution(new int[] { 2, 1, 1, 2, 3, 1 }));
		System.out.println("");
	}

}
