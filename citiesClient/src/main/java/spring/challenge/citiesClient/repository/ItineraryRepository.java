package spring.challenge.citiesClient.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import spring.challenge.citiesClient.CitiesClientApplication;
import spring.challenge.citiesClient.repository.model.City;
import spring.challenge.citiesClient.repository.model.Connection;

public class ItineraryRepository {

    private static final String HOST = "http://" + CitiesClientApplication.IP + ":" + CitiesClientApplication.PORT;

    public static List<City> getAllCities() {
        String url = HOST + "/city/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<City[]> cities = restTemplate.getForEntity(url, City[].class);
        return Arrays.asList(cities.getBody());
    }

    public static List<Connection> getConnsByOrigId(Long id) {
        String url = HOST + "/connection/origin/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Connection[]> conns = restTemplate.getForEntity(url, Connection[].class);
        return Arrays.asList(conns.getBody());
    }
}
