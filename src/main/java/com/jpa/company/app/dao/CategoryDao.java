package com.jpa.company.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.company.app.entities.Category;

@Repository
public class CategoryDao {

	@Autowired
	SessionFactory sf;

	public List<Category> getallCategory() {
		Session se = sf.openSession();
		Criteria cr = se.createCriteria(Category.class);
		List<Category> al = cr.list();
		return al;

	}

	public Category createNewCategory(Category category) {

		Session se = sf.openSession();
		Transaction tr = se.beginTransaction();
		se.save(category);

		tr.commit();
		se.close();
		return category;

	}

	public Object categorybyId(int id) {
		Session se = sf.openSession();
		Category obj = se.get(Category.class, id);
	
		if (obj != null) {
			return obj;
		} else {
			return "no data found";

		}

	}

	public Category updtCategory(int id, Category category) {
		Session se = sf.openSession();
		Transaction tr = se.beginTransaction();

		Category cc = se.get(Category.class, id);
		cc.setName(category.getName());
		se.update(cc);

		tr.commit();
		
		return cc;

	}

	public String deleteCategory(int id) {
		Session se = sf.openSession();
		Transaction tr = se.beginTransaction();

		Category category = se.get(Category.class, id);
		se.delete(category);

		tr.commit();
		se.close();
		return ":data deleted";
	}

}
