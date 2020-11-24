package spring.challenge.citiesServer.repository;

import org.springframework.data.repository.CrudRepository;

import spring.challenge.citiesServer.repository.model.City;

public interface CityRepository extends CrudRepository<City, Long> {

}
