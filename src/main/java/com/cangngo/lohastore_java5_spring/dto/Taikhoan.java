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
public class Taikhoan {
    private Integer id;

    private String taikhoan;
    private String matkhau;

    private Integer vaitro;

    private Integer khachhang;
}