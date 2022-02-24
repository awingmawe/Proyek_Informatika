package com.binar.grab.service.impl;

import com.binar.grab.model.Train;
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
    public Map insert(Train trains) {
        try{
            // Validasi kalo inputan dari klien masih ada yang kosong, karena asumsi semua harus required
            if (templateResponse.checkNull(trains.getName())){
                return templateResponse.templateError("Name is required");
            }
            if (templateResponse.checkNull(trains.getAmenities())){
                return templateResponse.templateError("Amenities is required");
            }
            if (templateResponse.checkNull(trains.getDescription())){
                return templateResponse.templateError("Description is required");
            }
            if (templateResponse.checkNull(trains.getGradeCrossing())){
                return templateResponse.templateError("Grade crossing is required");
            }
            if (templateResponse.checkNull(trains.getDistanceBetweenStop())){
                return templateResponse.templateError("Distance between stop is required");
            }
            if (templateResponse.checkNull(trains.getMaxSpeed())){
                return templateResponse.templateError("Max speed is required");
            }
            if (templateResponse.checkNull(trains.getTrainFrequency())){
                return templateResponse.templateError("Train frequency is required");
            }
            if (templateResponse.checkNull(trains.getSharingTracks())){
                return templateResponse.templateError("Sharing tracks is required");
            }
            // Simpan ke database
            Train save = trainRepo.save(trains);

            return templateResponse.templateSukses(save);
        }catch (Exception e){
            log.error("Error pada method Insert Trains");
            System.err.println(e.getMessage());
            return templateResponse.templateError("Failed Validation");
        }
    }

    @Override
    public Map update(Train train, Long id) {
        try{
            log.info("Ini Train : " + train);
            // Validasi kalo inputan dari klien masih ada yang kosong, karena asumsi semua harus required
            if (templateResponse.checkNull(train.getName())){
                return templateResponse.templateError("Name is required");
            }
            if (templateResponse.checkNull(train.getAmenities())){
                return templateResponse.templateError("Amenities is required");
            }
            if (templateResponse.checkNull(train.getDescription())){
                return templateResponse.templateError("Description is required");
            }
            if (templateResponse.checkNull(train.getGradeCrossing())){
                return templateResponse.templateError("Grade crossing is required");
            }
            if (templateResponse.checkNull(train.getDistanceBetweenStop())){
                return templateResponse.templateError("Distance between stop is required");
            }
            if (templateResponse.checkNull(train.getMaxSpeed())){
                return templateResponse.templateError("Max speed is required");
            }
            if (templateResponse.checkNull(train.getTrainFrequency())){
                return templateResponse.templateError("Train frequency is required");
            }
            if (templateResponse.checkNull(train.getSharingTracks())){
                return templateResponse.templateError("Sharing tracks is required");
            }

            Train checkId = trainRepo.getById(id);

            // Update data berdasarkan masukan dari klien
            checkId.setAmenities(train.getAmenities());
            checkId.setDescription(train.getDescription());
            checkId.setMaxSpeed(train.getMaxSpeed());
            checkId.setName(train.getName());
            checkId.setSharingTracks(train.getSharingTracks());
            checkId.setTrainFrequency(train.getTrainFrequency());
            checkId.setDistanceBetweenStop(train.getDistanceBetweenStop());
            checkId.setGradeCrossing(train.getGradeCrossing());

            // Simpan ke database
            trainRepo.save(checkId);

            return templateResponse.templateSuksesUpdate("Train edited succesfully");
        }catch (Exception e){
            log.error("Error pada method Update Trains");
            System.err.println(e.getMessage());
            return templateResponse.templateError("Failed when edit train");
        }
    }
}
