package com.binar.grab.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "trains")
public class Train implements Serializable{
	
	private static final long serialVersionUID = 1L;

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
    
    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}
    
    public void setDescription(String description) {this.description = description;}
    public String getDescription() {return this.description;}
    
    public void setDistanceBetweenStop(String distanceBetweenStop) {this.distanceBetweenStop = distanceBetweenStop;}
    public String getDistanceBetweenStop() {return this.distanceBetweenStop;}
    
    public void setMaxSpeed(String maxSpeed) {this.maxSpeed = maxSpeed;}
    public String getMaxSpeed() {return this.maxSpeed;}
    
    public void setSharingTracks(Boolean sharingTracks) {this.sharingTracks = sharingTracks;}
    public Boolean getSharingTracks() {return this.sharingTracks;}
    
    public void setGradeCrossing(Boolean gradeCrossing) {this.gradeCrossing = gradeCrossing;}
    public Boolean getGradeCrossing() {return this.gradeCrossing;}
    
    public void setTrainFrequency(String trainFrequency) {this.trainFrequency = trainFrequency;}
    public String getTrainFrequency() {return this.trainFrequency;}
    
    public void setAmenities(String amenities) {this.amenities = amenities;}
    public String getAmenities() {return this.amenities;}
}
