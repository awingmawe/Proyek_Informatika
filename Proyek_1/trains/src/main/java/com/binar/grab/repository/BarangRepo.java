package com.binar.grab.repository;

import com.binar.grab.model.Barang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface BarangRepo extends
        PagingAndSortingRepository<Barang, Long> {

    @Query("select c from Barang c")
    Page<Barang> getAll(Pageable page);

    @Query("select c from Barang c WHERE c.id = :id")
    public Barang getById(@Param("id") Long idBarang);

    @Query("select c from Barang c where c.nama = :nama")
    public Page<Barang> findByNama(String nama, Pageable page);

    public Page<Barang> findByNamaLike(String nama, Pageable page);

    public Barang findBySatuan(String satuan);

    public Barang findBySatuanAndHarga(String satuan, int harga);

    public Barang findBySatuanAndHargaOrNama(String satuan, int harga, String nama);

    public Barang findBySatuanAndHargaOrNamaLike(String satuan, int harga, String nama);
}
