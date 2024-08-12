package com.concerto.backend.show;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowController {
    ShowService showService;

    public ShowController(@Autowired ShowService showService){
        this.showService = showService;
    }

    @GetMapping("/show/concert/{concertId}")
    public List<Show> getShowsForConcert(@PathVariable Integer concertId){
        return showService.getShowsForConcert(concertId);
    }

    @GetMapping("/show/venue/{venueId}")
    public List<Show> getShowsForVenue(@PathVariable Integer venueId){
        return showService.getShowsForVenue(venueId);
    }

    @PostMapping("/show")
    public ResponseEntity<String> createShow(@RequestBody Show showDetails){
        try{
            showService.createShow(showDetails);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("New show created", HttpStatus.OK);
    }
}
