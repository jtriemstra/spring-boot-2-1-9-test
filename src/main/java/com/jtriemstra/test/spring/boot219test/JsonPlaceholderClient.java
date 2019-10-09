package com.jtriemstra.test.spring.boot219test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonPlaceholderClient {
	
	public static final String DUMMY_URL = "https://jsonplaceholder.typicode.com/posts/1";
	
	@Autowired
	RestTemplate restTemplate;
	
	public JsonPlaceholderDto getSampleObject() {
		return restTemplate.getForObject(DUMMY_URL, JsonPlaceholderDto.class);
	}
}
