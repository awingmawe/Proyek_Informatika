package com.binar.grab.controller;

import com.binar.grab.model.Train;
import com.binar.grab.repository.TrainRepo;
import com.binar.grab.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/trains")
public class TrainController {
    @Autowired
    protected TrainService trainService;
    
    @Autowired
    protected TrainRepo trainRepo;

    @PostMapping("/add")
    public ResponseEntity<Map> insert(@RequestBody Train train){
        Map map = trainService.insert(train);
        return new ResponseEntity<Map>(map, HttpStatus.CREATED);
    }
   
    @GetMapping("/")
    public ResponseEntity<Map> getAll(){
	    return new ResponseEntity<Map>(trainService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable("id") long id){
    	Optional<Train> trainData = trainRepo.findById(id);
    	if(trainData.isPresent()) {
    			return new ResponseEntity<>(trainData.get(), HttpStatus.OK);
    	}else 	return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
    
    /**
     * Cari semua kereta yang sharing-tracks nya === TRUE
     * Challenge : MEDIUM Nomor 1
     * @return
     */
    @GetMapping("/sharing-tracks")
    public ResponseEntity<Map> getAllSharingTracks(){
    	Map<String, Object> map = trainService.getAllSharingTracks();
    	return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
    /**
     * Cari semua kereta yang amenities nya mengandung keyword...
     * Challenge : MEDIUM Nomor 2
     * @param amenities : keyword
     * @return ResponseEntity<Map>
     */
    @GetMapping("")
    public ResponseEntity<Map> getTrainByAmenities(@RequestParam(required = false) String amenities){
    	Map<String, Object> map = trainService.getAllAmenitiesContaining(amenities);
    	return new ResponseEntity<>(map, HttpStatus.OK);
    }
   
}
