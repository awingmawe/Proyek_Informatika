package com.binar.grab.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "trains")
public class Train{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false, length = 2048)
    private String description;

    @Column(name = "distancebetweenstop", nullable = false)
    private String distanceBetweenStop;

    @Column(name = "maxspeed", nullable = false)
    private String maxSpeed;

    @Column(name = "sharingtracks", nullable = false)
    private Boolean sharingTracks;

    @Column(name = "gradecrossing", nullable = false)
    private Boolean gradeCrossing;

    @Column(name = "trainfrequency", nullable = false)
    private String trainFrequency;

    @Column(name = "amenities", nullable = false)
    private String amenities;
    
    public Train() {}
    
    public Train(Long id, String name, String description, String distanceBetweenStop, String maxSpeed, 
    		Boolean sharingTracks, Boolean gradeCrossing, String trainFrequency, String amenities) {
    	this.id = id;
    	this.name = name;
    	this.description = description;
    	this.distanceBetweenStop = distanceBetweenStop;
    	this.maxSpeed = maxSpeed;
    	this.sharingTracks = sharingTracks;
    	this.gradeCrossing = gradeCrossing;
    	this.trainFrequency = trainFrequency;
    	this.amenities = amenities;
    }
    
    public Long getId() {return this.id;}
    
    public String getName() {return this.name;}
    
    public String getDescription() {return this.description;}
    
    public String getDistanceBetweenStop() {return this.distanceBetweenStop;}
    
    public String getMaxSpeed() {return this.maxSpeed;}
    
    public Boolean getSharingTracks() {return this.sharingTracks;}
    
    public Boolean getGradeCrossing() {return this.gradeCrossing;}
    
    public String getTrainFrequency() {return this.trainFrequency;}
    
    public String getAmenities() {return this.amenities;}
}
