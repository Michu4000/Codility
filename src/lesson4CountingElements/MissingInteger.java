package lesson4CountingElements;

/*
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
Given A = [1, 2, 3], the function should return 4.
Given A = [-1, -3], the function should return 1.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [-1,000,000..1,000,000].
*/

import java.util.*;

public class MissingInteger {

	public static int solution(int[] A) {

		if (A == null) // if arg is null
			return 1;

		if (A.length == 0) // if array is blank
			return 1;

		Arrays.sort(A); // sort array ascending

		// get idx of 1st positive value
		int posNumberIdx = -1;

		for (int i = 0; i < A.length; i++)
			if (A[i] > 0) {
				posNumberIdx = i;
				break;
			}
		//

		//System.out.println("posValIdx=" + posNumberIdx); //

		if (posNumberIdx == -1) // if there aren't any positive values
			return 1;

		// copy all positive values to new array
		int[] posA = Arrays.copyOfRange(A, posNumberIdx, A.length); 
		//
		
		//System.out.println("{" + Arrays.toString(posA) + "}"); //

		// if smallest value in array is greater than 1
		if (posA[0] > 1)
			return 1;
		//
		
		// typical case
		for (int i = 0; i < posA.length - 1; i++)
			if (posA[i + 1] > posA[i] + 1)
				return posA[i] + 1;
		//
		
		// when all natural numbers in range 1...max(A) exist in array
		return posA[posA.length - 1] + 1;
		//
	}

	public static void main(String[] args) {

		System.out.println("[]");
		System.out.println(solution(new int[] {}));
		System.out.println("");
		System.out.println("<null>");
		System.out.println(solution(null));
		System.out.println("");
		System.out.println("[1, 0, -1, 3, 2]");
		System.out.println(solution(new int[] { 1, 0, -1, 3, 2 }));
		System.out.println("");
		System.out.println("[-1]");
		System.out.println(solution(new int[] { -1 }));
		System.out.println("");
		System.out.println("[0]");
		System.out.println(solution(new int[] { 0 }));
		System.out.println("");
		System.out.println("[1]");
		System.out.println(solution(new int[] { 1 }));
		System.out.println("");
		System.out.println("[3]");
		System.out.println(solution(new int[] { 3 }));
		System.out.println("");
		System.out.println("[-7, -5, 0, 8, 3, 2]");
		System.out.println(solution(new int[] { -7, -5, 0, 8, 3, 2 }));
		System.out.println("");
		System.out.println("[-1000000, 1000000]");
		System.out.println(solution(new int[] { -1000000, 1000000 }));
		System.out.println("");
		System.out.println("[-1000000, 10, 1000000]");
		System.out.println(solution(new int[] { -1000000, 10, 1000000 }));
		System.out.println("");
		System.out.println("[-1000000, 1, 1000000]");
		System.out.println(solution(new int[] { -1000000, 1, 1000000 }));
		System.out.println("");
		System.out.println("[-1000000, 0, 1000000]");
		System.out.println(solution(new int[] { -1000000, 0, 1000000 }));
		System.out.println("");
		System.out.println("[-1, -1, 0, 0, 1, 1]");
		System.out.println(solution(new int[] { -1, -1, 0, 0, 1, 1 }));
	}
}