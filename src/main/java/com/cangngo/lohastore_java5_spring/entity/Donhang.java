package com.cangngo.lohastore_java5_spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Donhang")
public class Donhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Donhang")
    private Integer idDonhang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Khachhang")
    private Khachhang khachhang;

    @Column(name = "NgayDatHang")
    private LocalDateTime ngayDatHang;

    @Column(name = "TongTien")
    private Double tongTien;

    @Column(name = "TrangThaiDonhang")
    private String trangThaiDonhang;

    @Column(name = "DiaChiGiaoHang")
    private String diaChiGiaoHang;

    @Column(name = "PhuongThucThanhToan")
    private String phuongThucThanhToan;

    @OneToMany(mappedBy = "donhang")
    private Set<ChitietDonhang> chitietDonhangs;
}