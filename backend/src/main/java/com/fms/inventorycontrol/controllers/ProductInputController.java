package com.fms.inventorycontrol.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fms.inventorycontrol.dto.ProductInputDTO;
import com.fms.inventorycontrol.entities.ProductInput;
import com.fms.inventorycontrol.services.ProductInputService;

@RestController
@RequestMapping(value = "/entradas")
public class ProductInputController {

	@Autowired
	private ProductInputService service;

	@GetMapping
	public ResponseEntity<List<ProductInputDTO>> findAll() {
		List<ProductInput> list = service.findAll();
		List<ProductInputDTO> listDTO = list.stream().map(x -> new ProductInputDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductInputDTO> findById(@PathVariable String id) {
		ProductInput obj = service.findById(id);
		return ResponseEntity.ok().body(new ProductInputDTO(obj));
	}

//	@GetMapping(value = "/codprod")
//	public ResponseEntity<ProductInputDTO> findByCodProd(
//			@RequestParam(value = "text", defaultValue = "") Long codProd) {
//		ProductInput obj = service.findByCodProd(codProd);
//		return ResponseEntity.ok().body(new ProductInputDTO(obj));
//	}
//
//	@GetMapping(value = "/materialtype")
//	public ResponseEntity<List<ProductInput>> findByMaterialType(
//			@RequestParam(value = "text", defaultValue = "") String materialType) {
//		List<ProductInput> list = service.findByMaterialType(materialType);
//		return ResponseEntity.ok().body(list);
//	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ProductInputDTO objDto) {
		ProductInput obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
