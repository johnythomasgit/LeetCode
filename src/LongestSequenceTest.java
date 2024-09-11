import java.util.*;

public class LongestSequenceTest {
    public static void main(String[]args){
        System.out.println("Longest sequence => "+ (new LongestSequenceTest().longestConsecutive(new int[]{5,1,3,4,7,8,9,2,0})));
    }
    class MetaData{
        Set<Integer> ownSet;
        List<MetaData> linkedList;
        MetaData(){
            ownSet = new HashSet<>();
            linkedList = new ArrayList<>();
        }
    }
    public int longestConsecutive(int[] nums) {

        HashMap<Integer, MetaData> map = new HashMap<>();
        int longest =0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], new MetaData());
        }
        for (int i = 0; i < nums.length; i++) {
            int num  = nums[i];
            if(map.get(num-1)!=null){
                MetaData ownMetaData = map.get(num);
                MetaData linkedMetaData = map.get(num-1);
                linkedMetaData.ownSet.add(num);
                linkedMetaData.linkedList.add(ownMetaData);
            }
        }



        for (MetaData data: map.values()) {
            int linkedLength = getLinkedLength(data);
            longest = (Math.max(linkedLength, longest));
        }


        return longest;
    }

    private int getLinkedLength(MetaData data) {
        int depth=0;

        MetaData varData =data;
        while (varData.linkedList.size()>0){
            depth++;
            varData=varData.linkedList.get(0);
        }
        return depth+1;
    }

//    public int longestConsecutive(int[] nums) {
//        Set<Integer> numSet = new HashSet<>();
//        for (int num : nums) {
//            numSet.add(num);
//        }
//
//        int longest = 0;
//
//        for (int n : numSet) {
//            if (!numSet.contains(n - 1)) {
//                int length = 1;
//                while (numSet.contains(n + length)) {
//                    length++;
//                }
//                longest = Math.max(length, longest);
//            }
//        }
//        return longest;
//    }

}
