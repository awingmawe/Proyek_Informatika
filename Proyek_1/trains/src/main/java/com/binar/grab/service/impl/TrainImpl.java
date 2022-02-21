package com.binar.grab.service.impl;

import com.binar.grab.model.Trains;
import com.binar.grab.repository.TrainRepo;
import com.binar.grab.service.TrainService;
import com.binar.grab.util.TemplateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TrainImpl implements TrainService {
    // Untuk log kalo terdapat error atau memberi tahu di dalam terminal lokasi errornya
    @Autowired
    public static final Logger log = LoggerFactory.getLogger(TrainImpl.class);

    @Autowired
    public TrainRepo trainRepo;

    @Autowired
    public TemplateResponse templateResponse;

    @Override
    public Map insert(Trains trains) {
        try{
            // Validasi kalo inputan dari klien masih ada yang kosong, karena asumsi semua harus required
            if (templateResponse.checkNull(trains.getName())){
                templateResponse.templateError("Name is required");
            }
            if (templateResponse.checkNull(trains.getAmenities())){
                templateResponse.templateError("Amenities is required");
            }
            if (templateResponse.checkNull(trains.getDescription())){
                templateResponse.templateError("Description is required");
            }
            if (templateResponse.checkNull(trains.getGradeCrossing())){
                templateResponse.templateError("Grade crossing is required");
            }
            if (templateResponse.checkNull(trains.getDistanceBetweenStop())){
                templateResponse.templateError("Distance between stop is required");
            }
            if (templateResponse.checkNull(trains.getMaxSpeed())){
                templateResponse.templateError("Max speed is required");
            }
            if (templateResponse.checkNull(trains.getTrainFrequency())){
                templateResponse.templateError("Train frequency is required");
            }
            if (templateResponse.checkNull(trains.getSharingTracks())){
                templateResponse.templateError("Sharing tracks is required");
            }
            
            // Simpan ke database
            Trains train = trainRepo.save(trains);
            
            return templateResponse.templateSukses(train);
        }catch (Exception e){
            log.error("Error pada method Insert Trains");
            System.err.println(e.getMessage());
            return templateResponse.templateError(e);
        }
    }
}
