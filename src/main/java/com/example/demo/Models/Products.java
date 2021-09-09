package com.example.demo.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable =false)
	private String ProductName;
	@Column(nullable =false)
	private double ProductPrice;
	@Column(nullable =false)
	private int ProductQuantity;
	@Column(nullable =false)
	private boolean ProductAvailability;
	@Column(nullable =false)
	private String ProductDescription;
	
	@OneToMany(fetch = FetchType.LAZY)
	private String ProductImage;
	@JsonIgnore
	@JoinColumn(name="imageId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="categoryId",nullable = false)
	private Category category;
	
	public Products() {
		super();
	}

	public Products(Long id, int categoryId, String productName, double productPrice, int productQuantity,
			boolean productAvailability, String productDescription, String productImage, Category category) {
		super();
		this.id = id;
		ProductName = productName;
		ProductPrice = productPrice;
		ProductQuantity = productQuantity;
		ProductAvailability = productAvailability;
		ProductDescription = productDescription;
		ProductImage = productImage;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public double getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}

	public int getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}

	public boolean isProductAvailability() {
		return ProductAvailability;
	}

	public void setProductAvailability(boolean productAvailability) {
		ProductAvailability = productAvailability;
	}

	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}

	public String getProductImage() {
		return ProductImage;
	}

	public void setProductImage(String productImage) {
		ProductImage = productImage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", ProductName=" + ProductName + ", ProductPrice=" + ProductPrice
				+ ", ProductQuantity=" + ProductQuantity + ", ProductAvailability=" + ProductAvailability
				+ ", ProductDescription=" + ProductDescription + ", ProductImage=" + ProductImage + ", category="
				+ category + "]";
	}

	
}	