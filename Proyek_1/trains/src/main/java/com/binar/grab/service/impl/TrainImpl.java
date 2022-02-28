package com.binar.grab.service.impl;

import com.binar.grab.model.Train;
import com.binar.grab.repository.TrainRepo;
import com.binar.grab.service.TrainService;
import com.binar.grab.util.TemplateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public Map getAllSharingTracks(){
    	try {
    		List<Train> trains = new ArrayList<>();
    		trainRepo.findBySharingTracks(true).forEach(trains::add);
    		
    		return templateResponse.templateSukses(trains);
    	}catch (Exception e) {
    		log.error("Error pada method getAllSharingTracks");
            System.err.println(e.getMessage());
            return templateResponse.templateError(e);
    	}
    }
    
    @Override
    public Map getAllAmenitiesContaining(String keyword) {
    	Map<String, Object> map = new HashMap<>();
    	try {
    		List<Train> trains = new ArrayList<Train>();
    		if(keyword == null)
    			trainRepo.findAll().forEach(trains::add);
    		else
    			trainRepo.findByAmenitiesContaining(keyword).forEach(trains::add);
    		
    		if(trains.isEmpty()) 	return templateResponse.templateNotFound();
    		else 					return templateResponse.templateSukses(trains);
    		
    	}catch (Exception e) {
    		log.error("Error pada method getAllAmenitiesContaining");
            System.err.println(e.getMessage());
            return templateResponse.templateError(e);
    	}
    }
    
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
            trainRepo.save(trains);

            //NOTE : diubah sedikit, ga return objek train nya, biar sesuai sama requirements nya
            return templateResponse.templateSuksesInsert();
        }catch (Exception e){
            log.error("Error pada method Insert Trains");
            System.err.println(e.getMessage());
            return templateResponse.templateError("Failed Validation");
        }
    }

    @Override
    public Map update(Train train, Long id) {
        try{
            //log.info("Ini Train : " + train);
        	
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

    @Override
    public Map delete(Long id) {
        try{
            //gatau diisi apa
            Train checkId = trainRepo.getById(id);
            if (templateResponse.checkNull(checkId)){
                return templateResponse.templateNotFound();
            }
            // Delete ke database
            trainRepo.deleteById(id);
            //NOTE : diubah sedikit, ga return objek train nya, biar sesuai sama requirements nya
            return templateResponse.templateSukses("train remove successfully");
        }catch (Exception e){
            log.error("Error pada method Delete Trains");
            System.err.println(e.getMessage());
            return templateResponse.templateNotFound();
        }
    }

	@Override
	public Map getAll() {
		List<Train> trains = trainRepo.findAll();
		if(trains == null) return templateResponse.templateNotFound();
		else return templateResponse.templateSukses(trains);
	}
}
