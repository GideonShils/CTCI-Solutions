// Given an array of integers and a target, find all unique sets of 4
// integers that add to the target

import java.util.*;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            // If i is different from the previous int, proceed
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    // If j is different from previous, proceed
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        int newTarget = target - nums[i] - nums[j];
                        int low = j + 1;
                        int high = nums.length - 1;

                        while (low < high) {
                            int sum = nums[low] + nums[high];
                            if (sum == newTarget) {
                                // Found set. Add to results
                                List<Integer> set = new ArrayList<>();
                                set.add(nums[i]);
                                set.add(nums[j]);
                                set.add(nums[low]);
                                set.add(nums[high]);
                                results.add(set);

                                // Continue checking by finding next different high/low
                                while(low < high && nums[low] == nums[low + 1]) {
                                    low++;
                                }
                                low++;

                                while (low < high && nums[high] == nums[high - 1]) {
                                    high--;
                                }
                                high--;
                            } else if (sum < newTarget) {
                                low++;
                            } else {
                                high--;
                            }
                        }
                    }
                }
            }
        }
        return results;
    }

	public static void main(String args[]) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> results = fourSum(arr, 0);
    
        for (List set : results) {
            System.out.print("[");
            for (int i = 0; i < set.size(); i++) {
                System.out.print(set.get(i) + ", ");
            }
            System.out.println("]");
        }
	}
}