import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s,3));
    }

    public static String convert(String s, int numRows) {

        int x = 2*numRows - 2;
        int d = x;
        int len = s.length();
        String str = "";
        int i=0;
        for(; i<len; i++) {
            for(int j=i; j<len; j+=d) {
                str += s.charAt(j);
            }
            d -= 2;
            if(d==0)
                break;
        }
        for(;i<len; i+=x) {
            str += s.charAt(i);
        }
        return str;
    }
}
