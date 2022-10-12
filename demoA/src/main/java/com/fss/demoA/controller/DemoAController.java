package com.fss.demoA.controller;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/demoa")
@Slf4j
public class DemoAController {
	static String H="-H";
	@Autowired
    private RestTemplate restTemplate;
	  @GetMapping("/message")
	    public String getMessage() {
	      log.info("Inside getMessage method of DemoAController");
	        Date createDated=new Date();
	        String msg="Hi !! WelCome to DemoA"+": Date:"+createDated.toString();
	        return msg;
	    }
	  
	
	  @PostMapping(value = "/get_user")
	    public String getPostResponse(){
	        HttpHeaders headers=new HttpHeaders();
	        headers.set("Content-type","application/json");
	        headers.set("Ce-id","1");

	        headers.set("Ce-source","fss-example");
	   

	        headers.set("Ce-type","fss.myapplication");
	        headers.set("Ce-specversion","1.0");

	        headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
	        String body="{\"username\": \"javadeveloper\", \"firstName\": \"venu\", \"lastName\": \"global\", \"age\": 23}";
	        HttpEntity<String> entity=new HttpEntity<String>(body, headers);
	        
	        return restTemplate.exchange("http://127.0.0.1:8100/send_user",HttpMethod.POST,entity,String.class).getBody();
	    }
	  
	  @GetMapping(value = "/get_user")
	    public String getPostResponse2(){
	        HttpHeaders headers=new HttpHeaders();
	        headers.set("Content-type","application/json");
	        headers.set("Ce-id","1");

	        headers.set("Ce-source","fss-example");
	   

	        headers.set("Ce-type","fss.myapplication");
	        headers.set("Ce-specversion","1.0");

	        headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
	        String body="{\"username\": \"javadeveloper\", \"firstName\": \"venu\", \"lastName\": \"global\", \"age\": 23}";
	        HttpEntity<String> entity=new HttpEntity<String>(body, headers);
	        
	        return restTemplate.exchange("http://127.0.0.1:8100/send_user",HttpMethod.POST,entity,String.class).getBody();
	    }

	  
//	  
//	  @GetMapping(value = "/get_user")
//	    public String getPostResponse(){
//	        HttpHeaders headers=new HttpHeaders();
//	        headers.set(H+"Content-type","application/json");
//	        headers.set(H+"Ce-id","1");
//
//	        headers.set(H+"Ce-source","fss-example");
//	   
//
//	        headers.set(H+"Ce-type","fss.myapplication");
//	        headers.set(H+"Ce-specversion","1.0");
//
//	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	        String body="{\"username\": \"javadeveloper\", \"firstName\": \"venu\", \"lastName\": \"global\", \"age\": 23}";
//	        HttpEntity<String> entity=new HttpEntity<String>(body, headers);
//	        
//	        return restTemplate.exchange("http://localhost:8100/send_user",HttpMethod.POST,entity,String.class).getBody();
//	    }
	 
}
