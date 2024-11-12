package com.cangngo.lohastore_java5_spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sanpham {
 private Integer idSanpham;

   private LoaiSanpham loaiSanpham;

   private String tenSanpham;

  private String moTa;

  private Double gia;

   private Integer soLuongTonKho;

  private String hinhAnh;

   private Integer chitietGiohangs;

   private Integer chitietDonhangs;
}
