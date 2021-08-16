package com.fms.inventorycontrol.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fms.inventorycontrol.entities.Product;
import com.fms.inventorycontrol.entities.enums.MaterialType;
import com.fms.inventorycontrol.entities.enums.UnitMeasurement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private Long prodCod;
	private String name;
	private UnitMeasurement unitMeasurement;
	private BigDecimal price;
	private MaterialType materialType;

	public ProductDTO(Product obj) {
		id = obj.getId();
		prodCod = obj.getProdCod();
		name = obj.getName();
		unitMeasurement = obj.getUnitMeasurement();
		price = obj.getPrice();
		materialType = obj.getMaterialType();
	}

}
