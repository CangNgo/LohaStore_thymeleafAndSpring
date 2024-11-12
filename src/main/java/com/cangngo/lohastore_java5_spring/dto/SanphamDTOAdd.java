package com.cangngo.lohastore_java5_spring.dto;

import com.cangngo.lohastore_java5_spring.entity.LoaiSanpham;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanphamDTOAdd {

    private Integer id;

    private String loaiSanpham;

    private String tenSanpham;

    private String moTa;
    private Double gia;

    private Integer soLuongTonKho;

    private String hinhAnh;

}
