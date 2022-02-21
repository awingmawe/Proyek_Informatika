package com.binar.grab.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "trains")
public class Trains implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "distance-between-stop", nullable = false)
    private String distanceBetweenStop;

    @Column(name = "max-speed", nullable = false)
    private String maxSpeed;

    @Column(name = "sharing-tracks", nullable = false)
    private Boolean sharingTracks;

    @Column(name = "grade-crossing", nullable = false)
    private Boolean gradeCrossing;

    @Column(name = "train-frequency", nullable = false)
    private String trainFrequency;

    @Column(name = "amenities", nullable = false)
    private String amenities;
}
