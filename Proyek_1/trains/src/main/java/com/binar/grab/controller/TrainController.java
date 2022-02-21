package com.binar.grab.controller;

import com.binar.grab.model.Trains;
import com.binar.grab.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/trains/")
public class TrainController {
    @Autowired
    public TrainService trainService;

    @PostMapping("")
    public ResponseEntity<Map> insert(@RequestBody Trains trains){
        Map map = trainService.insert(trains);
        return new ResponseEntity<Map>(map, HttpStatus.CREATED);
    }
}
