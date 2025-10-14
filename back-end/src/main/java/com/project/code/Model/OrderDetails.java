package com.project.code.Model;

import java.time.LocalDateTime; 
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

    @ManyToOne 
	@JoinColumn(name="customer_id")
	@JsonManagedReference
	private Customer customer;

	@ManyToOne 
	@JoinColumn(name="store_id")
	@JsonManagedReference
	private Store store;

	private Double totalPrice;
    
    private LocalDateTime date; 

    @OneToMany(mappedBy="orderDetails",fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<OrderItem> orderItems;

    public OrderDetails(Customer customer, Store store, Double totalPrice, LocalDateTime date) { 
        this.customer = customer;
        this.store = store;
        this.totalPrice = totalPrice;
        this.date = date;
    }
    public OrderDetails() {
        
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

}
