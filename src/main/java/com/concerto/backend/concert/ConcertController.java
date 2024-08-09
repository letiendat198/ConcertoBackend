package com.concerto.backend.concert;

import com.concerto.backend.user.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConcertController {
    Logger logger = LoggerFactory.getLogger(ConcertController.class);

    ConcertService concertService;

    public ConcertController(@Autowired ConcertService concertService){
        this.concertService = concertService;
    }

    @GetMapping("/concert")
    public List<Concert> getAllConcerts(){
        return concertService.getAllConcerts();
    }

    @GetMapping("/concert/{concertId}")
    public Concert getConcertDetails(@PathVariable Integer concertId){
        return concertService.getConcertDetails(concertId);
    }

    @PostMapping("/concert")
    public ResponseEntity<String> createConcert(@RequestBody Concert concert){
        try{
            concertService.createConcert(concert);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("New concert created", HttpStatus.OK);
    }
}
