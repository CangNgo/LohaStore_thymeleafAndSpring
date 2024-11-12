package com.cangngo.lohastore_java5_spring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Sanpham")
public class Sanpham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Sanpham")
    private Integer idSanpham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LoaiSanpham")
    @NotNull(message = "Loại sản phẩm không được để trống")
    private LoaiSanpham loaiSanpham;

    @Column(name = "TenSanpham")
    @NotBlank(message = "Loại không được để trống")
    private String tenSanpham;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "Gia")
    @NotNull(message = "Loại không được để trống")
    private Double gia;

    @Column(name = "SoLuongTonKho")
    private Integer soLuongTonKho;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @OneToMany(mappedBy = "sanpham")
    private List<ChitietGiohang> chitietGiohangs;

    @OneToMany(mappedBy = "sanpham")
    private List<ChitietDonhang> chitietDonhangs;
}
