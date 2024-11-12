package com.cangngo.lohastore_java5_spring.service;

import com.cangngo.lohastore_java5_spring.dto.CartItem;

import java.util.List;

public interface GiohangService {
    List<CartItem> listCartItems(int idGiohang);
}
