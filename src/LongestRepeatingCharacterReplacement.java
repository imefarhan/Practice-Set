public class LongestRepeatingCharacterReplacement {

    /*
        Approach: Sliding window approach. Start a window from start of the string. In each step, increase it to one step right.
                  Have a cache (charCountCache) which will store count of each char in current window.
                  In each step, we will add a char to our window (newChar). Increment the new char count in cache.
                  Then calculate the max num of same chars in current window (maxNumOfSameCharsInCurrentWindow).
                  The maxNumOfSameCharsInCurrentWindow value can be calculated by taking the max of its old value, and
                  count (in cache) of newly encountered char (newChar).
                  Suppose we will consider the char with max count in current window as max-char.
                  Number of other characters in current window = window length - max-char count.
                  Now check if we can replace these other chars with max char (numOfOtherChars <= k), to maximize max-char count.
                  If we can, and the window will only have all max-chars, the window is valid.
                  If the window is valid, check and update max length of possible repetitive subsequence (maxRepSubseqLen).
                  If we cannot replace all other chars with max-char (numOfOtherChars > k), the window can't have all max-chars.
                  So the window is invalid. If so, slide the window (move the starting of the window to one step right),
                  in cache decrement the count of leftmost char which we just excluded from window,
                  reset max num of same chars in current window (not needed though).

        Complexity analysis: Time: O(n)
                             Space: O(1), as used cache is fixed (26) size, irrespective of input string lenght.

        */

    public static int characterReplacement(String s, int k) {
        int[] charCountCache = new int[26];  //Will be used to store the number of each char in current window
        int windowStartIndex = 0;       //Starting index of the window
        int windowEndIndex = 0;         //Ending index of the window
        int maxNumOfSameCharsInCurrentWindow = 0;           //Max num of same chars in current window
        int maxRepSubseqLen = 0;                            //Max length of possible repetitive subsequence
        for (windowEndIndex = 0; windowEndIndex < s.length(); windowEndIndex++) {  //Window will keep expanding to right in each step
            char newChar = s.charAt(windowEndIndex);               //The newly added char to right because of window expansion
            charCountCache[newChar - 'A']++;                                         //Increment the new char count
            maxNumOfSameCharsInCurrentWindow = Math.max(maxNumOfSameCharsInCurrentWindow, charCountCache[newChar - 'A']);
            int numOfOtherChars = (windowEndIndex - windowStartIndex + 1) - maxNumOfSameCharsInCurrentWindow;
            if (numOfOtherChars <= k) {             //Valid window, where the num of max-chars can be maximized by filling gaps
                maxRepSubseqLen = Math.max(maxRepSubseqLen, windowEndIndex - windowStartIndex + 1);
            } else {
                charCountCache[s.charAt(windowStartIndex) - 'A']--;
                windowStartIndex++;
                maxNumOfSameCharsInCurrentWindow = 0;
            }
        }

        return maxRepSubseqLen;
    }

    public static void main(String[] args) {
        String str = "AABABBA";
        System.out.println(characterReplacement(str, 1));
    }
}
