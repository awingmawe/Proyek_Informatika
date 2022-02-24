package com.binar.grab.repository;

import com.binar.grab.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepo extends
        JpaRepository<Train, Long> {
	
}
