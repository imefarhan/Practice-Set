import java.util.Arrays;

public class LongestPalindromicSubstring {

    //Manacher's Algorithm
    //https://www.youtube.com/watch?v=nbTSfrEfo6M

    public static String longestPalindrome(String s) {

        if (s == null)
            return "";

        int slen = s.length();
        char[] T = new char[2 * slen + 1];
        T[0] = '#';
        int j = 1;
        for (int i = 0; i < slen; i++) {
            T[j++] = s.charAt(i);
            T[j++] = '#';
        }
        System.out.println(Arrays.toString(T));

        int tlen = T.length;
        int[] P = new int[tlen];
        int center = 0, rightBoundary = -1, radius, maxRadiusSoFar = -1, indexForMax = -1;
        for (int i = 0; i < T.length; ++i) {
            if (i <= rightBoundary) {
                radius = Math.min(P[2 * center - i], rightBoundary - i);
            } else {
                radius = 0;
            }
            // Try to extend
            while (i + radius < T.length && i - radius >= 0 && T[i - radius] == T[i + radius]) {
                radius++;
            }
            P[i] = radius;
            if (i + radius - 1 > rightBoundary) {
                center = i;
                rightBoundary = i + radius - 1;
            }
            if (P[i] > maxRadiusSoFar) {
                maxRadiusSoFar = P[i];
                indexForMax = i;
            }
        }
        System.out.print(Arrays.toString(P));
        System.out.println("\nmax -> " + maxRadiusSoFar + " index -> " + indexForMax);

        StringBuffer sb = new StringBuffer();
        int startIndex = indexForMax - maxRadiusSoFar + 1;
        int endIndex = indexForMax + maxRadiusSoFar - 1;
        System.out.println("start -> " + startIndex + " end -> " + endIndex);
        for (; startIndex < endIndex; startIndex++) {
            if (T[startIndex] != '#')
                sb.append(T[startIndex]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "babad";       //OUTPUT -> ababb
        String t = "abaxabaxabb";         //OUTPUT -> baxabaxab
        System.out.println(longestPalindrome("ababb"));
    }
}
