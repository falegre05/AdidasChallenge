package spring.challenge.citiesClient.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import spring.challenge.citiesClient.repository.model.City;
import spring.challenge.citiesClient.repository.model.Connection;

@Repository
public class ItineraryRepository {

    @Value("${cities.server.host}")
    private String mIp;
    @Value("${cities.server.port}")
    private String mPort;

    public List<City> getAllCities() {
        String url = "http://" + mIp + ":" + mPort + "/city/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<City[]> cities = restTemplate.getForEntity(url, City[].class);
        return Arrays.asList(cities.getBody());
    }

    public List<Connection> getConnsByOrigId(Long id) {
        String url = "http://" + mIp + ":" + mPort + "/connection/origin/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Connection[]> conns = restTemplate.getForEntity(url, Connection[].class);
        return Arrays.asList(conns.getBody());
    }
}
