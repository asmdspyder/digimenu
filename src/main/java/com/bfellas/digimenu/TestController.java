package com.bfellas.digimenu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	@RequestMapping("/")
	public String test() {
		return "Application running fine";
	}
}
