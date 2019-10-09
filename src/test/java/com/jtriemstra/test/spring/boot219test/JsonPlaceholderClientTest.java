package com.jtriemstra.test.spring.boot219test;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;      
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Boot219TestApplication.class)
public class JsonPlaceholderClientTest {

	@Autowired
	JsonPlaceholderClient realClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	private MockRestServiceServer mockServer;
	
	@Before
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }
	
	@Test                                                                                         
    public void checkMock() throws Exception {   
		String mockResponse = "{\"userId\":2,\"id\":2,\"title\":\"mocktitle\",\"body\":\"mockbody\"}";
		
        mockServer.expect(
        		ExpectedCount.once(), 
        		requestTo(new URI(JsonPlaceholderClient.DUMMY_URL))
        )
        .andExpect(method(HttpMethod.GET))
        .andRespond(withStatus(HttpStatus.OK)
        		  .contentType(MediaType.APPLICATION_JSON)
        		  .body(mockResponse)
        );                                   
                        
        JsonPlaceholderDto mockResponseObject = realClient.getSampleObject();
        
        mockServer.verify();
        
        Assert.assertEquals(2, mockResponseObject.getId());                                                        
    }
}
