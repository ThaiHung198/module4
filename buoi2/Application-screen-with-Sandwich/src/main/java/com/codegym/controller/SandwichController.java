package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    // 1. Phương thức này xử lý yêu cầu GET để hiển thị form lựa chọn
    @GetMapping("")
    public String showForm() {
        return "index";
    }

    // 2. Phương thức này xử lý yêu cầu POST khi người dùng submit form
    //    Đúng như trong đề bài hướng dẫn.
    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiments, Model model) {
        // "condiment" là tên (name) của các checkbox trong form
        // Spring sẽ tự động tập hợp các giá trị của các checkbox được chọn vào một mảng String[]

        // Thêm danh sách gia vị đã chọn vào model để truyền sang view kết quả
        model.addAttribute("selectedCondiments", condiments);

        return "result"; 
    }
}