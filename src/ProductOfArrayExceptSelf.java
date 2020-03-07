import java.util.Arrays;

public class ProductOfArrayExceptSelf {
/*
Input:  [1,2,3,4]
Output: [24,12,8,6]
No Division Allowed.
*/

/*
* Algorithm: Runtime -> O(n) and Space -> O(n)
1) Construct a temporary array left[] such that left[i] contains product of all elements on left of arr[i] excluding arr[i].
2) Construct another temporary array right[] such that right[i] contains product of all elements on on right of arr[i] excluding arr[i].
3) To get prod[], multiply left[] and right[].
*/
    public static int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] prod = new int[n];
        Arrays.fill(prod, 1);
        for(int i=1; i<n; i++) {
            prod[i] = prod[i-1] * nums[i-1];
        }

        int p = nums[n-1];
        for (int i=n-2; i>=0; i--) {
            prod[i] *= p;
            p *= nums[i];
        }
        return prod;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        int[] output = productExceptSelf(input);
        System.out.println();
        for(int i=0; i<output.length; i++)
            System.out.print(output[i] + " ");
    }

}
