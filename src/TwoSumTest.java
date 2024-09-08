import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TwoSumTest {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        List<Integer> resultList = new ArrayList<Integer>();
        int [] result = new int[nums.length*2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int reminder = target - num;
            if(map.get(reminder)!=null){
                resultList.add(i);
                resultList.add(map.get(reminder));
            }
            map.put(num,i);
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();

    }
}
