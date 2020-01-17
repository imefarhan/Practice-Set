import java.util.Scanner;

public class Cnote {
    public static void main(String[] sss) {
        Scanner sc = new Scanner(System.in);
        int t = 0;
        if (sc.hasNext())
            t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            int x = 0, y = 0, k = 0, n = 0;
            if (sc.hasNext())
                //total
                x = sc.nextInt();
            if (sc.hasNext())
                //pagesLeft
                y = sc.nextInt();
            if (sc.hasNext())
                //moneyLeft
                k = sc.nextInt();
            if (sc.hasNext())
                //NoOfNotebooks
                n = sc.nextInt();

            String res = "UnluckyChef";
            int pagesNeeded = x - y;
            for (int i = 0; i < n; i++) {
                if ((sc.nextInt() >= pagesNeeded) && (sc.nextInt() <= k)) {
                    res = "LuckyChef";
                }
            }
            if(y >= x) {
                res = "LuckyChef";
            }
            System.out.println(res);
        }
    }
}
