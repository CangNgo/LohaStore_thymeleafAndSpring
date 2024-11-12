package com.cangngo.lohastore_java5_spring.repository;

import com.cangngo.lohastore_java5_spring.entity.Khachhang;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KhachhangRepository extends JpaRepository<Khachhang, Integer> {
}
