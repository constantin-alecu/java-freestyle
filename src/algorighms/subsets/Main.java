package algorighms.subsets;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        System.out.println(nonDivisibleSubset(4, List.of(19,10,12,10,24,25,22)));
        formingMagicSquare(List.of(List.of(4,9,2),List.of(3,5,7),List.of(8,1,5)));
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        int[] sums = new int[8];
        //for(int i = 0; i < 7; i++){
        sums[0] = s.get(0).get(0) + s.get(1).get(0) + s.get(2).get(0);
        sums[1] = s.get(0).get(1) + s.get(1).get(1) + s.get(2).get(1);
        sums[2] = s.get(0).get(2) + s.get(1).get(2) + s.get(2).get(2);
        sums[3] = s.get(0).get(0) + s.get(0).get(1) + s.get(0).get(2);
        sums[4] = s.get(1).get(0) + s.get(1).get(1) + s.get(1).get(2);
        sums[5] = s.get(2).get(0) + s.get(2).get(1) + s.get(2).get(2);
        sums[6] = s.get(0).get(0) + s.get(1).get(1) + s.get(2).get(2);
        sums[7] = s.get(2).get(0) + s.get(1).get(1) + s.get(0).get(2);
        //}
        int sum = 0;
        for(int i = 0; i < 8; i++){
            sum += sums[i];
        }
        return sum - sum / 8 * 8;
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        if(s == null || s.isEmpty()){
            throw new RuntimeException("set is empty");
        }
        int[] remainings = new int[k];
        for(int i=0; i<s.size(); i++){
            int y = s.get(i) % k;
            remainings[y]++;
        }
        remainings[0] = remainings[0] > 1 ? 1 : remainings[0];
        if(k % 2 == 0){
            remainings[k/2] = remainings[k/2] > 1 ? 1 : remainings[k/2];
        }
        int max = 0;
        for(int i=1; i<k/2; i++){
            max += Math.max(remainings[i], remainings[k-i]);
        }
        return max;
    }

    public static int formingMagicSquare2(List<List<Integer>> s) {
        // Write your code here
        int[] differences = new int[s.size() * s.size()];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                differences[s.get(i).get(j) - 1]++;
            }
        }
        int cost = 0;
        for(int i = 0; i < 9; i++){
            if(differences[i] > 1){
                int iterations =  differences[i] - 1;
                for(int j = 0; j < iterations; j++){
                    differences[i]--;
                    int k = 1;
                    while(k < differences.length){
                        if(i - k >= 0){
                            if(differences[i-k] == 0){
                                differences[i-k]++;
                                cost += k;
                                break;
                            }
                        }
                        if(i + k < differences.length){
                            if(differences[i + k] == 0){
                                differences[i+k]++;
                                cost += k;
                                break;
                            }
                        }
                        k++;
                    }
                }
            }
        }
        return cost;
    }


}

