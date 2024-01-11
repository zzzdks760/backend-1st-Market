package com.market.sample.model;

import java.time.LocalDateTime;

public class Product {
	private LocalDateTime date;
	private String item ;
	private String brand ;
	private int quantity;
	private int price;
	
	public static class Builder {
		private LocalDateTime date;
		private String item ;
		private String brand ;
		private int quantity;
		private int price;
		
		public Builder() {}
		
		public Builder date(LocalDateTime date) {
			this.date = date;
			return this;
		}
		public Builder item(String item) {
			this.item = item;
			return this;
		}
		public Builder brand(String brand) {
			this.brand = brand;
			return this;
		}
		public Builder quantity(int quantity) {
			this.quantity = quantity;
			return this;
		}
		public Builder price(int price) {
			this.price = price;
			return this;
		}
		
		public Product build() {
			return new Product(this);
		}
	}
	
	public Product(Builder builder) {
		this.date = builder.date;
		this.item = builder.item;
		this.brand = builder.brand;
		this.quantity = builder.quantity;
		this.price = builder.price;
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
