package algorighms.unique_paths_in_matrix;

public class Solution {

    public static void main(String[] args) {
        var sol = new Solution();
        sol.uniquePaths(4, 3);
        System.out.println(sol.iterations);
    }

    int sol = 0;
    int iterations = 0;
    public int uniquePaths(int m, int n) {
        uniquePathsHelper(m-1,n-1);
        return sol;
    }
    // O(Sum(n))
//    Sum(n,m) = Sum(n-1,m) + Sum(n,m-1);
    public void uniquePathsHelper(int m, int n) {
        iterations++;
        if(m == 0 && n == 0){
            sol++;
            System.out.println();
            return;
        }
        System.out.print("["+m+","+n+"]");
        if(m>0)
            uniquePathsHelper(m-1,n);
        if(n>0)
            uniquePathsHelper(m,n-1);
    }
}
