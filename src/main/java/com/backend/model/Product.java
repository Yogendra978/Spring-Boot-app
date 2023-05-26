package com.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Pid;
	private String Pname;
	private String Pdesc;
	private double Pprize;
	private boolean Pstock=true;
	private int Pquantity;
	private boolean Plive;
	private String Pimg;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getPdesc() {
		return Pdesc;
	}
	public void setPdesc(String pdesc) {
		Pdesc = pdesc;
	}
	public double getPprize() {
		return Pprize;
	}
	public void setPprize(double pprize) {
		Pprize = pprize;
	}
	public boolean isPstock() {
		return Pstock;
	}
	public void setPstock(boolean pstock) {
		Pstock = pstock;
	}
	public int getPquantity() {
		return Pquantity;
	}
	public void setPquantity(int pquantity) {
		Pquantity = pquantity;
	}
	public boolean isPlive() {
		return Plive;
	}
	public void setPlive(boolean plive) {
		Plive = plive;
	}
	public String getPimg() {
		return Pimg;
	}
	public void setPimg(String pimg) {
		Pimg = pimg;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
