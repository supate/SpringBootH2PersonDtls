package com.spatel.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spatel.jpa.entity.Person;
import com.spatel.jpa.repositories.PersonRepo;
import com.spatel.model.PersonDetailResponse;

@Service
public class PersonService {
	@Autowired
	PersonRepo personRepo;
	List<PersonDetailResponse> respList;
	
	public Person savePerson(Person person) {
		personRepo.save(person);
		return person;
	}
	
	public List<PersonDetailResponse> getPersonsDtls(){
		populateParentIdParentMap();
		return respList;
	}

	public void populateParentIdParentMap() {
		List<Person> persons = new ArrayList<>();
		respList = new ArrayList<>();
		personRepo.findAll().forEach(s -> persons.add(s));;
		for (Person person : persons) {
			PersonDetailResponse personResDtl = new PersonDetailResponse(person.getId(), person.getName());
			if(person.getParentId() == 0) {
				respList.add(personResDtl);
			}else {
				PersonDetailResponse parentDtl = getParentDetails(person.getParentId());
				if(parentDtl.getSubClasses() == null) 
					parentDtl.setSubClasses(new ArrayList<>());
				parentDtl.getSubClasses().add(personResDtl);
			}
		}
	}

	private PersonDetailResponse getParentDetails(Integer parentId) {
		PersonDetailResponse parentDtl = null;
		Queue<PersonDetailResponse> queue = new LinkedList<>();
		for(PersonDetailResponse res : respList) {
			if(res.getId().equals(parentId)) {
				parentDtl = res;
				break;
			}
			queue.add(res);
		}
		
		if(parentDtl != null) {
			return parentDtl;
		}else {
			while(!queue.isEmpty()) {
				PersonDetailResponse temp = queue.poll();
				if(temp.getId().equals(parentId)) {
					parentDtl = temp;
					break;
				}if(temp.getSubClasses() != null) {
					queue.addAll(temp.getSubClasses());
				}
			}
		}
		
		return parentDtl;
	}
}
