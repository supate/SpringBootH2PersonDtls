package com.spatel.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spatel.model.FullName;

import net.minidev.json.JSONObject;

@RestController
public class SeriveOneController {
public static String serviceTwoUrl = "http://localhost:8081/hello";
public static String serviceThreeUrl = "http://localhost:8082/hello";
	
 @GetMapping("/healthCheck")
 public String checkService() {
	 return "Up";
 }
 
 @PostMapping("/hello")
 public String sayHello(@RequestBody FullName fullName) {
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	
	String response1 = restTemplate.getForObject(serviceTwoUrl, String.class);
	
	JSONObject nameJsonObj = new JSONObject();
	nameJsonObj.put("name", fullName.getName());
	nameJsonObj.put("surName", fullName.getSurName());
	HttpEntity<String> request = new HttpEntity<String>(nameJsonObj.toString(), headers);
	String response2 = restTemplate.postForObject(serviceThreeUrl, request, String.class);
    
	 return response1 + " " + response2; 
  }
 
}
