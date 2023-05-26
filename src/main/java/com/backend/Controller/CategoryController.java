package com.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Category;
import com.backend.services.CategoryServices;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryServices categoryService;
	
	//http://localhost:8080/api/category/create
	@PostMapping("/create")
	@ResponseBody
	public Category create(@RequestBody Category category) {
		Category createCategoty = categoryService.create(category);
		return createCategoty;
	}
	
	//http://localhost:8080/api/category/view
	@GetMapping("/view")
	public List<Category> listAll(){
		List<Category> all = categoryService.viewAll();
		return all;
	}
	
	//http://localhost:8080/api/category/view/id
	@GetMapping("/view/{categoryId}")
	public Category viewCategoryById(@PathVariable int categoryId) {
		Category category = categoryService.viewCategotyById(categoryId);
		return category;
	}
	
	//http://localhost:8080/api/category/update/id
	@PutMapping("/update/{id}")
	public Category updateCategory(@PathVariable int id,@RequestBody Category newCat){
		Category updateCategory = categoryService.updateCategory(id, newCat);
		return updateCategory;
	}
	
	
	//http://localhost:8080/api/categoty/delete/id
	@DeleteMapping("/delete/{categoryId}")
	public void dateteCategory(@PathVariable int categoryId) {
		categoryService.deleteById(categoryId);
	}
	
	
	//http://localhost:8080/api/category/items?pageNumber=2&pageSize=2
	@GetMapping("/items")
	public List<Category> getCategory(
			@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "2") int pageSize){
		List<Category> categoryItems = categoryService.getCategoryItems(pageNumber,pageSize);
		return categoryItems;
	}
	
	
}
