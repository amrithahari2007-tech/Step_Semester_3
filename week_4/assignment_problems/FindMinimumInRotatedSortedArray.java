public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // minimum is in the right half
                left = mid + 1;
            } else {
                // minimum is in the left half (including mid)
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));         // 1
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));   // 0
        System.out.println(findMin(new int[]{11, 13, 15, 17}));        // 11
    }
}