package com.cangngo.lohastore_java5_spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChitietGiohang {

    private Integer idChitietGiohang;

    private Giohang giohang;

    private Sanpham sanpham;

    private int soLuong;

    private double giaTaiThoiDiemThem;
}