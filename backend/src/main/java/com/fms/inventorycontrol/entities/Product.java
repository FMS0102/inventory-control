package com.fms.inventorycontrol.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Long prodCod;
	private String name;
	private UnitMeasurement unitMeasurement;
	private BigDecimal price;
	private MaterialType materialType;
}
