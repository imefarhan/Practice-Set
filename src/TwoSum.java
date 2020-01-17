import java.util.HashMap;

public class TwoSum {

    //Time Complexity = O(n)
    //Space Complexity = O(n)
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int len = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int rec = target - nums[i];
            if (hm.containsKey(rec)) {
                res[0] = hm.get(rec);
                res[1] = i;
                break;
            } else {
                hm.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
