package com.cangngo.lohastore_java5_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChitietGiohangDTO {
    private Integer idChitietGiohang;
    private int soLuong;
    private Double giaTaiThoiDiemThem;
    private Integer sanphamId;
    private Integer giohangId;

    public ChitietGiohangDTO(Integer idChitietGiohang, int soLuong, Integer idSanpham, int idGiohang) {
    }
}
