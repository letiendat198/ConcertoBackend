package com.concerto.backend.concert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConcertService {
    Logger logger = LoggerFactory.getLogger(ConcertService.class);

    ConcertRepository concertRepository;

    public ConcertService(@Autowired ConcertRepository concertRepository){
        this.concertRepository = concertRepository;
    }

    public List<Concert> getAllConcerts(){
        return concertRepository.findAll();
    }

    public Concert getConcertDetails(Integer concertId){
        ArrayList<Integer> concertIdIter = new ArrayList<>();
        concertIdIter.add(concertId);
        return concertRepository.findAllById(concertIdIter).get(0);
    }

    public void createConcert(Concert concert) throws Exception{
        try{
            concertRepository.save(concert);
        }
        catch(Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }
}
