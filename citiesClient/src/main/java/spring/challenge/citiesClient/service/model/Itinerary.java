package spring.challenge.citiesClient.service.model;

import java.util.List;

import spring.challenge.citiesClient.repository.model.City;

// Object made to deal with responses from the api. It represents a whole itinerary/route between to cities 
public class Itinerary {

    public enum Order {
        LESS_CITIES, LESS_TIME
    }

    private Order order;
    private City origin;
    private City destiny;
    private int totalMinutes;
    private int totalConnections;
    private List<City> route;

    public Itinerary(Order order, City origin, City destiny, int totalMinutes, int totalConnections, List<City> route) {
        this.order = order;
        this.origin = origin;
        this.destiny = destiny;
        this.totalMinutes = totalMinutes;
        this.totalConnections = totalConnections;
        this.route = route;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestiny() {
        return destiny;
    }

    public void setDestiny(City destiny) {
        this.destiny = destiny;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(int totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public int getTotalConnections() {
        return totalConnections;
    }

    public void setTotalConnections(int totalConnections) {
        this.totalConnections = totalConnections;
    }

    public List<City> getRoute() {
        return route;
    }

    public void setRoute(List<City> route) {
        this.route = route;
    }
}
