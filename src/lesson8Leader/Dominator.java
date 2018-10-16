package lesson8Leader;

/*
An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that
 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs.
The function should return -1 if array A does not have a dominator.

For example, given array A such that
 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..100,000];
each element of array A is an integer within the range [-2,147,483,648..2,147,483,647].
*/

import java.util.*;

public class Dominator {

	public static int solution(int[] A) {

		if (A == null)
			return -1;

		if (A.length == 0)
			return -1;

		if (A.length == 1)
			return 0;

		// clone array and sort it ascending
		int[] B = Arrays.copyOf(A, A.length);
		Arrays.sort(B);

		int counter = 0;
		int maxCounter = 0;
		int dominator = 0;

		for (int i = 0; i < B.length - 1; i++) {
			if (B[i] - B[i + 1] == 0)
				counter++;
			else if (counter > maxCounter) {
				maxCounter = counter;
				counter = 0;
				dominator = B[i];
			}
		}

		// if last value == last but one value and it's dominator
		if (counter > maxCounter) {
			maxCounter = counter;
			counter = 0;
			dominator = B[B.length - 1];
		}

		// there is no dominator
		if (maxCounter < A.length / 2)
			return -1;

		// find dominator in original array
		for (int i = 0; i < A.length; i++) {
			if (A[i] == dominator)
				return i;
		}

		return -2; // error
	}

	public static void main(String[] args) {

		System.out.println("A = [3, 4, 3, 2, 3, -1, 3 ,3]");
		System.out.println(solution(new int[] { 3, 4, 3, 2, 3, -1, 3, 3 }));
		System.out.println("");
	}

}
