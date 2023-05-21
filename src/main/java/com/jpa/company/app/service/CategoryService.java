package com.jpa.company.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.company.app.dao.CategoryDao;
import com.jpa.company.app.entities.Category;
import com.jpa.company.app.entities.Products;

@Service
public class CategoryService {

	@Autowired
	CategoryDao dd;

	public List<Category> getallCategory() {
		return dd.getallCategory();

	}

	public Category createNewCategory(Category category) {
		return dd.createNewCategory(category);

	}

	public Object categorybyId(int id) {
		return dd.categorybyId(id);

	}

	public Category updtCategory(int id, Category category) {
		return dd.updtCategory(id, category);

	}

	public String deleteCategory(int id) {
		return dd.deleteCategory(id);

	}

}
