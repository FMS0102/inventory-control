package com.fms.inventorycontrol.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fms.inventorycontrol.entities.ProductInput;

@Repository
public interface ProductInputRepository extends MongoRepository<ProductInput, String> {

	//@Query("{'prodCod': {$eq: ?0}}")
	//Optional<ProductInput> findByCodProd(Long codProd);

	//@Query("{'materialType': {$regex: ?0, $options: 'i'}}")
	//Optional<List<ProductInput>> findByMaterialType(String materialType);

}
