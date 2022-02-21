package com.binar.grab.service.impl;

import com.binar.grab.model.Barang;
import com.binar.grab.repository.BarangRepo;
import com.binar.grab.service.BarangService;
import com.binar.grab.util.TemplateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.*;
import java.util.*;

@Service
@Transactional
public class BarangImpl implements BarangService {
    public static final Logger log = LoggerFactory.getLogger(BarangImpl.class);

    @Autowired
    public BarangRepo repo;
    @Autowired
    public SupplierRepo repoSupp;
    @Autowired
    public TemplateResponse templateResponse;

    @Override
    public Map insert(Barang barang, Long idsupplier) {
        try{
            if (templateResponse.checkNull(barang.getHarga())){
                templateResponse.templateError("Barang is required!");
            }
            if (templateResponse.checkNull(barang.getNama())){
                templateResponse.templateError("Nama is required!");
            }
            Supplier checkId = repoSupp.getbyID(idsupplier);
            if(templateResponse.checkNull(checkId)){
                return templateResponse.templateError("Id Supplier tidak ada!");
            }
            barang.setSupplier(checkId);
            Barang save = repo.save(barang);
            return templateResponse.templateSukses(save);
        }catch (Exception e){
            return templateResponse.templateError(e);
        }
    }

    @Override
    public Map getAll(int size, int page) {
        Pageable show_data = PageRequest.of(page,size);
        Page<Barang> list = repo.getAll(show_data);
        return templateResponse.templateSukses(list);
    }

    @Override
    public Map update(Barang barang, Long idsupplier) {
        try{
            //check id supplier
            if(templateResponse.checkNull(idsupplier)){
                return templateResponse.templateError("Id Supplier Tidak Ditemukan");
            }
            Supplier idSupplier = repoSupp.getbyID(idsupplier);
            if (templateResponse.checkNull(idSupplier)){
                return templateResponse.templateError("Id Supplier Kosong");
            }

            //check id barang
            Barang checkIdBarang = repo.getById(barang.getId());
            if (templateResponse.checkNull(checkIdBarang)){
                return templateResponse.templateError("Id Barang Kosong");
            }

            //simpan database
            checkIdBarang.setNama(barang.getNama());
            checkIdBarang.setHarga(barang.getHarga());
            checkIdBarang.setStok(barang.getStok());
            checkIdBarang.setSatuan(barang.getSatuan());
            Barang doSave = repo.save(checkIdBarang);

            return templateResponse.templateSukses(doSave);
        }catch (Exception e){
            return templateResponse.templateError(e);
        }
    }

    @Override
    public Map delete(Long barang) {
        /*
        soft delete, tidak delete permanent dan masih ada di database
        1. check id barang
        2. update , tanggal delete saja
         */
        try{
            if (templateResponse.checkNull(barang)){
                return templateResponse.templateError("Id Barang Required");
            }

            //1. check id barang
            Barang checkIdBarang = repo.getById(barang);
            if (templateResponse.checkNull(checkIdBarang)){
                return templateResponse.templateError("Id Barang Kosong");
            }

            //2. update , tanggal delete
            checkIdBarang.setDeleted_date(new Date());
            repo.save(checkIdBarang);

            return templateResponse.templateSukses("Sukses Deleted");
        }catch (Exception e){
            log.error("Error di method delete Barang");
            return templateResponse.templateError(e);
        }
    }

    @Override
    public Map findByNama(String nama, Integer page, Integer size) {
        /*
        1. buat query dulu where nama barang
         */
        try{
            Pageable show_data = PageRequest.of(page,size);
            Page<Barang> list = repo.findByNama(nama, show_data);

            return templateResponse.templateSukses(list);
        }catch (Exception e){
            log.error("Error di method findByNama");
            return templateResponse.templateError(e);
        }
    }

    @Override
    public Page<Barang> findByNamaLike(String nama, Pageable pageable) {
        try{
            Page<Barang> list = repo.findByNamaLike("'%" + nama + "%'", pageable);

            return list;
        }catch (Exception e){
            log.error("Error di method findByNamaLike");
            return null;
        }
    }
}

