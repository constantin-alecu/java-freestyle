package algorighms.find_in_sorted_array;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{216,221,222,225,228,231,234,244,245,246,249,251,259,262,264,265,268,271,276,277,278,281,282,286,289,294,295,296,298,299,0,4,9,10,13,18,23,25,26,33,34,38,39,42,43,45,48,49,51,52,53,55,58,60,61,62,63,65,66,70,72,74,78,79,82,85,89,90,91,95,104,109,112,113,117,118,120,122,123,126,127,128,133,134,138,140,142,144,147,148,149,152,156,164,165,168,169,174,177,185,191,192,193,194,195,197,204,211,215}, 0));
    }
    private int pos = -1;
    public int search(int[] nums, int target) {

        if(nums.length == 0){
            return -1;
        }

        if(nums.length == 1 && nums[0] == target){
            return 0;
        }
        if(nums.length == 1 && nums[0] != target){
            return -1;
        }

        if(nums.length < 10){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == target){
                    return i;
                }
            }
            return -1;
        }
        search(nums, 0, nums.length-1, target);
        return pos;
    }

    public void search(int[] nums, int start, int end, int target){

        if(start == end && nums[start] != target){
            return;
        }
        if(start == end && nums[start] == target){
            pos = start;
            return;
        }

        int pivot = start + (end - start) / 2;
        if(nums[start] <= target && (target <= nums[pivot] || nums[start] > nums[pivot])){
            search(nums, start, pivot, target);
        }else{
            search(nums, pivot + 1, end, target);
        }
    }
}
