package com.binar.grab.controller;

import com.binar.grab.model.Train;
import com.binar.grab.repository.TrainRepo;
import com.binar.grab.service.TrainService;
import com.binar.grab.util.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @PostMapping("/add")
    public ResponseEntity<Map> insert(@RequestBody Train train){
        Map map = trainService.insert(train);
        return new ResponseEntity<Map>(map, HttpStatus.CREATED);
    }

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

    @GetMapping("/")
    public ResponseEntity<Map> getAll(){
    	Map<String, Object> map = new HashMap<>();
    	map.put("data", trainRepo.findAll());
	    map.put("code", "200");
	    map.put("status", "success");
	    return new ResponseEntity<Map>(map, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable("id") long id){
    	Optional<Train> trainData = trainRepo.findById(id);
    	if(trainData.isPresent()) {
    			return new ResponseEntity<>(trainData.get(), HttpStatus.OK);
    	}else 	return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
    
}
