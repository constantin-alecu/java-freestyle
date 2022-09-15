package algorighms.rotate_picture;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(matrix);
    }

    public double myPow(double x, int n) {
        if(n >= 0){
            return myPowPositive(x,n);
        }else{
            return 1/myPowPositive(x,-n);
        }

    }

    public double myPowPositive(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        double result = x;
        for(int i = 0; i<n-1; i++){
            result *= x;
        }
        return result;
    }

    public void rotate(int[][] matrix) {
        //col -> row
        //row -> col (length - row)
        int[][] result = new int[matrix.length][matrix.length];
        System.out.println(matrix[0].length);
        System.out.println(matrix.length);

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix.length; col++){
                result[col][matrix.length-row-1] = matrix[row][col];
            }
        }
        matrix = result;
    }
}
