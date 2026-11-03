public class Main {
    private static int gottaFindIt(int value, int[] nums) {
        // OH! by the way, fun lil factoid;
        // the numbers generated below are UNSORTED, they're birthdays of people I know (including mine)

        // as for the steps:
        // there's a pretty simple way this works; there's two pointers.
        // the first pointer's at the left, it checks if the value there exists.
        // the other one's at the right. does the same thing. then it moves the left forward and the right backward.
        // this loops until the pointers cross over then returns at -1 if it's not found at all.

        // Time complexity - O(n)

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == value) {
                return left;
            }

            if (left != right && nums[right] == value) {
                return right;
            }

            left++;
            right--;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1005, 1202, 1004, 1226, 1029, 3103, -1022, -2906, -1404};
        // sets up the numbers

        int findMyValues = 1202;
        int index = gottaFindIt(findMyValues, nums);

        if (index == -1) {
            System.out.println("Hey dude, " + findMyValues + " isn't here. Come again another day, yeah?.");
        } else {
            System.out.println("Oh. " + findMyValues + ", right? Yeah, right here. It's just at aisle " + index);
        }

        findMyValues = 3047;
        index = gottaFindIt(findMyValues, nums);

        if (index == -1) {
            System.out.println("Hey dude, " + findMyValues + " isn't here. Come again another day, yeah?.");
        } else {
            System.out.println("Oh. " + findMyValues + ", right? Yeah, right here. It's just at aisle " + index);
        }
    }
}