package com.project.code.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne; 


@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @ManyToOne @JoinColumn(name = "order_id")
	@JsonManagedReference
	private OrderDetails order;
    
    @JsonManagedReference
	@ManyToOne @JoinColumn(name = "product_id")
	private Product product;
	
	private Integer quantity;
	
    private Double price;
	
	public OrderItem() {}
	
    public OrderItem(OrderDetails order, Product product, Integer quantity, Double price) {
		
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public OrderDetails getOrder() {
		return order;
	}
	public Product getProduct() {
		return product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setOrder(OrderDetails order) {
		this.order = order;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}

