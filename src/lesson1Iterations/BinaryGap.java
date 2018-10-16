package lesson1Iterations;

/*
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones
at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
The number 20 has binary representation 10100 and contains one binary gap of length 1.
The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000
and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0
if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001
and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has
binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..2,147,483,647].
*/

import java.util.*;

public class BinaryGap {

	public static int solution(int N) {
		
		int n = 0; // power of 2
		int val = 0; // 2 raised to n-1
		int remain = N; // remaining value
		ArrayList<Integer> ar = new ArrayList<>(); // subsequent powers of 2

		// find smallest power of 2 which gives value greater than remaining value
		while (remain > 0) {
			n = 0;
			while ((int) Math.pow(2, n) <= remain) {
				n++;
				//System.out.println("n=" + n); //
			}

			ar.add(n - 1); // add n-1 to list
			val = (int) Math.pow(2, n - 1); // 2^(n-1)
			//System.out.println("val=" + val); //
			remain = remain - val; // subtract 2^(n-1) from the remaining value
			//System.out.println("remain=" + remain); //
		}

		//System.out.println(Arrays.toString(ar.toArray())); //

		// find biggest difference between powers of 2 => this gives (binary gap + 1)
		int x = 0;
		for (int i = 0; i < ar.size() - 1; i++)
			if (ar.get(i) - ar.get(i + 1) > x)
				x = ar.get(i) - ar.get(i + 1);

		if (x == 0)
			return 0;
		else
			return x - 1;
	}

	public static int altSolution(int N) {

		boolean startflag = false; // did "1" occur
		int ans = 0; // answer
		int x = 0; // "0" counter

		// do division by 2 as long as N > 0
		while (N > 0) {
			if (N % 2 == 1) { // is N odd
				startflag = true; // if yes begin counting ("1" occurred)
				if (x > ans) // if "0" counter has bigger value than previous
								// one => update the answer
					ans = x;
				x = 0; // wipe counter
			} else if (startflag) // if N is even and "1" occurred => count "0"
				x++;

			N /= 2;
		}
		//

		return ans;
	}

	public static void main(String[] args) {
		
		System.out.println("145");
		System.out.println(altSolution(145));
		System.out.println("");
		System.out.println("32");
		System.out.println(altSolution(32));
		System.out.println("");
		System.out.println("13");
		System.out.println(altSolution(13));
		System.out.println("");
		System.out.println("72");
		System.out.println(altSolution(72));
		System.out.println("");
		System.out.println("15");
		System.out.println(altSolution(15));
		System.out.println("");
	}

}
