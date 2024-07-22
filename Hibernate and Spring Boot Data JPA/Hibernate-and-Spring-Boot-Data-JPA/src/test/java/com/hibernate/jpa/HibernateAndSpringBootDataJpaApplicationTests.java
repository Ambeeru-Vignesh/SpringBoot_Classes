package com.hibernate.jpa;

import com.hibernate.jpa.entities.ProductEntity;
import com.hibernate.jpa.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class HibernateAndSpringBootDataJpaApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(23.45))
				.quantity(4)
				.build();

		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository() {

		//List<ProductEntity> entities = productRepository.findByQuantityGreaterThanOrPriceLessThan(6, BigDecimal.valueOf(10.5));
		List<ProductEntity> entities = productRepository.findByTitleContainingIgnoreCase("CHoco");
		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository() {
		Optional<ProductEntity> productEntity = productRepository
				.findByTitleAndPrice("Peps",BigDecimal.valueOf(14.4));
		productEntity.ifPresent(System.out::println);
	}
}
