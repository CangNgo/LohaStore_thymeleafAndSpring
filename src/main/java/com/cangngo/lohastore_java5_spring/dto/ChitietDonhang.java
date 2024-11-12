package com.cangngo.lohastore_java5_spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChitietDonhang {
    private Integer idChitietDonhang;

    private Donhang donhang;

    private Sanpham sanpham;

    private Integer soLuong;

    private double giaTaiThoiDiemMua;
}
