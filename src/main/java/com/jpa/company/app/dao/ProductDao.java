package com.jpa.company.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Fetch;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.company.app.entities.Category;
import com.jpa.company.app.entities.Products;

@Repository
public class ProductDao {

	@Autowired
	SessionFactory sf;

	public List<Products> getallProducts() {
		Session se = sf.openSession();
		Criteria cr = se.createCriteria(Products.class);
		List<Products> prod = cr.list();
		return prod;

	}

	public Products createNewProduct(Products product) {
		Session se = sf.openSession();
		Transaction tr = se.beginTransaction();

		se.save(product);

		tr.commit();
		se.close();

		return product;

	}

	public Products productbyId(int pid) {
		Session session = sf.openSession();
		Products product = session.get(Products.class, pid);
		session.close();
		return product;

	}

	public String deleteProduct(int id) {
		Session se = sf.openSession();
		Transaction tr = se.beginTransaction();

		Products product = se.get(Products.class, id);
		se.delete(product);
		tr.commit();
		se.close();
		return "Product Deleted";

	}

}
