package spring.challenge.citiesClient.service.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import spring.challenge.citiesClient.repository.model.City;

// Object made to deal with responses from the api. It represents a whole itinerary/route between to cities 
public class Itinerary {

    public enum Order {
        LESS_CITIES, LESS_TIME
    }

    @ApiModelProperty(notes = "Itinerary's kind of order")
    private Order order;
    @ApiModelProperty(notes = "Itinerary's origin city")
    private City origin;
    @ApiModelProperty(notes = "Itinerary's destiny city")
    private City destiny;
    @ApiModelProperty(notes = "Itinerary's total minutes cost origin to destiny")
    private int totalMinutes;
    @ApiModelProperty(notes = "Itinerary's total connections from origin to destiny")
    private int totalConnections;
    @ApiModelProperty(notes = "List of cities you have to go through to get to destiny")
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
