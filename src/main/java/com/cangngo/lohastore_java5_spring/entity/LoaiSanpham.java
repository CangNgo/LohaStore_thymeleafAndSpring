package com.cangngo.lohastore_java5_spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LoaiSanpham")
public class LoaiSanpham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LoaiSanpham")
    private Integer idLoaiSanpham;

    @Column(name = "TenLoai")
    private String tenLoai;

    @Column(name = "MoTa")
    private String moTa;

    @OneToMany(mappedBy = "loaiSanpham")
    private Set<Sanpham> sanphams;
}