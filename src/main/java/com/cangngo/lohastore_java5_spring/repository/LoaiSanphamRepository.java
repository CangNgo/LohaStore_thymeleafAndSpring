package com.cangngo.lohastore_java5_spring.repository;

import com.cangngo.lohastore_java5_spring.entity.LoaiSanpham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoaiSanphamRepository extends JpaRepository<LoaiSanpham, Integer> {
}
