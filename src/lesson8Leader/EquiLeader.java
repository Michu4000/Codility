package lesson8Leader;

/*
A non-empty array A consisting of N integers is given.
The leader of this array is the value that occurs in more than half of the elements of A.
An equi leader is an index S such that 0 <= S < N - 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1] have leaders of the same value.

For example, given array A such that:
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [-1,000,000,000..1,000,000,000].
*/

import java.util.*;

class EquiLeader {
	public static int solution(int[] A) {
		
		if (A.length == 1)
			return 0;

		int[] tempArrayA, tempArrayB;
		int leaderA = -1, leaderB = -1; // index of leader in first and second array

		int res = 0; // result

		for (int i = 1; i < A.length; i++) {
			
			// split array into two
			tempArrayA = Arrays.copyOfRange(A, 0, i);
			tempArrayB = Arrays.copyOfRange(A, i, A.length);

			// find index of leader in first and second array
			leaderA = findLeader(tempArrayA);
			leaderB = findLeader(tempArrayB);

			// if there is no leader
			if (leaderA < 0 || leaderB < 0)
				continue;

			// if both leaders are the same
			if (tempArrayA[leaderA] == tempArrayB[leaderB])
				res++;

			//System.out.println(); //
		}

		return res;
	}

	// find index of leader
	public static int findLeader(int[] A) {

		//System.out.println(Arrays.toString(A)); //

		if (A.length == 1)
			return 0;

		// clone array and sort it ascending
		int[] B = Arrays.copyOf(A, A.length);
		Arrays.sort(B);

		int counter = 0;
		int maxCounter = 0;
		int leader = 0;

		for (int i = 0; i < B.length - 1; i++) {
			if (B[i] - B[i + 1] == 0)
				counter++;
			else if (counter > maxCounter) {
				maxCounter = counter;
				counter = 0;
				leader = B[i];
			}
		}

		// if last value == last but one value and it's leader
		if (counter > maxCounter) {
			maxCounter = counter;
			counter = 0;
			leader = B[B.length - 1];
		}

		// there is no leader
		if (maxCounter < A.length / 2)
			return -1;

		// find leader in original array
		for (int i = 0; i < A.length; i++) {
			if (A[i] == leader)
				return i;
		}

		return -2; // error
	}

	public static void main(String[] args) {

		System.out.println("A = [4, 3, 4, 4, 4, 2]");
		System.out.println(solution(new int[] { 4, 3, 4, 4, 4, 2 }));
		System.out.println("");
	}

}
