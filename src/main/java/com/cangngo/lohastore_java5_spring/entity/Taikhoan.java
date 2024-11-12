package com.cangngo.lohastore_java5_spring.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Taikhoan")
public class Taikhoan {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Taikhoan")
    private String taikhoan;

    @Column(name = "MATKHAU")
    private String matkhau;

    @Column(name = "VAITRO")
    private Integer vaitro;

    @OneToOne(mappedBy = "taikhoan")
    private Khachhang khachhang;
}