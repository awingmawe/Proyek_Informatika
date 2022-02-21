//package com.binar.grab.service.impl;
//
//import com.binar.grab.model.Contoh;
//import com.binar.grab.repository.ContohRepo;
//import com.binar.grab.service.ContohService;
//import com.binar.grab.util.TemplateResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class ContohImpl implements ContohService {
//    @Autowired
//    public ContohRepo contohRepo;
//
//    @Autowired
//    public TemplateResponse templateResponse;
//
//    @Override
//    public Map insert(Contoh contoh) {
//        return templateResponse.templateSukses(contohRepo.save(contoh));
//    }
//
//    @Override
//    public Map getAllData() {
////        Map map = new HashMap();
////        map.put("data", contohRepo.findAll());
////        map.put("code", "200");
////        map.put("status", "success");
//        return templateResponse.templateSukses(contohRepo.findAll());
//    }
//
//    @Override
//    public Map getDataById(Long id) {
//        return null;
//    }
//}
