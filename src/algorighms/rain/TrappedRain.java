package algorighms.rain;

import java.util.Arrays;

public class TrappedRain {

    public static void main(String[] args) {
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }

    public static int trap(int[] heights) {
        int max = Arrays.stream(heights).max().getAsInt();
        int waterUnits = 0;
        for(int height = 1; height <= max; height++){
            for(int i = 0; i < heights.length - 2; i++){
                if(heights[i] >= height){
                    int possibleWaterUnits = 0;
                    for(int j = i + 1; j < heights.length; j++){
                        if(heights[j] < height){
                            possibleWaterUnits++;
                        }else{
                            waterUnits+=possibleWaterUnits;
                            i = j-1;
                            break;
                        }
                    }
                }
            }
        }
        return waterUnits;
    }
}
