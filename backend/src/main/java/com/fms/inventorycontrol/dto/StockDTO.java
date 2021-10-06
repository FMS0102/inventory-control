package com.fms.inventorycontrol.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fms.inventorycontrol.entities.Stock;
import com.fms.inventorycontrol.entities.enums.MaterialType;
import com.fms.inventorycontrol.entities.enums.UnitMeasurement;

import lombok.Data;

@Data
public class StockDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long prodCod;
	private String name;
	private BigDecimal getBalanceProd;
	private UnitMeasurement unitMeasurement;
	private BigDecimal price;
	private MaterialType materialType;

	public StockDTO(Stock entity) {
		getBalanceProd = entity.getBalanceProd();
	}

}
