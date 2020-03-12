public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        if(s == null)
            return false;

        int j = s.length()-1;
        int i = 0;

        //ASCII of Numbers = 48 to 57
        //ASCII of A-Z     = 65 to 90
        //ASCII of a-z     = 97 to 122
        while(i <= j) {
            int currentStartChar = s.charAt(i);
            int currentLastChar = s.charAt(j);
            boolean isStartValid = false;
            boolean isEndValid = false;
            if((currentStartChar >= 48 && currentStartChar <= 57) ||
                    (currentStartChar >= 65 && currentStartChar <= 90) ||
                    (currentStartChar >= 97 && currentStartChar <= 122)) {
                isStartValid = true;
            }
            if((currentLastChar >= 48 && currentLastChar <= 57) ||
                    (currentLastChar >= 65 && currentLastChar <= 90) ||
                    (currentLastChar >= 97 && currentLastChar <= 122)) {
                isEndValid = true;
            }
            if(currentLastChar >= 97 && currentLastChar <= 122) {
                currentLastChar -= 32;
            }
            if(currentStartChar >= 97 && currentStartChar <= 122) {
                currentStartChar -= 32;
            }
            if(isStartValid && isEndValid) {
                if(currentStartChar == currentLastChar) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else {
                if (isStartValid && !isEndValid) {
                    j--;
                }
                if(!isStartValid && isEndValid) {
                    i++;
                }
                if(!isStartValid && !isEndValid) {
                    i++;
                    j--;
                }
            }
        }
        if(j <= i)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

}
