package spring.challenge.citiesClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import spring.challenge.citiesClient.service.ItineraryService;
import spring.challenge.citiesClient.service.model.Itinerary;

@Controller
@RequestMapping(path = "/itinerary", produces = "application/json")
@Api(description = "Calculate different itineraries among cities")
public class ItineraryController {

    @Autowired
    private ItineraryService itineraryService;

    @ApiOperation(value = "Retrieve all the possible itineraries among all available cities")
    @GetMapping(path = { "", "/" })
    @ResponseBody
    List<Itinerary> getAllItineraries() {
        return itineraryService.getAllItineraries();
    }

    @ApiOperation(value = "Retrieve all the possible itineraries among the given city and the rest of the cities")
    @GetMapping(path = "/{id}")
    @ResponseBody
    List<Itinerary> getItineraryByOrigId(@PathVariable Long id) {
        return itineraryService.getItinerariesByOrigId(id);
    }

}
