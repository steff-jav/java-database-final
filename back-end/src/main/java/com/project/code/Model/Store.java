package com.project.code.Model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Store {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @NotNull
	private String name;

    @NotNull
	@NotBlank
	private String address;
    
    @OneToMany(mappedBy="store")
	@JsonManagedReference("inventory-store")
	private List<Inventory> inventory;

    public Store(String name, String address) {
		this.name = name;
		this.address = address;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
