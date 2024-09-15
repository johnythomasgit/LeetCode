import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, List<List<Integer>>> twoSumMap = new HashMap<>();
        List<List<Integer>> returnList =  new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int twoSum = nums[i] + nums[j];
                List twoSumList = new ArrayList(List.of(i, j));
                List<List<Integer>> mapList = twoSumMap.getOrDefault(twoSum, new ArrayList<>());
                mapList.add(twoSumList);
                twoSumMap.put(twoSum, mapList);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int reminder = 0 - (nums[i]);
            if(twoSumMap.get(reminder)!=null){
                List<List<Integer>> list = twoSumMap.get(reminder);
                if(list!=null){
                    int finalI = i;
                    for (List<Integer> x : list) {
                        if(x.get(0)==finalI||x.get(1)==finalI)
                            continue;
                        List<Integer> intList = new ArrayList<>(List.of(nums[x.get(0)], nums[x.get(1)], nums[finalI]));
                        returnList.add(intList);
                    }

                }
            }
        }
        Set<List<Integer>> uniqueSet = new HashSet<>();
        for (List<Integer> intList : returnList) {
            Collections.sort(intList);
            uniqueSet.add(intList);
        }

        returnList = new ArrayList<>(uniqueSet);;

        return returnList;
    }


}
