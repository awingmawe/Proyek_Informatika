package com.binar.grab.controller;

import com.binar.grab.model.Barang;
import com.binar.grab.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/binar/barang/")
public class BarangController {

    @Autowired
    public BarangService barangService;

    @PostMapping("save/{idsupplier}")
    public ResponseEntity<Map> save(@PathVariable(value="idsupplier") Long idSupplier,
                                    @RequestBody Barang objModel){
        Map obj = barangService.insert(objModel, idSupplier);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping("update/{idsupplier}")
    public ResponseEntity<Map> update(@PathVariable(value="idsupplier") Long idSupplier,
                                    @RequestBody Barang objModel){
        Map obj = barangService.update(objModel, idSupplier);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value="id") Long id){
        Map map = barangService.delete(id);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity<Map> listByNama(
            @RequestParam() Integer page,
            @RequestParam() Integer size){
        Map list = barangService.getAll(size,page);
        return new ResponseEntity<Map>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
