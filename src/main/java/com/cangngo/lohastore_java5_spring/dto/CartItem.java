package com.cangngo.lohastore_java5_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Integer idChitietGiohang;
    private int soLuong;
    private String tenSanpham;
    private Double gia;
    private String hinhAnh;
    private Integer idSanpham;

}

