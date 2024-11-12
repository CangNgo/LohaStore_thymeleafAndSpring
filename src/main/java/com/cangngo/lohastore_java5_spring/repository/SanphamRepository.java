package com.cangngo.lohastore_java5_spring.repository;

import com.cangngo.lohastore_java5_spring.dto.SanphamDTOAdd;
import com.cangngo.lohastore_java5_spring.entity.Sanpham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SanphamRepository extends JpaRepository<Sanpham, Integer> {
    @Query("SELECT product FROM Sanpham product JOIN product.loaiSanpham loaiSanPham WHERE loaiSanPham.tenLoai =:category")
    List<Sanpham> findByCategory(@Param("category") String category);

}
