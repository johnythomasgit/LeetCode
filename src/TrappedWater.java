import java.util.Arrays;
import java.util.MissingFormatArgumentException;

public class TrappedWater {

    public static void main(String[] args) {
        TrappedWater trappedWater = new TrappedWater();
        System.out.println(trappedWater.trap(new int[]{0,2,0,3,1,0,1,3,2,1}));
    }

    public int trap(int[] height) {
        int areaCount=0;
        int l=0;
        int r=height.length-1;
        int lMax = height[0];
        int rMax = height[height.length-1];
        while (l<r){

            if(lMax<rMax){
                l++;
                lMax=Math.max(lMax,height[l]);
                areaCount+= (Math.max((Math.min(lMax, rMax) - height[l]), 0));
            }else {
                r--;
                rMax = Math.max(rMax,height[r]);
                areaCount+= (Math.max((Math.min(lMax, rMax) - height[r]), 0));
            }
        }

        return  areaCount;
    }
//    public int trap(int[] height) {
//        int areaCount=0;
//        int maxHeight = Arrays.stream(height).max().getAsInt();
//        for (int i = 0; i < maxHeight; i++) {
//            int start=-1;
//            int end =-1;
//            for (int j = 0; j < height.length; j++) {
//                if(i>=(maxHeight-height[j])){
//                    if(start==-1){
//                        start =j;
//                    }else {
//                        end=j;
//                    }
//                    if(start!=-1&&end!=-1){
//                        areaCount+=end-start-1;
//                        start=end;
//                        end =-1;
//                    }
//                }
//            }
//        }
//        return  areaCount;
//    }
}
