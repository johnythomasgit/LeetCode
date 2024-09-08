import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramListTest {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> stringMap = new HashMap<String,List<String>>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            if(stringMap.get(Arrays.toString(charArray))!=null){
                stringMap.get(Arrays.toString(charArray)).add(str);
            }else {
                List<String> stringList = new ArrayList<String>();
                stringList.add(str);
                stringMap.put(Arrays.toString(charArray),stringList);
            }
        }
        return new ArrayList<>(stringMap.values());
    }
}
