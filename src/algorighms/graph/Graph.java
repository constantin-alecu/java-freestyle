package algorighms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    public static void main(String[] args) {
        Node bucuresti = createMap();
        shortestDistanceToCity(bucuresti, "constanta");
    }

    static Map<String, Integer> distances = new HashMap<>();
    private static void shortestDistanceToCity(Node start, String city){

        distances.put(start.name, 0);
        for (int i = 0; i < start.neighbours.size(); i++) {
            if(distances.get(city) == null || distances.get(city) > start.distances.get(i)) {
                distances.put(start.neighbours.get(i).name, start.distances.get(i));
            }
            computeNeighbours(start.neighbours.get(i));
        }
        System.out.println("Distance from " + start.name + " to " + city + " = " + distances.get(city));
    }

    private static void computeNeighbours(Node node) {
        for (int i = 0; i < node.neighbours.size(); i++) {
            int currentDistance = distances.get(node.name);
            int existingDistance = distances.get(node.neighbours.get(i).name) == null ? Integer.MAX_VALUE : distances.get(node.neighbours.get(i).name);
            if( currentDistance + node.distances.get(i) < existingDistance){
                distances.put(node.neighbours.get(i).name, currentDistance + node.distances.get(i));
            }
            computeNeighbours(node.neighbours.get(i));
        }
    }

    private static Node createMap(){
        Node bucuresti = new Node("bucuresti");

        Node ploiesti = new Node("ploiesti");

        Node giurgiu = new Node("giurgiu");

        Node brasov = new Node("brasov");

        Node sibiu = new Node("sibiu");

        Node cluj = new Node("cluj");

        Node oradea = new Node("oradea");

        Node arad = new Node("arad");

        Node timisoara = new Node("timisoara");

        Node pitesti = new Node("pitesti");

        Node craiova = new Node("craiova");

        Node calarasi = new Node("calarasi");

        Node constanta = new Node("constanta");

        bucuresti.neighbours.add(ploiesti);
        bucuresti.distances.add(80);
        bucuresti.neighbours.add(giurgiu);
        bucuresti.distances.add(60);
        bucuresti.neighbours.add(pitesti);
        bucuresti.distances.add(120);
        bucuresti.neighbours.add(calarasi);
        bucuresti.distances.add(90);
        bucuresti.neighbours.add(constanta);
        bucuresti.distances.add(210);

        calarasi.neighbours.add(constanta);
        calarasi.distances.add(130);

        pitesti.neighbours.add(sibiu);
        pitesti.distances.add(140);

        pitesti.neighbours.add(craiova);
        pitesti.distances.add(100);

        craiova.neighbours.add(timisoara);
        craiova.distances.add(250);

        ploiesti.neighbours.add(brasov);
        ploiesti.distances.add(50);

        brasov.neighbours.add(sibiu);
        brasov.distances.add(90);

        sibiu.neighbours.add(cluj);
        sibiu.distances.add(120);
        sibiu.neighbours.add(arad);
        sibiu.distances.add(200);

        cluj.neighbours.add(oradea);
        cluj.distances.add(70);

        oradea.neighbours.add(arad);
        oradea.distances.add(80);

        arad.neighbours.add(timisoara);
        arad.distances.add(40);

        return bucuresti;
    }
}

class Node{

    public Node(String name){
        this.name = name;
    }
    String name;
    List<Node> neighbours = new ArrayList<>();
    List<Integer> distances = new ArrayList<>();

    @Override
    public String toString(){
        return this.name;
    }
}
