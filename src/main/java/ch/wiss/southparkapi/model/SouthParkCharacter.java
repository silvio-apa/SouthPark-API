package ch.wiss.southparkapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * Represents a South Park charakter stored in the database.
 */

@Entity
@Table(name = "south_park_character")
public class SouthParkCharacter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false, length = 100)
    private String name;

    private Integer age;

    @Column(nullable = false, length = 50)
    private String gender;


    @Column(length = 100)
    private String occupation;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(name = "image_url")
    private String imageUrl;

    public SouthParkCharacter() {

    }

    public SouthParkCharacter(String name, Integer age, String gender, String occupation, String status, String imageUrl){
        this.name       = name;
        this.age        = age;
        this.gender     = gender;
        this.occupation = occupation;
        this.status     = status;
        this.imageUrl   = imageUrl;


    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getStatus() {
        return status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
