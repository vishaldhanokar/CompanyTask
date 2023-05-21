package com.jpa.company.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.company.app.dao.ProductDao;
import com.jpa.company.app.entities.Products;

@Service
public class Productservice {

	@Autowired
	ProductDao proddao;

	public List<Products> getallProducts() {
		return proddao.getallProducts();

	}

	public Products createNewProduct(Products product) {
		return proddao.createNewProduct(product);

	}

	public Products productbyId(int pid) {
		return proddao.productbyId(pid);

	}

	public String deleteProduct(int id) {
		return proddao.deleteProduct(id);

	}

}
