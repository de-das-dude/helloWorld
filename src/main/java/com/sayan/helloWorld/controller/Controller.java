package com.sayan.helloWorld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/mainController")
public class Controller {

	@Value("${helloWorld.property.text:false}")
	private boolean property;

	@GetMapping(value = "/doStuff")
	public boolean doStuff() {
		log.info("doing stuff");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8010/mainController/postHello";
		
		restTemplate.postForLocation(url, void.class);
		
		return property;
	}
	
	@PostMapping(value = "/postHello")
	public void postHello() {
		log.info("POSTED HELLO");
	}
	
}
