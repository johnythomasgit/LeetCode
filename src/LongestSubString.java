import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static void main(String [] args){
        LongestSubString longestSubString = new LongestSubString();
        System.out.println("longestSubString.lengthOfLongestSubstring(\"xxxx\")=====>"+longestSubString.lengthOfLongestSubstring("xxxx"));

    }

    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        char [] charArray = s.toCharArray();
        Map<Character,Character> charMap = new HashMap<>();
        int maxLength = 0;
        while (r<charArray.length && l<charArray.length){
            if(charMap.get(charArray[r])==null){
                char currentRightChar = charArray[r];
                charMap.put(currentRightChar, currentRightChar);
                maxLength= Math.max(maxLength,(r-l)+1);
                r++;
            }else {
                char currentLeftChar = charArray[l];
                charMap.put(currentLeftChar,null);
                l++;
            }
        }
        return maxLength;
    }

}
