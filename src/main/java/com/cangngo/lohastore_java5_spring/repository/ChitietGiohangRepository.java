package com.cangngo.lohastore_java5_spring.repository;

import com.cangngo.lohastore_java5_spring.dto.CartItem;
import com.cangngo.lohastore_java5_spring.entity.ChitietGiohang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChitietGiohangRepository extends JpaRepository<ChitietGiohang, Integer> {

    @Query("SELECT ctgiohang from ChitietGiohang ctgiohang " +
            "where ctgiohang.giohang.idGiohang = :idGiohang " +
            "and ctgiohang.sanpham.idSanpham = :idSanpham ")
    Optional<ChitietGiohang> getCTGIohangByIdgiohangAndIdSanpham(@Param("idGiohang") Integer idGiohang,
                                                                 @Param("idSanpham") Integer idSanpham);

    @Query("SELECT NEW com.cangngo.lohastore_java5_spring.dto.CartItem(ct.idChitietGiohang, ct.soLuong, " +
            "sp.tenSanpham, sp.gia, sp.hinhAnh, sp.idSanpham) " +
            "FROM ChitietGiohang ct " +
            "JOIN ct.giohang gh " +
            "JOIN ct.sanpham sp " +
            "WHERE ct.giohang.idGiohang = :gioHangId")
    List<CartItem> findByIdGiohang(@Param("gioHangId") int giohangid);
}
