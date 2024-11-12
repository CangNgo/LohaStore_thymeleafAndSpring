package com.cangngo.lohastore_java5_spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Donhang {
    private Integer idDonhang;

    private Khachhang khachhang;

    private LocalDateTime ngayDatHang;

    private double tongTien;

    private String trangThaiDonhang;

    private String diaChiGiaoHang;
    private String phuongThucThanhToan;

    private Integer chitietDonhangs;
}