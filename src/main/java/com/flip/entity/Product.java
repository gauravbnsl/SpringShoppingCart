package com.flip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="prodname")
	private String prodname;
	
	@Column(name="price")
	private int price;

	@Column(name="quantity")
	private int quantity;

	public Product() {
	}

	public Product(int id, String prodname, int price, int quantity) {
		this.id = id;
		this.prodname = prodname;
		this.price = price;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getProdname() {
		return prodname;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prodname=" + prodname + ", price=" + price + ", quantity=" + quantity + "]";
	}
}