import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // base case: empty prefix

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            int needed = currentSum - k;

            if (prefixSumCount.containsKey(needed)) {
                count += prefixSumCount.get(needed);
            }

            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));   // 2
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));  // 3
    }
}