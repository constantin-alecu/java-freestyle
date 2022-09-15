package algorighms.paranthesis;

public class Solution {

    private long number = 0;
    private static long iterations = 0;
    public long    numTrees(int n) {
        generateRecursively(0,0,n);
        return number;
    }

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println();
        System.out.println("open paranthesis: " + new Solution().numTrees(20) + ", " + (System.currentTimeMillis() - now) + " ms");
        now = System.currentTimeMillis();
        ;
        new Solution().getNumberOfUniqueBinarySearchTreesWithRecursion(20);
        System.out.println("BST with recursion: " + iterations + ", " + (System.currentTimeMillis() - now) + " ms");
    }

    private void generateRecursively(int open, int close, int total){
        if(open == total && close == total){
            number++;
            return;
        }
        if(close < open){
            generateRecursively(open, close + 1, total);
        }
        if(open < total){
            generateRecursively(open + 1, close, total);
        }
    }

    public int getNumberOfUniqueBinarySearchTreesWithRecursion(int n) {
        iterations++;
        if (n < 1) return 0;

        if (n == 1) return 1;

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftCount = getNumberOfUniqueBinarySearchTreesWithRecursion(i - 1);
            if (leftCount == 0) leftCount = 1;

            int rightCount = getNumberOfUniqueBinarySearchTreesWithRecursion(n - i);
            if (rightCount == 0) rightCount = 1;

            count += leftCount * rightCount;
        }

        return count;
    }
}
