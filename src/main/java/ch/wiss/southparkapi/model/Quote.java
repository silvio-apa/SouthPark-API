package ch.wiss.southparkapi.model;

import jakarta.persistence.*;


/**
 * Represents a quote that belongs to a South Park character.
 */

@Entity
@Table(name = "quote")
public class Quote {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Integer season;

    private Integer episode;


    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private SouthParkCharacter character;


    public Quote() {

    }

    public Quote(String text, Integer season, Integer episode, SouthParkCharacter character) {

        this.text      = text;
        this.season    = season;
        this.episode   = episode;
        this.character = character;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getSeason() {
        return season;
    }

    public Integer getEpisode() {
        return episode;
    }

    public SouthParkCharacter getCharacter() {
        return character;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public void setCharacter(SouthParkCharacter character) {
        this.character = character;
    }
}
