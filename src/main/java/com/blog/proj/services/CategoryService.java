package com.blog.proj.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.proj.payloads.CatagoryDto;


public interface CategoryService {
    public CatagoryDto createCategory(CatagoryDto catagoryDto);
    public CatagoryDto updateCategory(CatagoryDto catagoryDto , Integer categoryId);
    public void deleteCategory( Integer categoryId);
    public CatagoryDto getCategory( Integer categoryId);
    public List<CatagoryDto> getAllCategory();
    
}
