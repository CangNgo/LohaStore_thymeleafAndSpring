package com.cangngo.lohastore_java5_spring.service;

import com.cangngo.lohastore_java5_spring.entity.LoaiSanpham;

import java.util.List;
import java.util.Optional;

public interface LoaiSanphamService {
    Optional<LoaiSanpham> GetLoaiSanphamById(Integer id);
    List<LoaiSanpham> GetAllLoaiSanpham();
}
