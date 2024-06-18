package com.blog.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.proj.payloads.CatagoryDto;
import com.blog.proj.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class CategoryController {
   
	@Autowired(required = false)
	private CategoryService categoryService ;
	
	@PostMapping("/createCategory")
	public ResponseEntity<CatagoryDto> createCategory(@Valid @RequestBody CatagoryDto catagoryDto){
		CatagoryDto createCategoryDto = this.categoryService.createCategory(catagoryDto);
		return new ResponseEntity<CatagoryDto>(createCategoryDto , HttpStatus.CREATED);
		
	}
	
	
}
