package com.npci.servicediscoveryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*//This acts like service discovery - server port =8761
 * We must use @EnableEurekaServer
 * we need to be  to desable the client feature like
 * register = false
*/

@SpringBootApplication
@EnableEurekaServer  // this provides all the features a service discovery must have
public class ServiceDiscoveryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryAppApplication.class, args);
	}

}
