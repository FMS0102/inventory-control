package com.fms.inventorycontrol.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fms.inventorycontrol.entities.Stock;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {

}
