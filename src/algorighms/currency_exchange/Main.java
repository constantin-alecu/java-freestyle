package algorighms.currency_exchange;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Rate> rateList = List.of(
                new Rate("USD", "EUR", 0.96),
                new Rate("EUR", "PLN", 3.9),
                new Rate("USD", "PLN", 4.16),
                new Rate("EUR", "LEI", 4.88),
                new Rate("LEI", "AUD", 0.33),
                new Rate("AUD", "EUR", 0.67),
                new Rate("USD", "ZMB", 123.0),
                new Rate("USD", "TRY", 16.7),
                new Rate("USD", "HUF", 432.4),
                new Rate("B", "C", 0.5),
                new Rate("C", "D", 0.5),
                new Rate("D", "B", 0.5),
                new Rate("A", "B", 0.5)
        );
        Map<String, Integer> mapping = new HashMap<>();
        int index = 0;
        for (Rate current : rateList) {
            if (!mapping.containsKey(current.from)) {
                mapping.put(current.from, index++);
            }
            if (!mapping.containsKey(current.to)) {
                mapping.put(current.to, index++);
            }
        }
        double[][] adjacencyMatrix = new double[mapping.size()][mapping.size()];
        for (Rate current : rateList) {
            adjacencyMatrix[mapping.get(current.from)][mapping.get(current.to)] = current.rate;
//            adjacencyMatrix[mapping.get(current.to)][mapping.get(current.from)] = 1/current.rate;
        }
        double[] bestRates = getRates(mapping.get("A"), adjacencyMatrix);
        for (int i = 0; i < bestRates.length; i++) {
            System.out.println("USD");
        }
    }

    private static double[] getRates(int from, double[][] matrix) {
        double bestRates[] = new double[matrix.length];
        boolean visited[] = new boolean[matrix.length];

        for (int i = 0; i < bestRates.length; i++) {
             bestRates[i] = Double.MAX_VALUE;
        }
        bestRates[from] = 1.0;
        for (int count = 0; count < matrix.length - 1; count++){
            int u = minDistance(bestRates, visited);
            visited[u] = true;

            for (int v = 0; v < matrix.length; v++) {
                if(isDirectRoute(matrix, u, v)
                    && !visited[v]
                    && hasAnAssignedCost(bestRates, u)
                    && isItMoreEfficientPath(matrix, bestRates, u, v)){
                    bestRates[v] = bestRates[u] * matrix[u][v];
                }
            }
        }
        return bestRates;
    }

    public static boolean isItMoreEfficientPath(double[][] matrix, double[] bestRates,int intermediary, int to){
        return bestRates[intermediary] * matrix[intermediary][to] < bestRates[to];
    }

    public static boolean isDirectRoute(double[][] matrix, int from, int to){
        return matrix[from][to] > 0;
    }

    public static boolean hasAnAssignedCost(double[] bestRates, int to){
        return bestRates[to] < Double.MAX_VALUE;
    }

    static int minDistance(double dist[], boolean sptSet[])
    {
        // Initialize min value
        int min_index = -1;
        double min = Double.MAX_VALUE;

        for (int v = 0; v < dist.length; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }
}

class Rate {
    String from;
    String to;
    double rate;

    public Rate(String from, String to, double rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
    }
}
