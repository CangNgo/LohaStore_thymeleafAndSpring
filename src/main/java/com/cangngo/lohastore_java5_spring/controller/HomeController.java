package com.cangngo.lohastore_java5_spring.controller;

import com.cangngo.lohastore_java5_spring.entity.Sanpham;
import com.cangngo.lohastore_java5_spring.repository.SanphamRepository;
import com.cangngo.lohastore_java5_spring.service.SanphamService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/")
@NoArgsConstructor
@AllArgsConstructor
public class HomeController {

    @Autowired
    SanphamService sanphamService;
    @Autowired
    private SanphamRepository sanphamRepository;

    @GetMapping
    public String home(Model model) {
        int page = 1;
        int cartNumber = 0;

        model.addAttribute("page", page);
        List<Sanpham> listSanPham = sanphamService.findAll();
        if(listSanPham.size() > 0) {
            cartNumber = listSanPham.size();
        }

        model.addAttribute("cartNumber", 1);
        model.addAttribute("listSanPham", listSanPham);

        return "web/views/home";
    }
}
