import java.util.*;

public class LongestSingleCharacterSubstring {
    public static  void main(String[] args){
    LongestSingleCharacterSubstring longSub = new LongestSingleCharacterSubstring();
        System.out.println("---->"+longSub.characterReplacement("AAXBCBXBAA",3));
    }

//    public int characterReplacement(String s, int k) {
//        int maxLength=0;
//        char [] charArray= s.toCharArray();
//        HashMap<Character, List<Integer>> charMap = new HashMap<>();
//        for (int i = 0; i <charArray.length; i++) {
//            char currentChar = charArray[i];
//            List<Integer> charPositonList = charMap.getOrDefault(currentChar,new ArrayList());
//            charPositonList.add(i);
//            charMap.put(currentChar,charPositonList);
//        }
//        for (Map.Entry<Character, List<Integer>> entry : charMap.entrySet()) {
//            Character key = entry.getKey();
//            List<Integer> list = entry.getValue();
//            for (int i = 0; i < s.length(); i++) {
//                int borrow = k;
//                boolean continuityCheck=true;
//                int reverseIndex=i;
//                int localMax=0;
//                while (reverseIndex>=0 && continuityCheck==true){
//                    if(list.contains(reverseIndex)||borrow>0){
//                        if(list.contains(reverseIndex)){
//                            localMax++;
//                        }else {
//                            localMax++;
//                            borrow--;
//                        }
//                    }else {
//                        continuityCheck=false;
//                    }
//                    reverseIndex--;
//                }
//                maxLength = Math.max(maxLength,localMax);
//            }
//        }
//        maxLength = Math.min(maxLength,s.length());
//        return maxLength;
//    }

    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];

        int ans = 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);

            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
