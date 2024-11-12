package com.cangngo.lohastore_java5_spring.service.serviceImpl;

import com.cangngo.lohastore_java5_spring.dto.SanphamDTO;
import com.cangngo.lohastore_java5_spring.dto.SanphamDTOAdd;
import com.cangngo.lohastore_java5_spring.entity.LoaiSanpham;
import com.cangngo.lohastore_java5_spring.entity.Sanpham;
import com.cangngo.lohastore_java5_spring.repository.LoaiSanphamRepository;
import com.cangngo.lohastore_java5_spring.repository.SanphamRepository;
import com.cangngo.lohastore_java5_spring.service.SanphamService;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SanphamServiceImpl implements SanphamService {

    @Autowired
    SanphamRepository sanphamRepository;

    @Autowired
    LoaiSanphamRepository loaiSanphamRepository;

    @Override
    public List<Sanpham> findAll() {
        return sanphamRepository.findAll();
    }

    @Override
    public Optional<Sanpham> findById(int id) {
        return sanphamRepository.findById(id);
    }

    @Override
    public List<Sanpham> findByCategory(String category) {
        return sanphamRepository.findByCategory(category);
    }

    @Override
    public String addSanpham(SanphamDTOAdd sanphamDTO) {

        Sanpham sanpham = new Sanpham();
        Optional<LoaiSanpham> lsp = loaiSanphamRepository.findById(Integer.parseInt(sanphamDTO.getLoaiSanpham()));
       if(lsp.isPresent()) {
           LoaiSanpham loaiSanpham = lsp.get();
           sanpham.setLoaiSanpham(loaiSanpham);
           sanpham.setTenSanpham(sanphamDTO.getTenSanpham());
           sanpham.setGia(sanphamDTO.getGia());
           sanpham.setHinhAnh(sanphamDTO.getHinhAnh());
           sanpham.setMoTa(loaiSanpham.getMoTa());
           sanpham.setSoLuongTonKho(sanphamDTO.getSoLuongTonKho());
            sanphamRepository.save(sanpham);
            return "Thành công";
       }
        return "Thất bại";
    }

}
