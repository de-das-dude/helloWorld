package com.sayan.helloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/mainController")
public class Controller {
	@GetMapping(value = "/{text}")
	public String helloWorldApi(@PathVariable("text") String text)
	{
		return text;
	}
}
