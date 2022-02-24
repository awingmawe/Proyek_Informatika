package com.binar.grab.repository;

import com.binar.grab.model.Train;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepo extends
        JpaRepository<Train, Long> {

	public List<Train> findByAmenitiesContaining(String s);
	
	public List<Train> findBySharingTracks(Boolean b);
}
