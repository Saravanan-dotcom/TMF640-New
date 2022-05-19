package com.service.Activate.ServiceImpl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

@Component
public class FormURLUtil {
	

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Value("${pivotal.persistenceservice.name}")
	protected String persistenceservice;
	
	public URI formURL() {
		ServiceInstance serviceInstance = loadBalancerClient.choose(persistenceservice);
		URI uri = URI.create(String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()));
		return uri;
	}

}
