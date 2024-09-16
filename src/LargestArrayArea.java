import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestArrayArea {
    public static void main(String[] args) {
        LargestArrayArea largestArrayArea = new LargestArrayArea();
        System.out.println(largestArrayArea.maxArea(new int[]{1,8,1,1,8,7,2,1}));
    }

    public int maxArea(int[] heights) {
        int max = 0;
        int l =0;
        int r = heights.length-1;
        while (l<r){
            System.out.println("l->"+l+", h[l]->"+heights[l]+", r->"+r+", h[r]->"+heights[r]);
            printGraph(heights,l,r);
            int area = (r-l)* Math.min(heights[l],heights[r]);
            max = Math.max(area,max);
            if(heights[l]<heights[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }

    public void printGraph(int[] heights, int l, int r){
        int length = heights.length;
        int maxHeight = Arrays.stream(heights).max().getAsInt();
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < heights.length; j++) {
                if(i>=(maxHeight-heights[j])){
                    System.out.print("***");
                    System.out.print("\t");

                }else {
                    System.out.print("    ");
                    System.out.print("\t");
                }
            }
            System.out.println("\n");
        }
    }

//    public int maxArea(int[] heights) {
//        int max = 0;
//        List<Integer> areaList = new ArrayList<>();
//        for (int i = 0; i < heights.length; i++) {
//
//            for (int j = 0; j < heights.length; j++) {
//                int width = j-i;
//                int height = Math.min(heights[i],heights[j]);
//                int area = width* height;
//                if(max<area)
//                    max = area;
//            }
//        }
//        return max;
//    }
}
