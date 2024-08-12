package com.concerto.backend.show;

import com.concerto.backend.concert.Concert;
import com.concerto.backend.venue.Venue;
import com.concerto.backend.venue.VenueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    Logger logger = LoggerFactory.getLogger(ShowService.class);

    ShowRepository showRepository;

    public ShowService(@Autowired ShowRepository showRepository){
        this.showRepository = showRepository;
    }

    public List<Show> getShowsForConcert(Integer concertId){
        Concert concertEntity = new Concert();
        concertEntity.setConcertId(concertId);
        return showRepository.findAllByConcertId(concertEntity);
    }

    public List<Show> getShowsForVenue(Integer venueId){
        Venue venueEntity = new Venue();
        venueEntity.setVenueId(venueId);
        return showRepository.findAllByVenueId(venueEntity);
    }

    public void createShow(Show showDetails) throws Exception{
        try{
            showRepository.save(showDetails);
        }
        catch(Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }
}
