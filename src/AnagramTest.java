import java.util.HashMap;
import java.util.LinkedHashMap;

public class AnagramTest {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> charMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charMap.put(c,(charMap.get(c)!=null?charMap.get(c):0)+1);
        }
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if(charMap.get(c)==null|| charMap.get(c)==0){
                return false;
            }else {
                charMap.put(c,charMap.get(c)-1);
            }
        }
        return charMap.values().stream().noneMatch(value -> value != 0);
    }
}
