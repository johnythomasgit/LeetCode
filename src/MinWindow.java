import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinWindow {

    public  static void main(String[] args){
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("OUZODYXAZV","XYZ"));
    }

    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int l=0;
        int r=s.length()-1;
        HashMap<Character,Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
        }
        if(!checkContains(tMap,sMap)){
            return "";
        }
        while (l<=r){
            if(
                tMap.get(s.charAt(l))==null
                ||
                ((sMap.get(s.charAt(l))-1)>=tMap.get(s.charAt(l)))
            ){
                sMap.put(s.charAt(l),sMap.get(s.charAt(l))-1);
                l++;
                continue;
            }
            if(
                tMap.get(s.charAt(r))==null
                ||
                ((sMap.get(s.charAt(r))-1)>=tMap.get(s.charAt(r)))
            ){
                sMap.put(s.charAt(r),sMap.get(s.charAt(r))-1);
                r--;
                continue;
            }
            return s.substring(l,r+1);
        }
        return s;
    }

    private boolean checkContains(HashMap<Character, Integer> tMap,HashMap<Character, Integer> sMap) {

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (sMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

}
