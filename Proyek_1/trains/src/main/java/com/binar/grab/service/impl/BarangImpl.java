//package com.binar.grab.service.impl;
//
//import com.binar.grab.model.Barang;
//import com.binar.grab.repository.BarangRepo;
//import com.binar.grab.service.BarangService;
//import com.binar.grab.util.TemplateResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.*;
//import java.util.*;
//
//@Service
//@Transactional
//public class BarangImpl implements BarangService {
//    public static final Logger log = LoggerFactory.getLogger(BarangImpl.class);
//
//    @Autowired
//    public BarangRepo repo;
//
//    @Autowired
//    public TemplateResponse templateResponse;
//
//    @Override
//    public Map insert(Barang barang, Long idsupplier) {
//        return null;
//    }
//
//    @Override
//    public Map getAll(int size, int page) {
//        Pageable show_data = PageRequest.of(page,size);
//        Page<Barang> list = repo.getAll(show_data);
//        return templateResponse.templateSukses(list);
//    }
//
//    @Override
//    public Map update(Barang barang, Long idsupplier) {
//        return null;
//    }
//
//    @Override
//    public Map delete(Long barang) {
//        /*
//        soft delete, tidak delete permanent dan masih ada di database
//        1. check id barang
//        2. update , tanggal delete saja
//         */
//        return null;
//    }
//
//    @Override
//    public Map findByNama(String nama, Integer page, Integer size) {
//        /*
//        1. buat query dulu where nama barang
//         */
//        return null;
//    }
//
//    @Override
//    public Page<Barang> findByNamaLike(String nama, Pageable pageable) {
//        try{
//            Page<Barang> list = repo.findByNamaLike("'%" + nama + "%'", pageable);
//
//            return list;
//        }catch (Exception e){
//            log.error("Error di method findByNamaLike");
//            return null;
//        }
//    }
//}
//
