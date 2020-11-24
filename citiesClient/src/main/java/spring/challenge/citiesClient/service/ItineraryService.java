package spring.challenge.citiesClient.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.stereotype.Service;

import spring.challenge.citiesClient.exceptions.CityNotFoundException;
import spring.challenge.citiesClient.repository.ItineraryRepository;
import spring.challenge.citiesClient.repository.model.City;
import spring.challenge.citiesClient.service.model.Itinerary;
import spring.challenge.citiesClient.service.model.Itinerary.Order;
import spring.challenge.citiesClient.service.model.ItineraryConnsNode;
import spring.challenge.citiesClient.service.model.ItineraryTimeNode;

@Service
public class ItineraryService {

    private List<City> mCities;

    public List<Itinerary> getAllItineraries() {
        return null;
    }

    public List<Itinerary> getItinerariesByOrigId(Long id) {
        if (mCities == null) {
            mCities = new ArrayList<City>(ItineraryRepository.getAllCities());
        }

        City origin = mCities.stream().filter(city -> city.getId() == id).findAny()
                .orElseThrow(() -> new CityNotFoundException(id));

        List<Itinerary> itineraries = new ArrayList<Itinerary>();
        mCities.forEach(dest -> {
            if (!dest.equals(origin)) {
                itineraries.add(calcShorterConnectionsItinerary(origin, dest));
                itineraries.add(calcShorterTimeItinerary(origin, dest));
            }
        });

        return itineraries;
    }

    private Itinerary calcShorterConnectionsItinerary(City origin, City destiny) {
        Itinerary itinerary = new Itinerary(Order.LESS_CITIES, origin, destiny, 0, 0, null);

        Queue<ItineraryConnsNode> openSet = new PriorityQueue<>(); // Explorable nodes
        Map<City, ItineraryConnsNode> allNodes = new HashMap<>();

        ItineraryConnsNode start = new ItineraryConnsNode(origin, null, 0, origin.calcEstimatedConns(destiny), 0);
        openSet.add(start);
        allNodes.put(origin, start);

        while (!openSet.isEmpty()) {
            ItineraryConnsNode next = openSet.poll();
            if (next.getCurrent().equals(destiny)) {
                List<City> route = new ArrayList<>();
                ItineraryConnsNode current = next;
                itinerary.setTotalConnections(current.getConnsScore());
                itinerary.setTotalMinutes(current.getMinutes());
                do {
                    route.add(0, current.getCurrent());
                    current = allNodes.get(current.getPrevious());
                } while (current != null);
                itinerary.setRoute(route);
                return itinerary;
            }

            ItineraryRepository.getConnsByOrigId(next.getCurrent().getId()).forEach(connection -> {
                City city = connection.getDest();
                ItineraryConnsNode nextNode = allNodes.getOrDefault(city, new ItineraryConnsNode(city));
                allNodes.put(city, nextNode);

                int newScore = next.getConnsScore() + 1;
                if (newScore < nextNode.getConnsScore()) {
                    nextNode.setPrevious(next.getCurrent());
                    nextNode.setConnsScore(newScore);
                    nextNode.setEstimatedConnsScore(newScore + city.calcEstimatedConns(destiny));
                    nextNode.setMinutes(next.getMinutes() + (int) connection.getDuration().toMinutes());
                    openSet.add(nextNode);
                }
            });
        }

        throw new IllegalStateException("No route found");
    }

    private Itinerary calcShorterTimeItinerary(City origin, City destiny) {
        Itinerary itinerary = new Itinerary(Order.LESS_TIME, origin, destiny, 0, 0, null);

        Queue<ItineraryTimeNode> openSet = new PriorityQueue<>(); // Explorable nodes
        Map<City, ItineraryTimeNode> allNodes = new HashMap<>();

        ItineraryTimeNode start = new ItineraryTimeNode(origin, null, 0, origin.calcEstimatedTime(destiny), 0);
        openSet.add(start);
        allNodes.put(origin, start);
        openSet.stream();

        while (!openSet.isEmpty()) {
            ItineraryTimeNode next = openSet.poll();
            if (next.getCurrent().equals(destiny)) {
                List<City> route = new ArrayList<>();
                ItineraryTimeNode current = next;
                itinerary.setTotalMinutes(current.getTimeScore());
                itinerary.setTotalConnections(current.getConns());
                do {
                    route.add(0, current.getCurrent());
                    current = allNodes.get(current.getPrevious());
                } while (current != null);
                itinerary.setRoute(route);
                return itinerary;
            }

            ItineraryRepository.getConnsByOrigId(next.getCurrent().getId()).forEach(connection -> {
                City city = connection.getDest();
                ItineraryTimeNode nextNode = allNodes.getOrDefault(city, new ItineraryTimeNode(city));
                allNodes.put(city, nextNode);

                int newScore = next.getTimeScore() + (int) connection.getDuration().toMinutes(); // time to get to city
                if (newScore < nextNode.getTimeScore()) {
                    nextNode.setPrevious(next.getCurrent());
                    nextNode.setTimeScore(newScore);
                    nextNode.setEstimatedTimeScore(newScore + city.calcEstimatedTime(destiny));
                    nextNode.setConns(next.getConns() + 1);
                    openSet.add(nextNode);
                }
            });
        }

        throw new IllegalStateException("No route found");
    }
}
