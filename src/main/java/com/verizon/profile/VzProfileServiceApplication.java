package com.verizon.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/* Annotation to enable a DiscoveryClient implementation. */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class VzProfileServiceApplication {

	/*
	 * @bean annotation is used to represent any class or method as logical unit of
	 * reusable code in an application
	 */
	/*
	 * @LoadBalanced indicates the Rest template should be based on Client Side Load
	 * Balancing using Ribbon and checks Eureka server for resolving the service
	 * name to host/port.
	 */

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(VzProfileServiceApplication.class, args);
	}

}
