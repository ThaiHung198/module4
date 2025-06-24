package com.codegym.baitap1.repository;
import com.codegym.baitap1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

}