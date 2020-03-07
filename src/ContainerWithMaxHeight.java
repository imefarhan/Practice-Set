/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container and n is at least 2.

EXAMPLE :
Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/

public class ContainerWithMaxHeight {

    public static int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int start = 0, end = n - 1;
        while (start < end) {
            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));
            // increment/decrement the smaller wall
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        //2,3,4,5,18,17,6
        //1, 8, 6, 2, 5, 4, 8, 3, 7
        int[] input = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxArea(input));
    }
}
