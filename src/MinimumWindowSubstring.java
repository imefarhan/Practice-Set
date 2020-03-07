public class MinimumWindowSubstring {

    public static String minWindow1(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";

        int len = s.length();
        int cache[] = new int[26];
        for (int i = 0; i < len; i++) {
            cache[s.charAt(i) - 'A'] = i;
        }
        return "";
    }

    public static String minWindow2(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        int[] s_cache = new int[256];
        int[] t_cache = new int[256];
        for (char c : t.toCharArray()) t_cache[c]++;

        //Finding the index of first character of 's' that occurs in 't' as well... i.e. the start_index of the window
        int startIndex = nextPos(0, s, t_cache);
        if (startIndex == s.length()) return "";

        int low = startIndex, sCount = 0;
        String res = "";
        while (low <= startIndex && startIndex < s.length()) {
            if (s_cache[s.charAt(startIndex)]++ < t_cache[s.charAt(startIndex)]) sCount++;

            while (low < s.length() && sCount == t.length()) {
                if (res.isEmpty() || startIndex - low + 1 < res.length()) {
                    res = s.substring(low, startIndex + 1);
                }
                if (s_cache[s.charAt(low)]-- <= t_cache[s.charAt(low)]) sCount--;
                low = nextPos(low + 1, s, t_cache);
            }
            startIndex = nextPos(startIndex + 1, s, t_cache);
        }
        return res;
    }

    private static int nextPos(int start, String s, int[] t_dict) {
        while (start < s.length()) {
            char c = s.charAt(start);
            if (t_dict[c] != 0) return start;
            start++;
        }
        return start;
    }

    public static String minWindow3(String s, String t) {
        String res = "";
        if (s.length() == 0 || s.length() < t.length()) return res;

        int[] t_charCount = new int[256];           // track current count of chars in the current window
        boolean[] isReq = new boolean[265];     // this will be required if a char is required
        char[] t_array = t.toCharArray();
        char[] s_array = s.toCharArray();

        for (int i = 0; i < t_array.length; i++) {
            t_charCount[t_array[i]]++;
            isReq[t_array[i]] = true;
        }
        int i = 0, j = 0, m = 0, minLen = Integer.MAX_VALUE;

        while (j < s_array.length) {
            if (isReq[s_array[j]] && t_charCount[s_array[j]] > 0) { // if the new char is required
                m++;                            // incr matches
            }
            t_charCount[s_array[j]]--;                     // reduce the count of this char now required.
            while (i <= j && m == t_array.length) {        // check if all chars are in the current window i,j
                if (minLen > j - i + 1) {             // update min
                    res = s.substring(i, j + 1);  // update res
                    minLen = j - i + 1;
                }
                if (isReq[s_array[i]]) {               // now reduce window from left
                    if (t_charCount[s_array[i]] >= 0) m--;
                    t_charCount[s_array[i]]++;
                }
                i++;
            }
            j++;
        }
        return res;
    }

    public static String minWindow(String s, String t) {
        // HashMap<Character, Integer> map =  new HashMap<>();
        int[] map = new int[128];
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            map[c]++;
        }
        int begin = 0;
        int len = Integer.MAX_VALUE;
        int noOfCharsInT = t.length();
        for (int si = 0, ei = 0; ei < s.length(); ei++) {
            char currentCharInS = s.charAt(ei);
            map[currentCharInS]--;
            if (map[currentCharInS] >= 0)
                noOfCharsInT--;
            while (noOfCharsInT == 0) {
                char lc = s.charAt(si);
                map[lc]++;
                if (map[lc] > 0) {
                    if (ei - si + 1 < len) {
                        begin = si;
                        len = ei - si + 1;
                    }
                    noOfCharsInT++;
                }
                si++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(begin, begin + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
