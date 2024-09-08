import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopFrequentTest {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, List<Integer>> numMap =new HashMap<>();
        for (Integer num : nums) {
            numMap.computeIfAbsent(num, k1 -> new ArrayList<Integer>());
            numMap.get(num).add(num);
        }
        return numMap.values().stream().sorted((a,b)-> (b.size()-a.size())).map(x->x.get(0)).limit(k).mapToInt(Integer::intValue).toArray();
    }

}
