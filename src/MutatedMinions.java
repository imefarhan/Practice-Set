import java.util.Scanner;

public class MutatedMinions {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = 0;
        if(sc.hasNext())
            t= sc.nextInt();
        for(int test = 1; test<=t; test++) {
            int n = 0, k=0;
            if(sc.hasNext())
                n = sc.nextInt();
            if(sc.hasNext())
                k = sc.nextInt();
            int count = 0;
            for(int i=0; i<n; i++) {
                if(sc.hasNext()) {
                    int x = sc.nextInt() + k;
                    if(x%7 == 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
