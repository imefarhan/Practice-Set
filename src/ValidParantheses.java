import java.util.Stack;

public class ValidParantheses {

    public static boolean isValid(String s) {
        if (s == null)
            return false;

        Stack<Character> st = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char currentchar = s.charAt(i);
            if(currentchar == '(' || currentchar == '[' || currentchar == '{') {
                st.push(currentchar);
            } else {
                if(st.isEmpty())
                    return false;
                if((st.peek() == '(' && currentchar != ')') ||
                        (st.peek() == '[' && currentchar != ']') ||
                        (st.peek() == '{' && currentchar != '}'))
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[]{}()";
        System.out.println(isValid(s));
    }
}
