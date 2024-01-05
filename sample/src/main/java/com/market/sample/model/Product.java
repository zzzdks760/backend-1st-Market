package com.market.sample.model;

import java.time.LocalDateTime;

public class Product {
	private LocalDateTime date;
	private String item ;
	private String brand ;
	private int quantity;
	private int price;
	
	public Product(LocalDateTime date, String item, String brand, int quantity, int price) {
		this.date = date;
		this.item = item;
		this.brand = brand;
		this.quantity = quantity;
		this.price = price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getItem() {
		return item;
	}

	public String getBrand() {
		return brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}
	
}
