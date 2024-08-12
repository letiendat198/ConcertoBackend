package com.concerto.backend.venue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VenueController {
    Logger logger = LoggerFactory.getLogger(VenueController.class);

    VenueService venueService;

    public VenueController(@Autowired VenueService venueService){
        this.venueService = venueService;
    }

    @GetMapping("/venue")
    public List<Venue> getAllVenue(){
        return venueService.getAllVenues();
    }

    @GetMapping("/venue/{venueId}")
    public Venue getVenueDetails(@PathVariable Integer venueId){
        return venueService.getVenueDetails(venueId);
    }

    @PostMapping("/venue")
    public ResponseEntity<String> createVenue(@RequestBody Venue venue){
        try{
            venueService.createVenue(venue);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("New venue created", HttpStatus.OK);
    }
}
