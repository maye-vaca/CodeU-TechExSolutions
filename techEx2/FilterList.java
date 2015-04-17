import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class FilterList {
    // Write a function named "evens" that takes as input a
    // list of Integer (almost but not quite int) and returns
    // a new list of ints containing only the even elements
    // of the input.
    public static List<Integer> evens(List<Integer> input) {
        // Here are some reminders:
        //
        // You can find input's length using input.size().
        //
        // You can find the remainder of a division using %. For instance,
        // 2 == 11%3 and 1 == 25 % 4.
        //
        // You can declare a new list named "clown" of length n with the
	// syntax:
        //
        // List<Integer> clown = new ArrayList<Integer>(10);

        // STUDENTS, WRITE CODE HERE.
	List<Integer> evensOnly = new ArrayList<Integer>();
	//Go through each integer in the list
	for(Integer i :input) {
	    //If the number is even, add it to a evensOnly list
	    if (i% 2 == 0) {
		evensOnly.add(i);
	    }
	}
	//return the list
	return evensOnly;
    }

    public static void main(String[] args) {
	Random r = new Random();
        List<Integer> test1 =
            new ArrayList<Integer>(Arrays.asList(8,6,7,5,3,0,9));
        List<Integer> ans = evens(test1);
        // Expected output: 8, 6, 0
        for (Integer n: ans) {
            System.out.print(Integer.valueOf(n) + ", ");
        }
        System.out.println();

        List<Integer> test2 =
            new ArrayList<Integer>(Arrays.asList(2,7,18,28,18,28,45,90,45));
        ans = evens(test2);
        // Expected output: 2, 18, 28, 18, 28, 90
        for (Integer n: ans) {
            System.out.print(Integer.valueOf(n) + ", ");
        }
        System.out.println();
	//Create an randomly generated, randomly sized list of numbers
	List<Integer> test3 = new ArrayList<Integer>();
	for (int i = 0; i < r.nextInt(); i++) {
	    test3.add(r.nextInt());
	}
	ans = evens(test3);
	boolean failed = false;
	int count = 0;
	for (Integer i : test3) {
	    if (i%2 == 0) {
		count++;
	    }
	}
	//test the size of the answer for consistency before taking the time
	//to go through all of the items to check if they are even.
	if (ans.size() != count) {
	    System.out.println("TEST FAILED");
	} else {
	    for (Integer i : ans) {
		if (i%2 == 1) {
		    System.out.println("TEST FAILED");
		    failed = true;
		    break;
		}
	    }
	    if (!failed) {
		System.out.println("Test Passed");
	    }
	}
        // STUDENTS: ADD YOUR TEST CASES HERE.
    }
}
