package com.binar.grab.controller;

import com.binar.grab.model.Train;
import com.binar.grab.repository.TrainRepo;
import com.binar.grab.service.TrainService;
import com.binar.grab.util.TemplateResponse;
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

    @Autowired
    protected TemplateResponse templateResponse;

    /**
     * Get all data train
     * Challenge : EASY Nomor 1
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<Map> getAll(){
	    return new ResponseEntity<Map>(trainService.getAll(), HttpStatus.OK);
    }

    /**
     * Get all data train berdasarkan id
     * Challenge : EASY Nomor 2
     * @param id : id_train
     * @return
     */
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

    /**
     * Delete data train dengan id = 1
     * Challenge : MEDIUM Nomor 3
     * @param id : id_train
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map> deleteTrainById(@PathVariable("id") long id){
        try {
            Map map = trainService.delete(id);
            return new ResponseEntity<Map>(map, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(templateResponse.templateNotFound(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update data train, edit existing train by id
     * Challenge : HARD Nomor 1
     * @param train : Objek Train berdasarkan inputan klien,
     * @param id    : Id_train
     * @return ResponseEntity<Map>
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map> update(@PathVariable(value = "id") Long id, @RequestBody Train train){
    	try{
            Optional<Train> checkId = trainRepo.findById(id);
            if (!checkId.isPresent()){
                return new ResponseEntity<Map>(templateResponse.templateErrorNotFound("Train not found"), HttpStatus.NOT_FOUND);
            }
            Map map = trainService.update(train, id);
            return new ResponseEntity<Map>(map, HttpStatus.OK);
        }catch (Exception e){
            System.err.print(e);
            return new ResponseEntity<Map>(templateResponse.templateErrorNotFound("Bad Request"), HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * Insert data train
     * Challenge : HARD Nomor 2
     * @param train : Objek Train berdasarkan inputan klien
     * @return ResponseEntity<Map>
     */
    @PostMapping("/")
    public ResponseEntity<Map> insert(@RequestBody Train train){
        Map map = trainService.insert(train);
        return new ResponseEntity<Map>(map, HttpStatus.CREATED);
    }
}
