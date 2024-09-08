import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeTest {

//        public String encode(List<String> strs) {
//            String combined = String.join("||", strs);
//            int enCodeKey = 20;
//            char [] encodedArray = new char[combined.length()];
//            for (int i = 0; i < combined.length(); i++) {
//                encodedArray[i]= (char) ((combined.toCharArray()[i])+(enCodeKey+i));
//            }
//            return String.valueOf(encodedArray);
//        }
//        public List<String> decode(String str) {
//            char [] combinedArray = str.toCharArray();
//            int enCodeKey = 20;
//            char [] decodedArray = new char[str.length()];
//            for (int i = 0; i < combinedArray.length; i++) {
//                int codepoint= (combinedArray[i])- (enCodeKey+ i);
//                decodedArray[i]=(char)(codepoint);
//            }
//            List<String> opList;
//            opList = Arrays.asList(String.valueOf(decodedArray).split("\\|\\|"));
//            if(opList.isEmpty())
//                return new ArrayList<String>();
//            return opList;
//        }
public String encode(List<String> strs) {
    StringBuilder encodedString = new StringBuilder();
    for (String str : strs) {
        encodedString.append(str.length()).append("#").append(str);
    }
    return encodedString.toString();
}

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }
}
