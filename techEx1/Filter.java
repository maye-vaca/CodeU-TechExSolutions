import java.util.ArrayList;
public class Filter {
  // Write a function named "evens" that takes as input an array of
  // ints and returns a different array of ints containing
  // only the even elements of the input.
  public static int[] evens(int[] input) {
    // Here are some reminders:
    //
    // You can find input's length using input.length.
    //
    // You can find the remainder of a division using %. For instance,
    //   11 % 3 = 2
    //   25 % 4 = 1
    //
    // You can declare a new array of integers with the syntax:
    //   int[] var_name = new int[n];
    //
    // For example:
    //   int[] clown = new int[10];
    // creates an array named clown of 10 integers (clown[0] through clown[9])
    //
 
    // STUDENTS, WRITE CODE HERE.
      ArrayList<Integer> evens = new ArrayList<Integer>();
      int size = 0;
      for (int i = 0; i < input.length; i++) {
	  if (input[i] % 2 == 0) {
	      evens.add(input[i]);
	      size++;
	  }
      }
      int[] output = new int[size];
      for (int i = 0; i < output.length; i++) {
	  output[i] = evens.get(i);
      }
      return output;
  }

    public static void main(String[] args) {
    //
    // Expected output:
    //  test1 results:
    //  8
    //  6
    //  0
    //  test2 results:
    //  2
    //  18
    //  28
    //  18
    //  28
    //  90
    //
    // STUDENTS, ADD ADDITIONAL TEST CASES BELOW
    //
    int[] test1 = {8,6,7,5,3,0,9};
    int[] ans = evens(test1);
    System.out.println("test1 results:");
    for (int i = 0; i < ans.length; ++i) {
      System.out.println(ans[i]);
    }
    int [] test2 = {2,7,18,28,18,28,45,90,45};
    ans = evens(test2);
    System.out.println("test2 results:");
    for (int i = 0; i < ans.length; ++i) {
      System.out.println(ans[i]);
    }
  }
}

