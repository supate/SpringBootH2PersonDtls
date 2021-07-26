package com.spatel.jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spatel.jpa.entity.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Integer>{

}
