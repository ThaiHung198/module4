package com.codegym.baitap1.service;

import com.codegym.baitap1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGenerateService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByTitle(String title, Pageable pageable);
    Page<Blog> findByCategoryId(Long categoryId, Pageable pageable);

}
