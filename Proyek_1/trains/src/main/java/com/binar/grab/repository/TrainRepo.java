package com.binar.grab.repository;

import com.binar.grab.model.Trains;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepo extends
        JpaRepository<Trains, Long> {

}
