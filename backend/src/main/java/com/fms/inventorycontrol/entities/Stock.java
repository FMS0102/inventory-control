package com.fms.inventorycontrol.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fms.inventorycontrol.entities.enums.MaterialType;
import com.fms.inventorycontrol.entities.enums.UnitMeasurement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Stock extends ProductInput implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal balanceProd;

}
