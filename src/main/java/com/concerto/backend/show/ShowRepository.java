package com.concerto.backend.show;

import com.concerto.backend.concert.Concert;
import com.concerto.backend.venue.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {
    public List<Show> findAllByConcertId(Concert concert);
    public List<Show> findAllByVenueId(Venue venue);
}
