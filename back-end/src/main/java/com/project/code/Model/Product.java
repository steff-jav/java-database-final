package com.project.code.Model;

import java.util.List; 
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "product name cannot be null")
	private String name;

	@NotNull(message = "category name cannot be null")
	private String category;

	@NotNull(message = "price field cannot be null")
	private Double price;
	
	@NotNull(message = "sku field cannot be null")
	private String sku;
    
    @OneToMany(mappedBy = "product") 
	@JsonManagedReference("inventory-product")
	private List<Inventory> inventory;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

}

