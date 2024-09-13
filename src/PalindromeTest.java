import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromeTest {
    public static void main(String[] args) {
        PalindromeTest palindromeTest = new PalindromeTest();
        System.out.println(palindromeTest.isPalindrome("ab"));

    }

    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        List < Character > charList = getCharacterList(s);
        StringBuilder sb = new StringBuilder();
        charList.forEach(sb::append);
        s = sb.toString();
        for (int i = 0, j = s.length() - 1;
             (i <= j); i++, j--) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static List < Character > getCharacterList(String s) {
        List < Character > charList = new ArrayList < > ();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(
                    ('a' <= c && c <= 'z') ||
                            ('A' <= c && c <= 'Z') ||
                            ('0' <= c && c <= '9')
            )) {
                continue;
            }
            if (('A' <= c) && (c <= 'Z')) {
                char c2 = (char)('a' + (c - 'A'));
                charList.add(c2);
            } else {
                charList.add(c);
            }
        }
        return charList;
    }

}