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

import com.example.demo.Models.Category;
import com.example.demo.Repository.CategoryRepository;

@RestController
@RequestMapping("api/category/")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	
	//get All Categories
	@GetMapping("")
	public ResponseEntity<List<Category>> findAll(){
		try {
			List<Category> getCategory=categoryRepository.findAll();
			return new ResponseEntity<>(getCategory,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//GET BY ID
	@GetMapping("id")
	public ResponseEntity<Category> getByID(@PathVariable(value="id") Long id){
		try {
			Optional<Category> ById=categoryRepository.findById(id);
			if(ById.isPresent()) {
				return new ResponseEntity<>(ById.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//GET BY ID
		@PutMapping("id")
		public ResponseEntity<Category> upDatetByID(@PathVariable(value="id") Long id,@RequestBody Category category){
			try {
				Optional<Category> ById=categoryRepository.findById(id);
				if(ById.isPresent()) {
					Category getOld=ById.get();
					getOld.setCategoryName(category.getCategoryName());
					return new ResponseEntity<>(categoryRepository.save(getOld),HttpStatus.OK);
				}
				else {
					return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		 //POST NEW CATEGORY
		@PostMapping("create")
		public ResponseEntity<Category> newCategory(@RequestBody Category category){
			try {
				Category createNew=categoryRepository.save(category);
				return new ResponseEntity<Category>(createNew,HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	//DELETE BY ID
	public ResponseEntity<HttpStatus> deleteById(@PathVariable (value = "id") Long id){
		try {
			categoryRepository.deleteById(id);
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
}
