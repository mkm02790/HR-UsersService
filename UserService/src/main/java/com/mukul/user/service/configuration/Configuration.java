/**
 * 
 */
package com.mukul.user.service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author mukul
 *
 * 05-Dec-2022
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
		}	
}
