package algorighms.sort;

import java.util.Arrays;

public class Sort {

    public static int[] sortList(int[] list){
        if(list.length <= 1){
            return list;
        }
        int[] left = Arrays.copyOfRange(list, 0, list.length / 2);
        int[] right = Arrays.copyOfRange(list, list.length / 2, list.length);

        int[] sortedLeft = sortList(left);
        int[] sortedRight = sortList(right);

        return mergeList(sortedLeft, sortedRight);
    }

    private static int[] mergeList(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        if(left.length == 0){
            return right;
        }
        if(right.length == 0){
            return left;
        }
        int leftIndex = 0, rightIndex = 0;
        for (int currentResultIndex = 0; currentResultIndex < left.length + right.length; currentResultIndex++) {
            if(leftIndex == left.length){
                result[currentResultIndex] = right[rightIndex++];
                continue;
            }
            if(rightIndex == right.length){
                result[currentResultIndex] = left[leftIndex++];
                continue;
            }
            if(left[leftIndex] > right[rightIndex]){
                result[currentResultIndex] = right[rightIndex++];
            }else{
                result[currentResultIndex] = left[leftIndex++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] list = new int[]{9,1,5,3,7,2,2};
        int[] sortedList = sortList(list);
        for (int i = 0; i < sortedList.length; i++) {
            System.out.println(sortedList[i]);
        }

    }
}
