public class MaximumSubArray {
/*
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

If you have figured out the O(n) solution,
try coding another solution using the divide and conquer approach, which is more subtle.
*/

    public static int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum >= maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(input));
    }

}