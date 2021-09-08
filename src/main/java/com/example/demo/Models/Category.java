package com.example.demo.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long categoryId;
  @Column(nullable =false)
  private String categoryName;
  @OneToMany(fetch = FetchType.LAZY,mappedBy = "category",cascade = CascadeType.ALL)
  private Set<Products> products;
  
		public Category(Long categoryId, String categoryName, Set<Products> products) {
			super();
			this.categoryId = categoryId;
			this.categoryName = categoryName;
			this.products = products;
			}

		public Category() {
			super();
		}

		public Long getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public Set<Products> getProducts() {
			return products;
		}

		public void setProducts(Set<Products> products) {
			this.products = products;
		}

		@Override
		public String toString() {
			return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", products=" + products
					+ "]";
		}
		  
  
  
  
}
