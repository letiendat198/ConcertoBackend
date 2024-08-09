package com.concerto.backend.concert;

import jakarta.persistence.*;

@Entity
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer concertId ;

    @Column(nullable = false)
    private String concertName;
    @Column(nullable = false)
    private String concertArtist;
    @Column(nullable = true)
    private String concertDescription;
    @Column(nullable = true)
    private String concertImage;

    public Integer getConcertId() {
        return concertId;
    }

    public void setConcertId(Integer concertId) {
        this.concertId = concertId;
    }

    public String getConcertName() {
        return concertName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }

    public String getConcertArtist() {
        return concertArtist;
    }

    public void setConcertArtist(String concertArtist) {
        this.concertArtist = concertArtist;
    }

    public String getConcertDescription() {
        return concertDescription;
    }

    public void setConcertDescription(String concertDescription) {
        this.concertDescription = concertDescription;
    }

    public String getConcertImage() {
        return concertImage;
    }

    public void setConcertImage(String concertImage) {
        this.concertImage = concertImage;
    }
}
