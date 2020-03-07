import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        int maxLen = 0, startIndex = 0;

        /*Here instead of HashMap we could also use an Array of length 128 and map all the characters' occurence to their
        corresponding indices and then calculate the maxLength */
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (hm.containsKey(ch)) {
                startIndex = Math.max(startIndex, hm.get(ch)+1);
            }
            maxLen = Math.max(maxLen, i - startIndex + 1);
            hm.put(ch, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
