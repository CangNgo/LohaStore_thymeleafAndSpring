package com.cangngo.lohastore_java5_spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Khachhang")
public class Khachhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Khachhang")
    private Integer idKhachhang;

    @OneToOne
    @JoinColumn(name = "ID_Taikhoan")
    private Taikhoan taikhoan;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "Email")
    private String email;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "NgaySinh" )
    private LocalDate ngaySinh;

    @Column(name = "NgayDangKy")
    private LocalDateTime ngayDangKy;

    @OneToMany(mappedBy = "khachhang")
    private Set<Giohang> giohangs;

    @OneToMany(mappedBy = "khachhang")
    private Set<Donhang> donhangs;
}
