package com.example.productservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ProductServiceApplication {

	
	private static final Logger log=LoggerFactory.getLogger(ProductServiceApplication.class);
	
	@Autowired
	private RestTemplate template; 
	
	@GetMapping("/getDiscount")
	public String discount()
	{
		log.info("discount service called...");
		return "added discount 15%";
	}
	
	@GetMapping("/payment")
	public String payment()
	{
		log.info("payment service is called with discount..");
		return template.getForObject("http://localhost:9090/getDiscount", String.class);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
