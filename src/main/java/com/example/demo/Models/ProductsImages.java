package com.example.demo.Models;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ProductsImages {
	private Long id;
	private byte[] image;
	@OneToMany
	private List<Products> products;
	
	
	
	public ProductsImages() {
		super();
	}


	public ProductsImages(Long id, byte[] image, List<Products> products) {
		super();
		this.id = id;
		this.image = image;
		this.products = products;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public List<Products> getProducts() {
		return products;
	}


	public void setProducts(List<Products> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "ProductsImages [id=" + id + ", image=" + Arrays.toString(image) + ", products=" + products + "]";
	}
	
	
	
	
	
}
