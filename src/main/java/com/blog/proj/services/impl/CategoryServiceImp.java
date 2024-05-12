package com.blog.proj.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.proj.entities.Category;
import com.blog.proj.payloads.CatagoryDto;
import com.blog.proj.repo.CategoryRepo;
import com.blog.proj.services.CategoryService;

public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryRepo  categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CatagoryDto createCategory(CatagoryDto catagoryDto) {
		// TODO Auto-generated method stub
		Category cat= this.modelMapper.map(catagoryDto, Category.class);
		Category addedCat=this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat,CatagoryDto.class );
	}

	@Override
	public CatagoryDto updateCategory(CatagoryDto catagoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatagoryDto deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatagoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatagoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
