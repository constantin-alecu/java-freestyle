package algorighms.find_first_positive;

public class Solution {

    public static void main(String[] args) {
        firstMissingPositive(new int[]{3,4,-1,1});
    }
    public static int firstMissingPositive(int[] nums) {

        int idx = 0;
        while(idx < nums.length){
            int correspondingPosition = nums[idx] - 1;
            if(isInRange(nums, idx, 0, nums.length) && canBeSwappedToCorrespondingPosition(nums, idx, correspondingPosition))
                swap(nums, idx, correspondingPosition);
            else
                idx++;
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j + 1) return j+1;
        }
        return nums.length + 1;
    }

    private static boolean canBeSwappedToCorrespondingPosition(int[] nums, int idx, int correct) {
        return nums[idx] != nums[correct];
    }

    private static boolean isInRange(int[] nums, int i, int start, int end) {
        return nums[i] > start && nums[i] < end;
    }

    static void swap(int arr[], int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
