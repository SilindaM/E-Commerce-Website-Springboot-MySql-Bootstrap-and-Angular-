package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Products;
import com.example.demo.Repository.ProductRepository;

@RequestMapping("/api/products")
@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	//get All products
	@GetMapping("")
	public ResponseEntity<List<Products>> getAllProducts(){
		try {
			List<Products> products=productRepository.findAll();
			return new ResponseEntity<>(products,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//get product by id
	@GetMapping("{id}")
	public ResponseEntity<Products> getProductByID(@PathVariable (value = "id") Long id){
		Optional<Products> product=productRepository.findById(id);
		 if(product.isPresent()) {
			 return new ResponseEntity<>(product.get(),HttpStatus.OK);
		 }
		 else {
			 return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		 }
	}
	//post  product
	@PostMapping("create")
	public ResponseEntity<Products> postProducts(@RequestBody Products product){
		try {
			Products create=productRepository.save(product);
			return new ResponseEntity<Products>(create,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
	}
	//update product
	@PutMapping("id")
	public ResponseEntity<Products> Update(@PathVariable(value="id") Long id,@RequestBody Products product){
		try {
			Optional<Products> findId=productRepository.findById(id);
			if(findId.isPresent()) {
				return new ResponseEntity<>(findId.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//delete by id
	public ResponseEntity<HttpStatus> deleteById(@PathVariable (value = "id") Long id){
		try {
			productRepository.deleteById(id);
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
