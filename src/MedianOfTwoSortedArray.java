
public class MedianOfTwoSortedArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int partX = (low + high) / 2;
            int partY = (x + y + 1) / 2 - partX;

            int maxLeftX = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            int minRightX = (partX == x) ? Integer.MAX_VALUE : nums1[partX];
            int maxLeftY = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            int minRightY = (partY == y) ? Integer.MAX_VALUE : nums2[partY];

            if (maxLeftY <= minRightX && maxLeftX <= minRightY) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
//        int x[] = {1, 3, 8, 9, 15};
//        int y[] = {7, 11, 18, 19, 21, 25};
        //1,3,7,8,9,11,15,18,19,21,25
        int x[] = {1, 2};
        int y[] = {3,4};
        System.out.println(findMedianSortedArrays(x, y));
    }
}