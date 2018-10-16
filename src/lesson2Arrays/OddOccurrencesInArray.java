package lesson2Arrays;

/*
A non-empty array A consisting of N integers is given. The array contains an odd number of elements,
and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:
  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:
  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Write an efficient algorithm for the following assumptions:
N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.
 */

import java.util.*;

class OddOccurrencesInArray {
	public static int solution(int[] A) {

		if (A == null)
			return -1;

		if (A.length == 0)
			return -1;

		if (A.length == 1) // single item array
			return A[0];

		Arrays.sort(A); // sort array ascending
		
		int temp = 0;
		int counter = 1;

		// check whole array for odd number of items of this same value
		for (int i = 0; i < A.length; i++) {
			if (A[i] == temp)
				counter++;
			else {
				if (counter % 2 == 1 && i > 0) // odd number of items of this same value
					return temp;
				else {
					temp = A[i];
					counter = 1;
				}
			}
		}
		//
		
		if(counter == 1) // last element of array is odd
			return temp;
		else // error
			return -1;
	}

	public static void main(String[] args) {

		System.out.println("A = [9, 3, 9, 3, 9, 7, 9]");
		System.out.println(solution(new int[] { 9, 3, 9, 3, 9, 7, 9 }));
		System.out.println("");
		System.out.println("A = [42]");
		System.out.println(solution(new int[] { 42 }));
		System.out.println("");
		System.out.println("A = [2, 2, 3, 3, 4]");
		System.out.println(solution(new int[] { 2, 2, 3, 3, 4 }));
		System.out.println("");
	}
}