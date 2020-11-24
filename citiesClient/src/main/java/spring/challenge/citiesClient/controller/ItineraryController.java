package spring.challenge.citiesClient.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.challenge.citiesClient.service.ItineraryService;
import spring.challenge.citiesClient.service.model.Itinerary;

@Controller
@RequestMapping("/itinerary")
public class ItineraryController {

    private ItineraryService itineraryService = new ItineraryService();

    @GetMapping(path = { "", "/" })
    @ResponseBody
    List<Itinerary> getAllItineraries() {
        return itineraryService.getAllItineraries();
    }

    @GetMapping("/{id}")
    @ResponseBody
    List<Itinerary> getItineraryByOrigId(@PathVariable Long id) {
        return itineraryService.getItinerariesByOrigId(id);
    }

}
