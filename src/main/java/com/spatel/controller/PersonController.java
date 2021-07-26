package com.spatel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spatel.jpa.entity.Person;
import com.spatel.model.PersonDetailResponse;
import com.spatel.services.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService svc;
	
	
	@PostMapping("/person")
	public Person savePersonDate(@RequestBody Person person) {
		return svc.savePerson(person);
	}
	
	@GetMapping("/persons")
	public List<PersonDetailResponse> getPersonRespDtls(){
		return svc.getPersonsDtls();
	}
}
