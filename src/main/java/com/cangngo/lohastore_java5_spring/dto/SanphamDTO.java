package com.cangngo.lohastore_java5_spring.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanphamDTO {

    private Integer id;

    @NotNull(message = "Không được bỏ trống")
    private String loaiSanpham;

    @NotBlank(message = "Loại không được để trống")
    private String tenSanpham;

    private String moTa;
    @NotNull(message = "Loại không được để trống")
    private Double gia;

    @Column(name = "SoLuongTonKho")
    private Integer soLuongTonKho;

    @NotNull(message = "Hình ảnh không được để trống ")
    private MultipartFile hinhAnh;

}
