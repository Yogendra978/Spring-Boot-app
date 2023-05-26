package com.backend.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.exception.ResourceNotFoundException;
import com.backend.model.Category;
import com.backend.model.Product;
import com.backend.repository.CategoryRepository;
import com.backend.repository.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Product createProduct(Product product,int id) {
		
		//fetch category
		
		Category cat = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(id+" this category id not found"));
		
		product.setCategory(cat);
		return  productRepo.save(product);
		 
		
	}

	public List<Product> viewAll() {
		return productRepo.findAll();
		 
	}
	
	
	public Product viewProductById(int id) {
		return productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(id+"  this product id not found"));
		 
	}
	
	
	public Product updateProduct(Product p,int pid) {
		Product f = productRepo.findById(pid).orElseThrow(()->new ResourceNotFoundException(pid+" this product id not found"));
		f.setPname(p.getPname());
		f.setPdesc(p.getPdesc());
		f.setPimg(p.getPimg());
		f.setPlive(p.isPlive());
		f.setPquantity(p.getPquantity());
		f.setPstock(p.isPstock());
		f.setPprize(p.getPprize());
		f.setCategory(p.getCategory());
		 Product update = productRepo.save(f);
		 System.out.println(update);
		 return update;
	}

	public void deleteProduct(int id) {
		Product byId = productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(id+" this product id not found"));
		productRepo.deleteById(id);
		
	}

	public List<Product> getProductByPage(int pageNumber, int pageSize) {
	
		Pageable p=PageRequest.of(pageNumber, pageSize);
		 Page<Product> pageProduct = productRepo.findAll(p);
		 List<Product> content = pageProduct.getContent();
		return content;
	}

	
	
}
