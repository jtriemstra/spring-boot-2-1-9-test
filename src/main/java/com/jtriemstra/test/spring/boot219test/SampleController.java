package com.jtriemstra.test.spring.boot219test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@Autowired
	SampleService service;
	
	@RequestMapping("/sample")
	public String sampleAction() {
		return "This is a controller action";
	}
	
	@RequestMapping("/fromService")
	public String fromService() {
		return service.sampleMethod();
	}
	
	@RequestMapping("/fromApi")
	public JsonPlaceholderDto fromApi() {
		return service.fromApi();
	}
}
