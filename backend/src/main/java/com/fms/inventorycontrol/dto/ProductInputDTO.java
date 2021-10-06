package com.fms.inventorycontrol.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import com.fms.inventorycontrol.entities.ProductInput;
import com.fms.inventorycontrol.entities.User;
import com.fms.inventorycontrol.entities.enums.MaterialType;
import com.fms.inventorycontrol.entities.enums.UnitMeasurement;

import lombok.Data;

@Data
public class ProductInputDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private Instant instantMoment;
	private BigDecimal quantity;
	private String costCenter;
	private User user;
	
	public ProductInputDTO(ProductInput entity) {
		id = entity.getId();
		instantMoment = entity.getInstantMoment();
		quantity = entity.getQuantity();
		costCenter = entity.getCostCenter();
		user = entity.getUser();
	}
	
}
