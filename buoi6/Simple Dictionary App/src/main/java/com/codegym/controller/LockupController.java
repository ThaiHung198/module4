package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LockupController {

    // Tạo một map tĩnh để làm "cơ sở dữ liệu" từ điển
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "Xin chào");
        dictionary.put("world", "Thế giới");
        dictionary.put("book", "Quyển sách");
        dictionary.put("computer", "Máy tính");
    }

    // Xử lý yêu cầu GET, hiển thị trang tra cứu ban đầu
    @GetMapping("/lookup")
    public String showForm() {
        return "DictionaryApplication"; // Trả về tên của view (index.jsp)
    }

    // Xử lý yêu cầu POST khi người dùng submit form
    @PostMapping("/lookup")
    public String lookup(@RequestParam("englishWord") String englishWord, Model model) {
        // Tìm kiếm từ trong map
        String vietnameseWord = dictionary.get(englishWord.toLowerCase());

        // Chuẩn bị dữ liệu để trả về view
        model.addAttribute("englishWord", englishWord); // Gửi lại từ đã nhập

        if (vietnameseWord != null) {
            model.addAttribute("result", vietnameseWord); // Nếu tìm thấy
        } else {
            model.addAttribute("result", "Không tìm thấy từ này."); // Nếu không tìm thấy
        }

        return "DictionaryApplication"; // Trả về view "index" để hiển thị kết quả
    }
}
