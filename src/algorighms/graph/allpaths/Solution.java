package algorighms.graph.allpaths;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}});
        list.forEach(System.out::println);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        List<List<Integer>> list = new ArrayList<>();
        findPaths(graph, 0, graph.length-1, visited, new ArrayList<>(List.of(0)), list);
        return list;
    }

    private void findPaths(int[][] graph, int u, int v, boolean[] visited, List<Integer> path, List<List<Integer>> list){
        if(u == v){
            list.add(new ArrayList<>(path));
            return;
        }
        visited[u] = true;
        for(int i: graph[u]){
            if(!visited[i]){
                path.add(i);
                findPaths(graph, i, v, visited, path, list);
                path.remove(path.size()-1);
            }
        }
        visited[u] = false;
    }
}
