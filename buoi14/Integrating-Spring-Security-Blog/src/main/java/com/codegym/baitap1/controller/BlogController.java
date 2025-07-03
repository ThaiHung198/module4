package com.codegym.baitap1.controller;

import com.codegym.baitap1.model.Blog;
import com.codegym.baitap1.model.Category;
import com.codegym.baitap1.service.IBlogService;
import com.codegym.baitap1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAll();
    }
    @GetMapping("/login")
    public String showLoginPage() {
        // Trả về tên của file view (login.html)
        // Spring sẽ tự tìm file /WEB-INF/login.html
        return "login";
    }

    @GetMapping("")
    public ModelAndView index(@RequestParam(required = false) String search,
                              @RequestParam(required = false) Long categoryId,
                              @PageableDefault(value = 3,sort = "creationDate", direction = Sort.Direction.DESC)  Pageable pageable) {

        Page<Blog> blogs;

        if (search != null && !search.isEmpty()) {
            blogs = blogService.findByTitle(search, pageable);
        } else if (categoryId != null) {
            blogs = blogService.findByCategoryId(categoryId, pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("search", search);
        modelAndView.addObject("categoryId", categoryId);
        return modelAndView;


    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Đã tạo bài blog mới thành công!");
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (blogOptional.isPresent()) {
            model.addAttribute("blog", blogOptional.get());
            return "/blog/edit";
        }
        return "redirect:/blogs";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Đã cập nhật bài blog thành công!");
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (blogOptional.isPresent()) {
            model.addAttribute("blog", blogOptional.get());
            return "/blog/delete";
        }
        return "redirect:/blogs";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Đã xóa bài blog thành công!");
        return "redirect:/blogs";
    }


    @GetMapping("/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (blogOptional.isPresent()) {
            model.addAttribute("blog", blogOptional.get());
            return "/blog/view";
        }
        return "redirect:/blogs";
    }
}
