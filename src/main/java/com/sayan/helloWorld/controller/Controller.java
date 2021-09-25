package com.sayan.helloWorld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mainController")
public class Controller {

	@Value("${helloWorld.property.text:default}")
	private String property;

	@GetMapping(value = "/")
	public String helloWorldApi() {
		return property;
	}
}
