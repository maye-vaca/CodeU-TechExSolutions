import java.util.ArrayList;
import java.util.Collections;
public class solution {
    //private instance variables for kth longest palindrome
    private static ArrayList<Integer> palin;
    private static int lastChecked;

    //private instance variables for longest palindromic subsequence
    private static int[] max;

    //private instance variables for ugly numbers
    private static  ArrayList<Integer> uglyNum;
    private static int last2 = 0;
    private static int last3 = 0;
    private static int last5 = 0;

    public solution() {
	palin = new ArrayList<Integer>();
	palin.add(1);
	lastChecked = 1;

	max = new int[2];

	uglyNum = new ArrayList<Integer>();
	uglyNum.add(1);	
    }
        /**
     *Returns the kth number whose binary string is palindromic
     *This method pads the binary string with ONE leading zero if 
     *the number is even. 
     *@param  k  the number to be found whose binary is palindromic
     *@return    the kth palindromic number
     */
    public static int kthBinaryPalindrome(int k) {
	if (k > palin.size()) {
	    if(checkIfPalin(++lastChecked)) {
		palin.add(lastChecked);
	    }
	    return kthBinaryPalindrome(k);
	} else {
	    return palin.get(k-1);
	}
    }
    /**
     *Helper method that determines if a number is a palindrome in binary
     *This method pads the binary string with ONE leading zero if 
     *the number is even. 
     *@param  num the number to be checked
     *@return     boolean representing if the number is palindromic
     */

    public static boolean checkIfPalin(int num) {
	String bin = Integer.toBinaryString(num);
	if ((num % 2) == 0) {
	    bin = "0" + bin;
	}

	for (int i = 0; i < bin.length()/2; i++) {
	    if (!(bin.charAt(i) == bin.charAt(bin.length()-1-i))) {
		return false;
	    }
	}
	return true;
    }

    /**
     *This method finds the longest substring of the input that's a
     *palindrome. It uses dynamic program to keep track of which 
     *subsequences are already palindromic
     *@param  s  the string to be checked for palindromes
     *@return    the longest palindromic substring of s
     */
    public static int[] findLongestPalindrome(String s) {
	int n = s.length();
	int maxInd = 0;
	int maxLength = 1;
	boolean table[][] = new boolean[n][n];
	//all strings of size 1 are palindromes so fill in true for all 
	//single character strings
	for (int i = 0; i < n; i++) {
	    table[i][i] = true;
	}
	//find all pairs of characters that are the same (ie '11', '22')
	//and mark them as true in the table.
	for (int i = 0; i < n-1; i++) {
	    if (s.charAt(i) == s.charAt(i+1)) {
		 table[i][i+1] = true;
		 maxInd = i;
		 maxLength = 2;
	     }
	}
	//using the single and double character palindromes as base cases
	//find palindromes of length 3 or larger
	for (int length = 3; length <= n; length++) {
	    for (int left = 0; left < n-length+1; left++) {
		int right = left+length-1;
		if ((s.charAt(left)== s.charAt(right)) 
		    && table[left+1][right-1]) {
		    table[left][right] = true;
		    maxInd = left;
		    maxLength = length;
		}
	    }
	}
	max[0] = maxInd;
	max[1] = maxLength;
	return max;
    }

    /**
     *This method finds the nth ugly number as specified by the input.
     *Uses dynamic programming to maintain an arraylist of previously
     *found ugly numbers
     *@param n the number to be found (ie 2: find the 2nd ugly number)
     *@return the nth ugly number
     */

    public static int uglyNumber(int n) {
	if (n <= uglyNum.size()) {
	    return uglyNum.get(n-1);
	} else {
	    int nextNum = Math.min(uglyNum.get(last2)*2,
				   Math.min(uglyNum.get(last3)*3,
					    uglyNum.get(last5)* 5));
	    if (nextNum == uglyNum.get(last2)*2) {
		if(!uglyNum.contains(uglyNum.get(last2)*2))  {
		    uglyNum.add(uglyNum.get(last2)*2);
		}
		last2++;
	    } else if (nextNum ==uglyNum.get(last3)*3) {
		if(!uglyNum.contains(uglyNum.get(last3)*3))  {
		    uglyNum.add(uglyNum.get(last3)*3);
		}
		last3++;
	    }
	    else if (nextNum == uglyNum.get(last5)*5) {
		if(!uglyNum.contains(uglyNum.get(last5)*5))  {
		    uglyNum.add(uglyNum.get(last5)*5);
		}
		last5++;
	    }
	    return uglyNumber(n);
	}
    }


    public static  void main(String[] args) {
	solution S = new solution();
	System.out.println("TESTING Kth Binary Palindrome");
	int kthPalin = kthBinaryPalindrome(9);
	System.out.println(kthPalin);
	System.out.println(palin.toString());

	
	System.out.println("TESTING LONGEST PALINDROME");
	int[] ans = findLongestPalindrome("32112211143");
	System.out.print(ans[0] + " " + ans[1]);

	System.out.println("TESTING UGLY NUMBER");
        int num = uglyNumber(20);
	System.out.println(num);
	System.out.println(uglyNum.toString());
    }
}
