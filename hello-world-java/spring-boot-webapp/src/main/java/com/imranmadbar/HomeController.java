package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping(value = "/home")
	public String helloMsg() {
		logger.info("Hello from Home Controller !");
		return "Hello from Home Controller !";
	}
	

	@GetMapping(value = "/")
	public String welcomeMsg() {
		logger.info("Welcome to JavaSpringBootWebApplication");
		return "Welcome to JavaSpringBootWebApplication";
	}

}