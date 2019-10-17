package com.flip.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flip.entity.Product;

@Repository
public class ProductDAOOmpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProducts() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query <Product> theQuery = currentSession.createQuery("from Product",Product.class);
		
		List<Product> products = theQuery.getResultList();
		
		return products;
	}

	@Override
	public void deleteProduct(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Product theProduct = currentSession.get(Product.class, theId);
		
		theProduct.setQuantity(theProduct.getQuantity()-1);

		
	}

	@Override
	public Product getProduct(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Product theProduct = currentSession.get(Product.class, theId);
		
		System.out.println(theProduct.getQuantity());
				
		return theProduct;
	}
}
