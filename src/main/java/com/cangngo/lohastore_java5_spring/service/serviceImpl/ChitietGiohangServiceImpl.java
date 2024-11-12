package com.cangngo.lohastore_java5_spring.service.serviceImpl;

import com.cangngo.lohastore_java5_spring.dto.CartItem;
import com.cangngo.lohastore_java5_spring.dto.ChitietGiohangDTO;
import com.cangngo.lohastore_java5_spring.entity.ChitietGiohang;
import com.cangngo.lohastore_java5_spring.entity.Giohang;
import com.cangngo.lohastore_java5_spring.entity.Sanpham;
import com.cangngo.lohastore_java5_spring.repository.ChitietGiohangRepository;
import com.cangngo.lohastore_java5_spring.repository.GiohangRepository;
import com.cangngo.lohastore_java5_spring.repository.SanphamRepository;
import com.cangngo.lohastore_java5_spring.service.ChitietGiohangService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChitietGiohangServiceImpl implements ChitietGiohangService {

    @Autowired
    ChitietGiohangRepository chitietGiohangRepository;

    @Autowired
    GiohangRepository giohangRepository;

    @Autowired
    SanphamRepository sanphamRepository;

    @Override
    public void updateQuantityById(int idCTGiohang, int quantity) {

    }

    @Transactional
    @Override
    public ChitietGiohangDTO insertChitietgiohang(int idGiohang, int idSanpham, double price) {
        try {
            Giohang giohang = giohangRepository.findById(idGiohang)
                    .orElseThrow(() -> new RuntimeException("Giohang not found"));
            Sanpham sanpham = sanphamRepository.findById(idSanpham)
                    .orElseThrow(() -> new RuntimeException("Sanpham not found"));

            Optional<ChitietGiohang> chitietGiohang =
                    chitietGiohangRepository.getCTGIohangByIdgiohangAndIdSanpham(idGiohang, idSanpham);


            ChitietGiohang ctgh;
            if (chitietGiohang.isEmpty()) {
                ctgh = new ChitietGiohang();
                ctgh.setGiaTaiThoiDiemThem(price);
                ctgh.setSanpham(sanpham);
                ctgh.setGiohang(giohang);
                ctgh.setSoLuong(1);
                 ctgh  = chitietGiohangRepository.save(ctgh);
                return new ChitietGiohangDTO(
                        ctgh.getIdChitietGiohang(),
                        ctgh.getSoLuong(),
                        ctgh.getGiaTaiThoiDiemThem(),
                        ctgh.getSanpham().getIdSanpham(),
                        ctgh.getIdChitietGiohang())   ;
            } else {
                ctgh = chitietGiohang.get();
                ctgh.setSoLuong(ctgh.getSoLuong() + 1);
                ChitietGiohang savedCtgh = chitietGiohangRepository.save(ctgh);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving ChitietGiohang: " + e.getMessage());
        }
    }

    @Override
    public void removeChitietgiohang(int idChitietgiohang) {

    }

    @Override
    public List<CartItem> findByIdGiohang(int idGiohang) {
        return chitietGiohangRepository.findByIdGiohang(idGiohang);
    }
}
