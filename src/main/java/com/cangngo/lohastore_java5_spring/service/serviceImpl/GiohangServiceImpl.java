package com.cangngo.lohastore_java5_spring.service.serviceImpl;

import com.cangngo.lohastore_java5_spring.dto.CartItem;
import com.cangngo.lohastore_java5_spring.repository.GiohangRepository;
import com.cangngo.lohastore_java5_spring.service.GiohangService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GiohangServiceImpl implements GiohangService {
    @Autowired
    GiohangRepository giohangRepository;
    @Override
    public List<CartItem> listCartItems(int idGiohang) {
        return giohangRepository.findByIdGiohang(idGiohang);
    }
}
