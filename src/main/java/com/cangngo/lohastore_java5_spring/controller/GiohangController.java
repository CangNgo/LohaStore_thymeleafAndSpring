package com.cangngo.lohastore_java5_spring.controller;

import com.cangngo.lohastore_java5_spring.dto.CartItem;
import com.cangngo.lohastore_java5_spring.dto.ChitietGiohangDTO;
import com.cangngo.lohastore_java5_spring.dto.Giohang;
import com.cangngo.lohastore_java5_spring.entity.ChitietGiohang;
import com.cangngo.lohastore_java5_spring.service.ChitietGiohangService;
import com.cangngo.lohastore_java5_spring.service.GiohangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gio-hang")
public class GiohangController {


    @Autowired
    ChitietGiohangService chitietGiohangService;

    @GetMapping
    public String giohang(Model model) {

        int idGiohang = 1 ;
        int idNguoidung = 1 ;

        List<CartItem> cartItem =chitietGiohangService.findByIdGiohang(idGiohang);
        double sumPrice = cartItem.stream()
                .mapToDouble(CartItem::getGia)
                .sum();
        model.addAttribute("cartItem", cartItem);
        model.addAttribute("sumPrice", sumPrice);
        return "web/views/giohang";
    }

    @PostMapping("/them-moi-chi-tiet-giohang")
    @ResponseBody // Đảm bảo phương thức trả về JSON
    public ChitietGiohangDTO themMoiChiTietGiohang(@RequestParam("productId") Integer productId,
                                                   @RequestParam("priceProduct") Double price) {
        int idGiohang = 1; // Giả sử giỏ hàng có id cố định là 1

        // Trả về đối tượng JSON chứa tổng tiền
        return chitietGiohangService.insertChitietgiohang(idGiohang, productId, price);
    }
}
