package com.binar.grab.controller;

import com.binar.grab.model.Mahasiswa;
import com.binar.grab.repository.MahasiswaRepository;
import com.binar.grab.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/mhs")
public class MahasiswaController {
    @Autowired
    public MahasiswaService serviceMahasiswa;

    @Autowired
    public MahasiswaRepository mahasiswaRepository;

    @PostMapping("")
    public ResponseEntity<Map> save(@RequestBody Mahasiswa obj){
        Map save = serviceMahasiswa.insert(obj);
        return new ResponseEntity<Map>(save, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id") Long id
    ) {
        Map update = serviceMahasiswa.delete(id);
        return new ResponseEntity<Map>(update, HttpStatus.OK);// response
    }

    @PutMapping("")
    public ResponseEntity<Map> update(@RequestBody Mahasiswa objModel
    ) {
        Map update = serviceMahasiswa.update(objModel);
        return new ResponseEntity<Map>(update, HttpStatus.OK);// response
    }

    @GetMapping("")
    public ResponseEntity<Map>  getList() {
        Map map = new HashMap();
        map.put("data",mahasiswaRepository.findAll());
        map.put("code", "200");
        map.put("status", "success");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Map> delete(@PathVariable Long id){
//        Map delete = mahasiswaRepository.delete(id);
//        return new ResponseEntity<Map>(delete, HttpStatus.OK);
//    }
}
