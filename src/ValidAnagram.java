public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        boolean res = false;

        if (s == null || t == null)
            return res;
        int sLen = s.length(), tLen = t.length();
        int totalCharSetInCache = 0;
        int[] cache = new int[256];
        for (int i = 0; i < sLen; i++) {
            cache[s.charAt(i)]++;
            totalCharSetInCache++;
        }
        for (int i = 0; i < tLen; i++) {
            int ch = t.charAt(i);
            if (cache[ch] > 0) {
                cache[ch]--;
                totalCharSetInCache--;
            } else {
                return false;
            }
        }

        if(totalCharSetInCache == 0)
            res = true;

        return res;
    }

    public static void main(String[] args) {
        String s = "TRIANGLE";
        String t = "INTEGRAL";
        System.out.println(isAnagram(s, t));
    }

}