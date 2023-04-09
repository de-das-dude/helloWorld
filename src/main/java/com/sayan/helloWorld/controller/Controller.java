package com.sayan.helloWorld.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sayan.helloWorld.dto.Dto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/mainController")
public class Controller {

	@Value("${helloWorld.property.text:false}")
	private boolean property;

	@Value("${uri}")
	String uri;

	@GetMapping(value = "/doStuff")
	public boolean doStuff() {
		
		if(!property)
		{
			return property;
		}
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8010/mainController/postHello";

		System.out.println(uri);
		restTemplate.postForLocation(uri, void.class);
		
		restTemplate = new RestTemplate();
		url  = "http://localhost:8010/mainController/getDto";
		
		ResponseEntity<Dto[]> response = restTemplate.getForEntity(url, Dto[].class);
		Dto[] dtoList = response.getBody();
		
		log.info("**{}**{}**", dtoList[0].getMessage(), dtoList[1].getMessage());

		return property;
	}

	@PostMapping(value = "/postHello")
	public void postHello() {
		log.info("POSTED HELLO");
	}
	
	@GetMapping(value = "/getDto")
	public List<Dto> getDto(){
		List<Dto> dtoList = new ArrayList<>();
		dtoList.add(new Dto("hello"));
		dtoList.add(new Dto("world"));
		
		return dtoList;
	}

}
