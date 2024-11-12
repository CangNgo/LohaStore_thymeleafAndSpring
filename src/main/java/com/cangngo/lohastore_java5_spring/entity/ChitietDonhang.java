package com.cangngo.lohastore_java5_spring.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ChitietDonhang")
public class ChitietDonhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ChitietDonhang")
    private Integer idChitietDonhang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Donhang")
    private Donhang donhang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Sanpham")
    private Sanpham sanpham;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "GiaTaiThoiDiemMua")
    private Double giaTaiThoiDiemMua;
}
