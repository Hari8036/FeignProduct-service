package com.kcsitglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.entity.Product;
import com.kcsitglobal.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public ResponseEntity<Product>save(@RequestBody Product product){
		Product products=productService.save(product);
		return new ResponseEntity<Product>(products,HttpStatus.CREATED);
		
	}
	@GetMapping("/products")
	public ResponseEntity<List<Product>>getProducts(){
		List<Product>products=productService.getProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
	@GetMapping("/products/{id}")
	public ResponseEntity<Product>getProductById(@PathVariable("id") int id){
		Product products=productService.getProductById(id);
		return new ResponseEntity<Product>(products,HttpStatus.OK);
	}

}
