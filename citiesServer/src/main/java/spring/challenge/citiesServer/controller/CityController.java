package spring.challenge.citiesServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.challenge.citiesServer.exceptions.CityNotFoundException;
import spring.challenge.citiesServer.repository.CityRepository;
import spring.challenge.citiesServer.repository.model.City;

@RestController
@RequestMapping(path = "/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(path = { "/", "" })
    public @ResponseBody Iterable<City> getCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    City getCityById(@PathVariable Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
    }

    // @GetMapping("/{name}")
    // City getCityById(@PathVariable String name) {
    // return cityRepository.findByName(name).orElseThrow(() -> new
    // CityNotFoundException(name));
    // }

    @PostMapping(path = { "/", "" })
    City newCity(@RequestBody City newCity) {
        return cityRepository.save(newCity);
    }

    @PutMapping("/{id}")
    City updateCity(@RequestBody City newCity, @PathVariable Long id) {

        return cityRepository.findById(id).map(city -> {
            city.setName(newCity.getName());
            city.setPopulation(newCity.getPopulation());
            return cityRepository.save(city);
        }).orElseGet(() -> {
            newCity.setId(id);
            return cityRepository.save(newCity);
        });
    }

    @DeleteMapping("/{id}")
    void DeleteCity(@PathVariable Long id) {
        cityRepository.deleteById(id);
    }
}
