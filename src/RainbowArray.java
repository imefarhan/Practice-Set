import java.util.Scanner;
import java.util.Stack;

//https://www.codechef.com/AUG17/problems/RAINBOWA/

public class RainbowArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 0;
        if (sc.hasNext())
            t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            int n = 0;
            if (sc.hasNext())
                n = sc.nextInt();

            int ar[] = new int[n];

            for(int i=0; i<n; i++) {
                ar[i] = sc.nextInt();
            }

            String ans = "yes";
        }
    }
}
