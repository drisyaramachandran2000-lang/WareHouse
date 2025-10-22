package model;

import jakarta.persistence.Entity;

@Entity
public class Product {
	
	private int id;
	private String name;
	private String description;
	private String vendorName;
	private int price;
	private int stock;
	private String currency;
	private String imageUrl;
	
	
	private String sku;
	
	public Product() {
		super();
	}
	
	
	
	public Product(int id, String name, String description, String vendorName, int price, int stock, String currency,
			String imageUrl, String sku) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.vendorName = vendorName;
		this.price = price;
		this.stock = stock;
		this.currency = currency;
		this.imageUrl = imageUrl;
		this.sku = sku;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public String getSku() {
		return sku;
	}



	public void setSku(String sku) {
		this.sku = sku;
	}
	
	
}
