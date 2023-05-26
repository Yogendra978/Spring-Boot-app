package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.exception.ResourceNotFoundException;
import com.backend.model.Category;
import com.backend.repository.CategoryRepository;

@Service
public class CategoryServices {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public Category create(Category category) {
		Category save = categoryRepository.save(category);
		return save;
	}
	
	public List<Category> viewAll(){
		List<Category> findAll = categoryRepository.findAll();
		return findAll;
	}
	
	
	public Category viewCategotyById(int id) {
		Category findById = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id+" this category id not found"));
		return findById;
	}
	
	
	
	public void deleteById(int id) {
		Category findbyId = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id +" this category id not found"));
		categoryRepository.deleteById(id);
	}

	

	public List<Category> getCategoryItems(int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		Page<Category> findAll = categoryRepository.findAll(page);
		List<Category> content = findAll.getContent();
		return content;
	}

	public Category updateCategory(int id, Category newCat) {
		
		Category oldc = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id+" this category id not found"));
		categoryRepository.findById(id).get();
		oldc.setCtitle(newCat.getCtitle());
		Category update = categoryRepository.save(oldc);
		return update;
	}
	
}
