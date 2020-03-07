import java.util.Arrays;
import java.util.Collections;

public class CountNumberOf1sFrom1ToN {

    public static int[] countBits1(int num) {

        int[] res = new int[num+1];

        for (int i=0; i<=num; i++) {
            int count = 0;
            int n = i;
            while(n>0) {
                n = n & (n-1);
                count++;
            }
            res[i] = count;
        }

        return res;
    }

    public static int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0]= 0;
        if(num==0) return dp;
        for(int i=1;i<num+1;i++){
            if(i%2==0){
                dp[i] = dp[i/2];
            }else{
                dp[i] = dp[i/2]+1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

}
