package com.fms.inventorycontrol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.inventorycontrol.dto.ProductInputDTO;
import com.fms.inventorycontrol.entities.ProductInput;
import com.fms.inventorycontrol.entities.Stock;
import com.fms.inventorycontrol.repositories.ProductInputRepository;
import com.fms.inventorycontrol.repositories.StockRepository;
import com.fms.inventorycontrol.services.exceptions.ObjectNotFoundException;

@Service
public class ProductInputService {

	@Autowired
	private ProductInputRepository repository;

	@Autowired
	private StockRepository stockRepository;

	public List<ProductInput> findAll() {
		return repository.findAll();
	}

	public ProductInput findById(String id) {
		Optional<ProductInput> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

//	public ProductInput findByCodProd(Long codProd) {
//		Optional<ProductInput> obj = repository.findByCodProd(codProd);
//		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
//	}
//
//	public List<ProductInput> findByMaterialType(String materialType) {
//		Optional<List<ProductInput>> obj = repository.findByMaterialType(materialType);
//		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
//	}

	public ProductInput insert(ProductInput obj) {
		// stockEntrace(obj);
		return repository.insert(obj);
	}

	public ProductInput fromDTO(ProductInputDTO objDto) {
		return new ProductInput(objDto.getId(), objDto.getInstantMoment(), objDto.getQuantity(), objDto.getCostCenter(),
				objDto.getUser());
	}

//	private void stockEntrace(ProductInput obj) {
//		List<Stock> stock = stockRepository.findAll();
//		for (Stock s : stock) {
//			if (s.getProdId() != obj.getProdId()) {
//				stockRepository.insert(s);
//			} else {
//				stockRepository.insert(s);
//			}
//		}
//	}

//	private Stock updateStockItem(Stock obj, ProductInput inputObj) {
//		obj.setQuantity(obj.getQuantity().add(inputObj.getQuantity()));
//		return stockRepository.save(obj);
//	}

}
