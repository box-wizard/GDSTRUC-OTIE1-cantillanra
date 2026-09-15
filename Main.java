public class Main {
    public static void main(String[] args) {
        int[] nums = new int[10];
        nums[0] = 237;
        nums[1] = -53;
        nums[2] = 96;
        nums[3] = 104;
        nums[4] = 395;
        nums[5] = -62;
        nums[6] = 26;
        nums[7] = -8;
        nums[8] = 13;
        nums[9] = 4;

        System.out.println("\n\nBEFORE THE SORT:\n");
        printArray(nums);

        System.out.println("\n\nAFTER THE SORT:\n");
        selectionSort(nums);
        printArray(nums);
        // prints the numbers; the goal? print the first set before then the second set after the sort.
    }
    // selection sort; finds the smallest value and puts it at the end.
    private static void selectionSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int theSmallestIndex = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[theSmallestIndex]) {
                    theSmallestIndex = j;
                }
            }
            int temp = nums[theSmallestIndex];
            nums[theSmallestIndex] = nums[i];
            nums[i] = temp;
        }
    }

    // if 'theDescent' variable wasn't obvious, this line of code was made so that the values of the index would appear in descending order.
    private static void bubbleSort(int[] nums) {
        for (int theDescent = nums.length - 1; theDescent > 0; theDescent--) {
            for (int i = 0; i < theDescent; i++) {
                // this line compares two elements and checks to see if they're in order, these elements are switched onto the next set until they're all in order bla bla bla you get it.
                if (nums[i] < nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }
    // prints the result
    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }
}