package com.backend.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cid;
	private String Ctitle;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Product> product;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Category(int cid, String ctitle) {
		super();
		Cid = cid;
		Ctitle = ctitle;
	}



	public int getCid() {
		return Cid;
	}



	public void setCid(int cid) {
		Cid = cid;
	}



	public String getCtitle() {
		return Ctitle;
	}



	public void setCtitle(String ctitle) {
		Ctitle = ctitle;
	}
	
	public Set<Product> getProduct(Set<Product> product){
		return product;
	}
	
	public void SetProduct(Set<Product> product) {
		this.product = product;
	}


}
