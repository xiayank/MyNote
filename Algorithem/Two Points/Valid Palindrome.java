Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.


public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !isvalid(s.charAt(front))){ // nead to check range of a/b
                front++;
            }

            while (start < end && ! isvalid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                start++;
                end--;
            }
        }

        return end <= start;
    }

    private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
