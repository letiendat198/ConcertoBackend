package com.concerto.backend.venue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VenueService {
    Logger logger = LoggerFactory.getLogger(VenueService.class);

    VenueRepository venueRepository;

    public VenueService(@Autowired VenueRepository venueRepository){
        this.venueRepository = venueRepository;
    }

    public List<Venue> getAllVenues(){
        return venueRepository.findAll();
    }

    public Venue getVenueDetails(Integer venueId){
        ArrayList<Integer> idList = new ArrayList<>();
        idList.add(venueId);
        return venueRepository.findAllById(idList).get(0);
    }

    public void createVenue(Venue venue) throws Exception{
        try{
            venueRepository.save(venue);
        }
        catch(Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }
}
