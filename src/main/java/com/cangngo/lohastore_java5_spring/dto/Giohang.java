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
public class Giohang {
 private int idGiohang;

   private Khachhang khachhang;

   private LocalDateTime ngayTao;

   private String trangThai;

    private Set<ChitietGiohang> chitietGiohangs;
}