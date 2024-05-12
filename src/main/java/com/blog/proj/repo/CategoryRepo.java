package com.blog.proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.proj.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
