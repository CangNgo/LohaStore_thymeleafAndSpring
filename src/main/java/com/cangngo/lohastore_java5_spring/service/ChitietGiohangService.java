package com.cangngo.lohastore_java5_spring.service;

import com.cangngo.lohastore_java5_spring.dto.CartItem;
import com.cangngo.lohastore_java5_spring.dto.ChitietGiohangDTO;
import com.cangngo.lohastore_java5_spring.entity.ChitietGiohang;

import java.util.List;

public interface ChitietGiohangService {
    void updateQuantityById(int idCTGiohang, int quantity);

    ChitietGiohangDTO insertChitietgiohang(int idGiohang, int idSanpham, double price);

    void removeChitietgiohang(int idChitietgiohang);
    List<CartItem> findByIdGiohang (int idGiohang);
}
