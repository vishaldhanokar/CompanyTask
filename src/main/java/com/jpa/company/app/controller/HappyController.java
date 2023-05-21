package com.jpa.company.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jpa.company.app.entities.Category;
import com.jpa.company.app.entities.Products;
import com.jpa.company.app.service.CategoryService;
import com.jpa.company.app.service.Productservice;

@RestController
@RequestMapping("/api")
public class HappyController {

	@Autowired
	private CategoryService ss;

	@Autowired
	private Productservice prodservice;

	@GetMapping("/allcategories")
	public List<Category> getallCategory() {
		return ss.getallCategory();

	}

	@RequestMapping("/categories")
	public Category createNewCategory(@RequestBody Category category) {
		return ss.createNewCategory(category);

	}

	@RequestMapping("/categories/{id}")
	public Object categorybyId(@PathVariable int id) {
		return ss.categorybyId(id);
	}

	@RequestMapping("/updatecategories/{id}")
	public Category updtCategory(@PathVariable int id, @RequestBody Category category) {
		return ss.updtCategory(id, category);

	}

	@RequestMapping("/deletecategory/{id}")
	public String deleteCategory(@PathVariable int id) {
		return ss.deleteCategory(id);
	}

	// -----------------------Product CRUD Operation-------------------------

	@RequestMapping("/allproducts")
	public List<Products> getallProducts() {
		return prodservice.getallProducts();

	}

	@RequestMapping("/newproducts")
	public Products createNewProduct(@RequestBody Products product) {
		return prodservice.createNewProduct(product);
	}

	@RequestMapping("/productbyId/{pid}")
	public Products productbyId(@PathVariable int pid) {
		return prodservice.productbyId(pid);
	}

	@RequestMapping("/deleteproducts/{id}")
	public String deleteProduct(@PathVariable int id) {
		return prodservice.deleteProduct(id);
	}
}
