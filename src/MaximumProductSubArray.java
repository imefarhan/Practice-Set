public class MaximumProductSubArray {

    public static int maxProduct(int[] nums) {
        if (nums.length == 0)
            return -1;
        int curr_max = nums[0];
        int curr_min = nums[0];
        int max_so_far = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int prev_max = curr_max, val = nums[i];
            curr_max = Math.max(Math.max(curr_max * val, curr_min * val), val);
            curr_min = Math.min(Math.min(prev_max * val, curr_min * val), val);
            max_so_far = Math.max(max_so_far, curr_max);
        }

        return max_so_far;
    }

    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 0, -1, 2, 1, 5, 4};
        System.out.println(maxProduct(input));
    }
}
