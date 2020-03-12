import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if (strs == null)
            return res;

        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for(String str : strs) {
            char[] currentStr = str.toCharArray();
            Arrays.sort(currentStr);
            String ss = new String(currentStr);

            if(!hm.containsKey(ss)) {
                hm.put(ss, new ArrayList<>());
            }
            hm.get(ss).add(str);
        }
        res.addAll(hm.values());

        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //ate, eat, tea
        //nat, tan
        //bat
        System.out.println(groupAnagrams(strs));
    }
}
