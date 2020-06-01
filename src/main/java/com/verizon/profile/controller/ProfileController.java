package com.verizon.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.verizon.profile.model.CustomerDetails;
import com.verizon.profile.model.EquipmentDetails;
import com.verizon.profile.model.Profile;

@RestController
public class ProfileController {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${customer.service.uri}")
	private String customerServiceUri;

	@Value("${equipment.service.uri}")
	private String equipmentServiceUri;

	@GetMapping("/getProfileById")
	public Profile getCustomerById(@RequestParam(value = "id") Integer id) {
		Profile profile = new Profile();
		CustomerDetails customerDetails = restTemplate.getForObject(customerServiceUri+ "=" + id,
				CustomerDetails.class);
		List<EquipmentDetails> equipmentDetailsList = restTemplate.getForObject(equipmentServiceUri+ "=" + id,
				List.class);
		profile.setCustomerDetails(customerDetails);
		profile.setEquipmentDetailsList(equipmentDetailsList);
		return profile;
	}

}
