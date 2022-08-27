package algorighms.booking;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        final List<Route> routes = Route.getExampleRoutes();
        final List<Accommodation> accommodations = Accommodation.getExampleAccommodations();
        final SearchCriteria searchCriteria = new SearchCriteria("Amsterdam", LocalDate.of(2022,9,10), 15, 5000);
        yourSolution(searchCriteria, routes, accommodations);
    }

    public static void yourSolution(SearchCriteria searchCriteria, List<Route> routes, List<Accommodation> accommodations) {

        Map<String, Integer> mapping = new HashMap<>();
        int index = 0;
        for (Route current : routes) {
            if (!mapping.containsKey(current.origin)) {
                mapping.put(current.origin, index++);
            }
            if (!mapping.containsKey(current.destination)) {
                mapping.put(current.destination, index++);
            }
        }
        Node[][] adjacencyMatrix = new Node[mapping.size()][mapping.size()];
        for (Route current : routes) {
            adjacencyMatrix[mapping.get(current.origin)][mapping.get(current.origin)] = new Hotel(getHotelPrice(current.origin, accommodations));
            adjacencyMatrix[mapping.get(current.origin)][mapping.get(current.destination)] = new Flight(current.price, current.date);
        }
        int startingCity = mapping.get(searchCriteria.getOrigin());
        findAllPaths(startingCity, adjacencyMatrix);

        for(List<Integer> paths: allSolutions){
            int cost = 0;
            int duration = 0;
            LocalDate currentDate = searchCriteria.getStartDate();
            for (int i = 0; i < paths.size() - 1; i++) {
                int currentCity = paths.get(i);
                int nextCity = paths.get(i+1);
                Flight nextFlight = (Flight) adjacencyMatrix[currentCity][nextCity];
                Hotel currentHotel = (Hotel) adjacencyMatrix[currentCity][currentCity];
                if (i == 0 && !currentDate.equals(nextFlight.flightDate)){
                    break;
                }
                duration += ChronoUnit.DAYS.between(currentDate, nextFlight.flightDate);
                cost += nextFlight.flightPrice + currentHotel.price * ChronoUnit.DAYS.between(currentDate, nextFlight.flightDate);
                currentDate = nextFlight.flightDate;

            }
            System.out.println();
            if(cost <= searchCriteria.budget() && duration <= searchCriteria.maxDays){
                //we are good
                paths.forEach(System.out::println);
            }
        }

    }
    private static List<List<Integer>> allSolutions = new ArrayList<>();

    public static void findAllPaths(int s, Node[][] adjacencyMatrix) {
        boolean[] isVisited = new boolean[adjacencyMatrix.length];
        Stack<Integer> pathList = new Stack<>();

        pathList.push(s);

        findAllPathsUtil(true, s, s, isVisited, pathList, adjacencyMatrix);
    }
    private static void findAllPathsUtil(boolean isFirstCall, int u, int v, boolean[] visited, Stack<Integer> localPathList, Node[][] adjacencyMatrix){
        if(u==v && !isFirstCall){
            allSolutions.add(new ArrayList<>(localPathList));
            return;
        }
        visited[u] = true;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if(adjacencyMatrix[u][i] instanceof Flight){
                if(i == v || !visited[i]){
                    localPathList.push(i);
                    findAllPathsUtil(false, i, v, visited, localPathList, adjacencyMatrix);
                    localPathList.pop();
                }
            }
        }
        visited[u] = false;
    }

    private static int getHotelPrice(String destination, List<Accommodation> accommodations) {
        for(Accommodation accommodation: accommodations){
            if(destination.equals(accommodation.getLocation())){
                return accommodation.pricePerNight;
            }
        }
        throw new RuntimeException("accommodation not found!");
    }

    static interface Node{}
    static class Hotel implements Node{
        private int price;

        public Hotel(int price) {
            this.price = price;
        }
    }
    static class Flight implements Node {
        private int flightPrice;
        private LocalDate flightDate;

        public Flight(int flightPrice, LocalDate flightDate) {
            this.flightPrice = flightPrice;
            this.flightDate = flightDate;
        }
    }

    static class SearchCriteria {
        private String origin;
        private LocalDate startDate;
        private int maxDays;
        private int budget;

        public SearchCriteria(String origin, LocalDate startDate, int maxDays, int budget) {
            this.origin = origin;
            this.startDate = startDate;
            this.maxDays = maxDays;
            this.budget = budget;
        }

        public String getOrigin() {
            return origin;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public int getMaxDays() {
            return maxDays;
        }

        public int budget() {
            return budget;
        }
    }

    static class Accommodation {
        private String location;
        private int pricePerNight;

        public Accommodation(String location, int pricePerNight) {
            this.location = location;
            this.pricePerNight = pricePerNight;
        }

        public static List<Accommodation> getExampleAccommodations() {
            List<Accommodation> accommodations = new ArrayList<>();
            accommodations.add(new Accommodation("Amsterdam", 350));
            accommodations.add(new Accommodation("Paris", 300));
            accommodations.add(new Accommodation("London", 500));
            accommodations.add(new Accommodation("Lisbon", 200));
            return accommodations;
        }

        public String getLocation() {
            return location;
        }

        public int getPricePerNight() {
            return pricePerNight;
        }
    }

    static class Route {
        private String origin;
        private String destination;
        private LocalDate date;
        private int price;

        public Route(String origin, String destination, LocalDate date, int price) {
            this.origin = origin;
            this.destination = destination;
            this.date = date;
            this.price = price;
        }

        static List<Route> getExampleRoutes() {
            List<Route> routes = new ArrayList<>();
            routes.add(new Route("Amsterdam", "Paris", LocalDate.of(2022,9,10), 150));
            routes.add(new Route("Paris", "London", LocalDate.of(2022,9,15), 200));
            routes.add(new Route("Paris", "Lisbon", LocalDate.of(2022,9,14), 40));
            routes.add(new Route("Lisbon", "Amsterdam", LocalDate.of(2022,9,20), 100));
            routes.add(new Route("Lisbon", "London", LocalDate.of(2022,9,17), 100));
            routes.add(new Route("London", "Amsterdam", LocalDate.of(2022, 9, 21), 150));
            return routes;
        }

        public String getOrigin() {
            return origin;
        }

        public String getDestination() {
            return destination;
        }

        public LocalDate getDate() {
            return date;
        }

        public int getPrice() {
            return price;
        }
    }
}
