package lesson7StacksAndQueues;

/*
You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant;
however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers.
H[I] is the height of the wall from I to I+1 meters to the right of its left end.
In particular, H[0] is the height of the wall's left end and H[N-1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular).
Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

class Solution { public int solution(int[] H); }

that, given an array H of N positive integers specifying the height of the wall,
returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:
  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8
the function should return 7. The figure shows one possible arrangement of seven blocks.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
each element of array H is an integer within the range [1..1,000,000,000].
*/

//import java.util.*;

public class StoneWall {

	public static int solution(int[] H) {

		if (H.length == 1)
			return 1;

		int res = 0; // result
		boolean notEmpty; // are there any blocks left

		do {
			notEmpty = false;

			for (int j = 0; j < H.length; j++) {

				if (H[j] == 0)
					continue;
				
				notEmpty = true; // H[j] > 0 => there is a block

				int val = H[j]; // block's height

				for (int i = j; i < H.length; i++) {
					
					if (H[i] >= val) { // destroy block
						H[i] -= val;

						if (i == H.length - 1) { // block ends at the end of the wall
							//System.out.println("res++"); //
							res++;
						}
						
					} else { // block ends
						//System.out.println("res++"); //
						res++;
						// next block
						j = i - 1;
						break;
					}
				}
				//System.out.println(Arrays.toString(H)); //
			}
		} while (notEmpty);

		return res;
	}

	public static void main(String[] args) {

		System.out.println("A = [8, 8, 5, 7, 9, 8, 7, 4, 8]");
		System.out.println(solution(new int[] { 8, 8, 5, 7, 9, 8, 7, 4, 8 }));
		System.out.println("");
	}

}
