/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

*/

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int n = nums.length;
        if (n == 0) return -1;

        int start = 0;
        int end = n - 1;

        //Find the start point of the array...
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        int smallest = start;
        System.out.println("Smallest -> " + smallest);

        if(target == nums[smallest]) {
            return smallest;
        } else if(target > nums[smallest] && target <= nums[n-1]) {
            start = smallest;
            end = n-1;
        } else {
            start = 0;
            end = smallest;
        }

        while (start <= end) {
            System.out.println("Start -> " + start+" End -> "+end);
            int mid = start + (end - start) / 2;
            if(target == nums[mid]) {
                return mid;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {1, 3};
        System.out.println(search(input, 3));
    }
}
