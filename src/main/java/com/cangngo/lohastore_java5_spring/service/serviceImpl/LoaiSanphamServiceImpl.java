package com.cangngo.lohastore_java5_spring.service.serviceImpl;

import com.cangngo.lohastore_java5_spring.entity.LoaiSanpham;
import com.cangngo.lohastore_java5_spring.repository.LoaiSanphamRepository;
import com.cangngo.lohastore_java5_spring.service.LoaiSanphamService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor()

public class LoaiSanphamServiceImpl implements LoaiSanphamService {

    @Autowired
    LoaiSanphamRepository loaiSanphamRepository;

    @Override
    public Optional<LoaiSanpham> GetLoaiSanphamById(Integer id) {
        return loaiSanphamRepository.findById(id);
    }

    @Override
    public List<LoaiSanpham> GetAllLoaiSanpham() {
        return loaiSanphamRepository.findAll();
    }
}
