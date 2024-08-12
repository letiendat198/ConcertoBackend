package com.concerto.backend.show;

import com.concerto.backend.concert.Concert;
import com.concerto.backend.venue.Venue;
import jakarta.persistence.*;

@Entity
@Table(name = "concert_show") // Show is reserved keyword in MySQL, use something else
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    @ManyToOne
    @JoinColumn(name="concert_id", nullable = false)
    private Concert concertId;

    @ManyToOne
    @JoinColumn(name="venue_id", nullable = false)
    private Venue venueId;

    @Column(nullable = false)
    private String time;

    public Venue getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        Venue venueEntity = new Venue();
        venueEntity.setVenueId(venueId);
        this.venueId = venueEntity;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Concert getConcertId() {
        return concertId;
    }

    public void setConcertId(Integer concertId) {
        Concert concertEntity = new Concert();
        concertEntity.setConcertId(concertId);
        this.concertId = concertEntity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
