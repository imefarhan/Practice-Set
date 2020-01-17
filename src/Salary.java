import java.util.Scanner;

public class Salary {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = 0;
        if(sc.hasNext())
            t = sc.nextInt();

        for(int test = 1; test<=t; test++) {
            int x=0, n=0;
            if(sc.hasNext())
                x = sc.nextInt();
            if(sc.hasNext())
                n = sc.nextInt();
            int i = 1, sum = 0;
            int sal = 0;
            while(sal < n) {
                sum += sal;
                sal = x * i;
                i++;
            }
            System.out.println(sum);
        }
    }
}
