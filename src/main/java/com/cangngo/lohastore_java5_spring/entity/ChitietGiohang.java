package com.cangngo.lohastore_java5_spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ChitietGiohang")
public class ChitietGiohang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ChitietGiohang")
    private Integer idChitietGiohang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Giohang")
    private Giohang giohang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Sanpham")
    private Sanpham sanpham;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "GiaTaiThoiDiemThem")
    private Double giaTaiThoiDiemThem;
}
