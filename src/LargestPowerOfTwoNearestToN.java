public class LargestPowerOfTwoNearestToN {

    public static int largestPowerOfTwo(int n) {
        return (n+1)>>1;
    }

    public static void main(String[] args) {
        System.out.println(largestPowerOfTwo(15));
    }
}
