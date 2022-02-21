//package com.binar.grab.controller;
//
//import com.binar.grab.model.Contoh;
//import com.binar.grab.model.Mahasiswa;
//import com.binar.grab.repository.MahasiswaRepository;
//import com.binar.grab.service.ContohService;
//import com.binar.grab.service.MahasiswaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/contoh")
//public class ContohController {
//    @Autowired
//    public ContohService contohService;
//
//    @GetMapping("") //Method GET
//    public ResponseEntity<Map> getAllData(){
//        Map map = contohService.getAllData();
//        return new ResponseEntity<Map>(map, HttpStatus.OK);
//    }
//
//    @PostMapping("") //Method POST
//    public ResponseEntity<Map> insertData(@RequestBody Contoh obj){
//        Map map = contohService.insert(obj);
//        return new ResponseEntity<Map>(map, HttpStatus.OK);
//    }
////    @PostMapping() //Method POST
////    @PutMapping()  //Method PUT
////    @DeleteMapping //Method DELETE
//}
