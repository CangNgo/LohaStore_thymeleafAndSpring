package com.cangngo.lohastore_java5_spring.controller.admin;

import com.cangngo.lohastore_java5_spring.dto.SanphamDTO;
import com.cangngo.lohastore_java5_spring.dto.SanphamDTOAdd;
import com.cangngo.lohastore_java5_spring.entity.LoaiSanpham;
import com.cangngo.lohastore_java5_spring.entity.Sanpham;
import com.cangngo.lohastore_java5_spring.repository.SanphamRepository;
import com.cangngo.lohastore_java5_spring.service.SanphamService;
import com.cangngo.lohastore_java5_spring.service.serviceImpl.LoaiSanphamServiceImpl;
import com.cangngo.lohastore_java5_spring.service.serviceImpl.SanphamServiceImpl;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ProductController {

    @Autowired
    LoaiSanphamServiceImpl loaiSanphamServiceImpl;

    @Autowired
    ServletContext servletContext;

    @Autowired
    SanphamServiceImpl sanphamServiceImpl;
    @Autowired
    private SanphamService sanphamService;

    @GetMapping
    public String showProduct(Model model) {
        List<LoaiSanpham> danhSachLoai = loaiSanphamServiceImpl.GetAllLoaiSanpham();
        model.addAttribute("danhSachLoai", danhSachLoai);
        model.addAttribute("sanpham", new SanphamDTO());
        return "web/views/admin/addProduct";
    }

    @PostMapping
    public String product(@Valid @ModelAttribute("sanpham") SanphamDTO sanpham,
                          BindingResult bindingResult,
                          @RequestParam("hinhAnh") MultipartFile file,
                          Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            model.addAttribute("danhSachLoai", loaiSanphamServiceImpl.GetAllLoaiSanpham());
            return "web/views/admin/addProduct";
        }

        String fileName = "";
        if (!file.isEmpty()) {
            fileName = file.getOriginalFilename();

            Path uploadPath = Paths.get("src/main/resources/static/web/img");

            try {
                Files.createDirectories(uploadPath);

                Path filePath = uploadPath.resolve(fileName);
                file.transferTo(filePath);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        SanphamDTOAdd dto = new SanphamDTOAdd();
        dto.setHinhAnh(fileName);
        dto.setTenSanpham(sanpham.getTenSanpham());
        dto.setLoaiSanpham(sanpham.getLoaiSanpham());
        dto.setGia(sanpham.getGia());
        dto.setMoTa(sanpham.getMoTa());
        dto.setSoLuongTonKho(sanpham.getSoLuongTonKho());
        sanphamService.addSanpham(dto);
        return "redirect:/admin/product";
    }

}
