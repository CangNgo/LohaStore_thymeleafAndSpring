package com.cangngo.lohastore_java5_spring.repository;

import com.cangngo.lohastore_java5_spring.dto.CartItem;
import com.cangngo.lohastore_java5_spring.entity.Giohang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiohangRepository extends JpaRepository<Giohang, Integer> {


    List<CartItem> findByIdGiohang(int idGiohang);
}
