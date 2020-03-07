/*
Given an array nums of n integers, are there elements a, b, c in nums
such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        int finalTarget = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int fixedVal = nums[i];
            for (int j = i + 1; j < n - 1 ; j++) {
                if(j > i+1 && nums[j]==nums[j-1])
                    continue;
                int currentSum = fixedVal + nums[j];
                int requiredValue = finalTarget - currentSum;
                int index = binSearch(requiredValue, j + 1, nums);
                if (index > 0) {
                    resultList.add(Arrays.asList(fixedVal, nums[j], nums[index]));
                }
            }
        }
        return resultList;
    }

    public static int binSearch(int target, int start, int[] nums) {

        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        //-1, 0, 1, 2, -1, -4
        int[] input = {0,0,0,0};
        System.out.println(threeSum(input));
    }
}
