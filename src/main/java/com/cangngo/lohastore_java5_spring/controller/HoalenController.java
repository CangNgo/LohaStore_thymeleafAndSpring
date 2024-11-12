package com.cangngo.lohastore_java5_spring.controller;

import com.cangngo.lohastore_java5_spring.entity.Sanpham;
import com.cangngo.lohastore_java5_spring.service.SanphamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hoa-len")
public class HoalenController {
    @Autowired
    SanphamService sanphamService;

    @GetMapping
    public String hoalen(Model model, @Param("category") String category) {
        model.addAttribute("page", 1 );
        model.addAttribute("trang", 1 );
        model.addAttribute("totalPage", 1 );
        model.addAttribute("pageList", 1 );
        List<Sanpham> listProductHoalen = sanphamService.findByCategory(category);
        model.addAttribute("listProductHoalen", listProductHoalen);
        return "web/views/hoalen";
    }
}
