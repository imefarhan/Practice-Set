/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

Follow up:

    This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
    Would this affect the run-time complexity? How and why?

*/


public class SearchInARotatedSortedArrayTwo {

    public static boolean search2(int[] nums, int target) {

        int n = nums.length;
        if (n == 0) return false;

        int start = 0;
        int end = n - 1;

        //Find the largest rightmost element...
        // 1,1,3,1
        while (start + 1 < end) {
            System.out.println("Start -> " + start + " End -> " + end);
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[start]) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        int largest = nums[start] > nums[end] ? start : end;
        System.out.println("largest -> " + largest);

        // 0 to largest    OR   largest+1 to n-1
        if (target == nums[largest] || target == nums[n - 1] || target == nums[0]) {
            return true;
        } else if (target < nums[largest] && target > nums[0]) {
            start = 0;
            end = largest - 1;
        } else {
            start = largest + 1;
            end = n - 1;
        }

        System.out.println("Start -> " + start + " End -> " + end);
        while (start <= end) {
            System.out.println("Start -> " + start + " End -> " + end);
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && nums[mid] > target)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (nums[mid] < nums[start]) {
                if (nums[end] >= target && nums[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else start++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 1, 1, 1};
        System.out.println(search2(input, 3));
    }
}
