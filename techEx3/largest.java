import java.util.Random;
public class largest {
    private int[] nums;
    private Random rand = new Random();
    public largest(int[] numbers) {
	this.numbers = numbers;
    }
    //find the nth largest number using quickSelect
    public int nthLargest(int n) throws Exception {
	if (n >= this.nums.length) {
	    throw new Exception();
	}
	int left = 0;
	int right = this.nums.length - 1;
	while (true) {
	    int length = partition(left, right, rand.nextInt(right));
	    if (length == n) {
		return this.nums[n];
	    }else if (length > n) {
		right = length;
	    } else {
		left = length;
	    }
	}

    }
    //partition the data with numbers larger than the pivot on the left
    public int partition(int left, int right, int pivot) {
	pivotValue = this.nums[pivot];
	swap(pivot, right);
	storeIndex = left;
	for (int i = left; i<right; i++) {
	    if (this.nums[i] > pivotValue) {
		swap(storeIndex, i);
		storeIndex++;
	    }
	}
	swap(storeIndex, right);
	return storeIndex;
    }
    //swap the numbers at a and b
    public void swap(int a, int b) {
	int temp = this.nums[a];
	this.nums[a] = this.nums[b];
	this.nums[b] = temp;
    }
}
