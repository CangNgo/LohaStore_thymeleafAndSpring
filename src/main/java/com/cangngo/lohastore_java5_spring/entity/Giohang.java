package com.cangngo.lohastore_java5_spring.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Giohang")
public class Giohang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Giohang")
    private int idGiohang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Khachhang")
    private Khachhang khachhang;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "TrangThai")
    private String trangThai;

    @OneToMany(mappedBy = "giohang")
    private List<ChitietGiohang> chitietGiohangs;
}