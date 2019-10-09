package com.jtriemstra.test.spring.boot219test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@RequestMapping("/sample")
	public String sampleAction() {
		return "This is a controller action";
	}
}
