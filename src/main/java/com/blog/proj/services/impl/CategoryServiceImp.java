package com.blog.proj.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.proj.entities.Category;
import com.blog.proj.exceptions.ResourceNotFoundException;
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
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ","Category Id" , categoryId ));
		
		cat.setCategoryTitle(catagoryDto.getCategoryTitle());
		cat.setCategoryDescription(catagoryDto.getCategoryDescription());
		
		Category updateCat= this.categoryRepo.save(cat);
		return this.modelMapper.map(updateCat, CatagoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat= this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ","Category Id" , categoryId ));
		
		categoryRepo.delete(cat);
	}

	@Override
	public CatagoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat= this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ","Category Id" , categoryId ));
		
		return this.modelMapper.map(cat, CatagoryDto.class);
	}

	@Override
	public List<CatagoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> catList =  this.categoryRepo.findAll();
		
		return catList.stream().map((cat) -> this.modelMapper.map(cat, CatagoryDto.class)).collect(Collectors.toList());
	}

}
