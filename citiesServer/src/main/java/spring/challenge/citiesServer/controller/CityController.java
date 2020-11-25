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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import spring.challenge.citiesServer.exceptions.CityNotFoundException;
import spring.challenge.citiesServer.repository.CityRepository;
import spring.challenge.citiesServer.repository.model.City;

@RestController
@RequestMapping(path = "/city", produces = "application/json")
@Api(description = "Get information about cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @ApiOperation(value = "Gets all cities")
    @GetMapping(path = { "/", "" })
    public @ResponseBody Iterable<City> getCities() {
        return cityRepository.findAll();
    }

    @ApiOperation(value = "Gets one city given its id")
    @GetMapping("/{id}")
    City getCityById(@PathVariable Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
    }

    @ApiOperation(value = "Creates a new city")
    @PostMapping(path = { "/", "" })
    City newCity(@RequestBody City newCity) {
        return cityRepository.save(newCity);
    }

    @ApiOperation(value = "Updates an existing city or creates a new one if it doesn't exist")
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

    @ApiOperation(value = "Deletes a city")
    @DeleteMapping("/{id}")
    void DeleteCity(@PathVariable Long id) {
        cityRepository.deleteById(id);
    }
}
