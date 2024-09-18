import java.util.Arrays;

public class PermutationSubstring {
    public static void main(String[] args){
        PermutationSubstring permutationSubstring = new PermutationSubstring();
        System.out.println("output--> "+ permutationSubstring.checkInclusion("abc","cedbfchlm"));
    }
    public boolean checkInclusion(String s1, String s2) {
     int [] s1Freq = new int[26];
     int [] s2Freq = new int[26];
        for (int i = 0; i <s1.length(); i++) {
            s1Freq[s1.charAt(i)-'a']++;
        }
        int l=0;
        int r=-0;
        for (int j = 0; j < s2.length(); j++) {
            s2Freq[s2.charAt(r)-'a']++;
            if(j>=(s1.length()-1)){
                if(Arrays.equals(s1Freq,s2Freq)){
                    return true;
                }
                s2Freq[s2.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        return false;
    }
}
