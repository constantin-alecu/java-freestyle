package algorighms.permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static List<String> permutations = new ArrayList<>();

    public static void main(String[] args) {
        findAllPermutations("12345","");
        permutations.forEach(System.out::println);
//        System.out.println("permutations = " + permutations.size());
//
//        System.out.println(longestPalindrome("abcda"));


    }
    public static String sortString(String s){
        int[] array = new int[26];
        for(int i = 0; i < s.length(); i++){
            array[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i]; j++){
                sb.append((char)('a' + i));
            }
        }
        return sb.toString();
    }

    private static void findAllPermutations(String s, String ans) {
        if(s.isBlank()){
            permutations.add(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            String rest = s.substring(0,i) + s.substring(i+1);
            findAllPermutations(rest, ans + current);
        }
    }

    public static String longestPalindrome(String s) {
        // 12344365351111
        // 3443
        // 535
        if(s.isEmpty() || s.length() == 1){
            return s;
        }
        char[] letters = s.toCharArray();
        if(s.length() == 2){
            if(letters[0] == letters[1]){
                return s;
            }else{
                return letters[0] + "";
            }
        }
        int[] middlePosPalindrome = new int[letters.length];
        middlePosPalindrome[0] = 1;
        middlePosPalindrome[middlePosPalindrome.length -1] = 1;
        for(int i = 0; i < letters.length - 1; i++){
            int evenPathCharacters = 0;
            int oddPathCharacters = 1;
            boolean shouldContinueOnEven = true;
            boolean shouldContinueOnOdd = true;
            for(int j = 1; j <= letters.length / 2; j++){
                if(shouldContinueOnOdd && i-j >=0 && i+j < letters.length && letters[i-j] == letters[i+j]){
                    oddPathCharacters+=2;
                }else{
                    shouldContinueOnOdd = false;
                }
                if(shouldContinueOnEven && i-j+1 >=0 && i+j < letters.length && letters[i-j+1] == letters[i+j]){
                    evenPathCharacters+=2;
                }else{
                    shouldContinueOnEven = false;
                }
                if(!shouldContinueOnEven && !shouldContinueOnOdd){
                    break;
                }
            }
            if(evenPathCharacters > oddPathCharacters){
                middlePosPalindrome[i] = evenPathCharacters;
            }else{
                middlePosPalindrome[i] = -oddPathCharacters;
            }
        }
        int maxPos = 0;
        int max = 0;
        for(int i = 0; i < letters.length; i++){
            if(Math.abs(middlePosPalindrome[i]) > max){
                if(middlePosPalindrome[i] >=0){
                    maxPos = i;
                }else{
                    maxPos = -i;
                }
                max = Math.abs(middlePosPalindrome[i]);
            }
        }
        if(maxPos >= 0){
            if(max == 1){
                return s.substring(maxPos, maxPos+ 1);
            }
            return s.substring(maxPos-max/2 + 1, maxPos + max/2 + 1);
        }else{
            if(max == 1){
                return s.substring(-maxPos, -maxPos+ 1);
            }
            return s.substring(-maxPos-max/2, -maxPos + max/2 + 1);
        }

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //[0,1][1,2][2,0]
        //0->1->2->0
        int[][] adjancencyMatrix = new int[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            adjancencyMatrix[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        boolean[] visited = new boolean[adjancencyMatrix.length];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < adjancencyMatrix.length; i++){
            canFinishHelper(adjancencyMatrix, i, i, true, visited, sb);
            if(sb.length() > 0){
                return false;
            }
            visited = new boolean[adjancencyMatrix.length];
        }
        return true;
    }

    private void canFinishHelper(int[][] adjancencyMatrix, int u, int v, boolean isFirst, boolean[] visited, StringBuilder sb){
        if(!isFirst && u == v){
            sb.append("1");
            return;
        }
        isFirst = false;
        visited[u] = true;
        for(int i = 0; i < adjancencyMatrix.length; i++){
            if(adjancencyMatrix[u][i] == 1 && !visited[v]){
                canFinishHelper(adjancencyMatrix,i,v,isFirst ,visited, sb);
            }
        }
        visited[u] = false;
    }
}
