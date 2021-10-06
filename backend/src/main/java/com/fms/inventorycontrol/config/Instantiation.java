package com.fms.inventorycontrol.config;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fms.inventorycontrol.entities.Product;
import com.fms.inventorycontrol.entities.ProductInput;
import com.fms.inventorycontrol.entities.User;
import com.fms.inventorycontrol.entities.enums.MaterialType;
import com.fms.inventorycontrol.entities.enums.UnitMeasurement;
import com.fms.inventorycontrol.repositories.ProductInputRepository;
import com.fms.inventorycontrol.repositories.ProductRepository;
import com.fms.inventorycontrol.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ProductInputRepository prodInputRepo;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository prodRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		prodInputRepo.deleteAll();

		User felipe = new User(null, "Felipe", "felsimoes@gmail.com", "Suprimentos", "secret");

		userRepository.save(felipe);

		Product prod1 = new Product(null, 8544L, "CIMENTO", UnitMeasurement.PCT, BigDecimal.valueOf(30.80),
				MaterialType.QUIMICO);
		Product prod2 = new Product(null, 8545L, "CALL", UnitMeasurement.PCT, BigDecimal.valueOf(22.10),
				MaterialType.QUIMICO);

		prodRepository.saveAll(Arrays.asList(prod1, prod2));

		ProductInput entrada = new ProductInput(null, null, BigDecimal.valueOf(10.00), "VV01", felipe);
		entrada.addProducts(prod1);
		entrada.addProducts(prod2);
		entrada.addProducts(prod2);

		prodInputRepo.save(entrada);
	}

}
