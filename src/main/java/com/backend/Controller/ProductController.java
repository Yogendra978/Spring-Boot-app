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


import com.backend.model.Product;


import com.backend.services.ProductServices;

@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	private ProductServices productServices;
	private List<Product> productByPage;
	
	
	
	//http://localhost:8080/api/products/create/id
	@PostMapping("/create/{cid}")
	@ResponseBody
	public Product createProduct(@RequestBody Product product,@PathVariable int cid) {
		Product createProduct = productServices.createProduct(product,cid);
		return createProduct;
	}
	
	
	//http://localhost:8080/api/products/view
	@GetMapping("/view")
	public List<Product> viewAllProduct(){
		List<Product> viewAll = productServices.viewAll();
		return viewAll;
		
	}
	
	//http://localhost:8080/api/products/view/id
	@GetMapping("/view/{productId}")
	public Product viewProductById(@PathVariable int productId) {
		Product viewProductById = productServices.viewProductById(productId);
		return viewProductById;
	}
	
	
	//http://localhost:8080/api/products/update/id
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable int id,@RequestBody Product p){
		Product updateProduct = productServices.updateProduct(p, id);
		return updateProduct;
	}
	
	
	//http://localhost:8080/api/products/delete/id
	@DeleteMapping("/delete/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		productServices.deleteProduct(productId);
	}
	
	
	
	//http://localhost:8080/api/products/items?pageNumber=2&pageSize=2
	@GetMapping("/items")
	public List<Product> getProducts(
			@RequestParam(value = "PageNumber",defaultValue = "1",required = false) int pageNumber,
		    @RequestParam(value = "pageSize",defaultValue = "3",required = false) int pageSize ){
		  List<Product> productByPage = productServices.getProductByPage(pageNumber,pageSize);
		  return productByPage;
	}
	
}
