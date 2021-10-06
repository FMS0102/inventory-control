package com.fms.inventorycontrol.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@Document
public class ProductInput implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Instant instantMoment;
	private BigDecimal quantity;
	private String costCenter;

	private User user;
	Set<Product> products = new HashSet<>();

	public ProductInput(String id, Instant instantMoment, BigDecimal quantity, String costCenter, User user) {
		super();
		this.id = id;
		this.instantMoment = instantMoment;
		this.quantity = quantity;
		this.costCenter = costCenter;
		this.user = user;
	}

	public void addProducts(Product prod) {
		products.add(prod);
	}

	public void removeProducts(Product prod) {
		products.remove(prod);
	}

}
