package com.kcsitglobal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcsitglobal.entity.Product;
import com.kcsitglobal.repository.ProductRepsoitory;

@Service
public class ProductService {

	@Autowired
	private ProductRepsoitory productRepsoitory;

	public Product save(Product product) {
		int qty = product.getQuantity();
		double totalprice = qty * product.getPrice();
		product.setTotalPrice(totalprice);
		Product newProduct = productRepsoitory.save(product);
		return newProduct;

	}

	public List<Product> getProducts() {
		return productRepsoitory.findAll();
	}

	public  Product getProductById(int id) {
		return productRepsoitory.findById(id).orElse(null);
	}

	

}
