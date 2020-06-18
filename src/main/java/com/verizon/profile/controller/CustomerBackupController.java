package com.verizon.profile.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.profile.model.CustomerDetails;

@RestController
public class CustomerBackupController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerBackupController.class);

	@GetMapping("/customers")
	public CustomerDetails getCustomers() {
		LOGGER.info("In Customer Service : Fetching Customer Details Started for Customer Id ");
		return new CustomerDetails();
	}

}
