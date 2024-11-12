package com.cangngo.lohastore_java5_spring.service;

import com.cangngo.lohastore_java5_spring.dto.SanphamDTO;
import com.cangngo.lohastore_java5_spring.dto.SanphamDTOAdd;
import com.cangngo.lohastore_java5_spring.entity.Sanpham;

import java.util.List;
import java.util.Optional;

public interface SanphamService {
    List<Sanpham> findAll();
    Optional<Sanpham> findById(int id);
    List<Sanpham> findByCategory(String category);
    String addSanpham(SanphamDTOAdd sanphamDTO);
}
