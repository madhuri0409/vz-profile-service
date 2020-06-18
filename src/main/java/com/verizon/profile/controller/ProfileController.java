package com.verizon.profile.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.verizon.profile.component.CustomerComponent;
import com.verizon.profile.model.CustomerDetails;
import com.verizon.profile.model.EquipmentDetails;
import com.verizon.profile.model.Profile;

@RestController
@EnableCircuitBreaker
public class ProfileController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${equipment.service.uri}")
	private String equipmentServiceUri;
	
	@Autowired
	private CustomerComponent customerComponent;

	@GetMapping("/getProfileById")
	public Profile getCustomerById(@RequestParam(value = "id") Integer id) {
		LOGGER.info("In Profile Service : Fetching  Profile Details for Customer Id {}",id);
		Profile profile = new Profile();
		CustomerDetails customerDetails = customerComponent.getCustomerDetails(id);
		List<EquipmentDetails> equipmentDetailsList = restTemplate.getForObject(equipmentServiceUri + "=" + id,
				List.class);
		profile.setCustomerDetails(customerDetails);
		profile.setEquipmentDetailsList(equipmentDetailsList);
		return profile;
	}

}
