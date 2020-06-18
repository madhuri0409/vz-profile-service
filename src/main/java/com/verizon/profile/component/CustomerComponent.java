package com.verizon.profile.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.verizon.profile.controller.CustomerBackupController;
import com.verizon.profile.model.CustomerDetails;

@Component
@EnableDiscoveryClient
public class CustomerComponent {
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@Value("${customer.service.uri}")
	private String customerServiceUri;
	
	@Autowired
	private CustomerBackupController customerBackup;
	
	@HystrixCommand(fallbackMethod = "getFallBackCustomerDetails")
	public CustomerDetails getCustomerDetails(Integer id) {
		return restTemplate.getForObject(customerServiceUri + "=" + id, CustomerDetails.class);
	}

	public CustomerDetails getFallBackCustomerDetails(Integer id) {
		return restTemplate.getForObject("http://SERVICEPROFILE/customers", CustomerDetails.class);
	}

}
