package com.spatel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	
 @GetMapping("/healthCheck")
 public String checkService() {
	 return "Up";
 }
 
 @PostMapping("/service1")
 public String getService() {
	 return "";
 }
}
