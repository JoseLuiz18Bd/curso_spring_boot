package br.com.curso_spring.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso_spring.exceptions.ResourceNotFoundException;
import br.com.curso_spring.model.Person;
import br.com.curso_spring.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll(){
		
		logger.info("Finding All Person!!!");
		
		return repository.findAll();
	}
	
	public  Person findById(Long id) {
		
		logger.info("Finding One Person!!!");
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!!"));
	}
	
	public  Person createPerson(Person person) {
			
		logger.info("Creating One Person!!!");
		
		return repository.save(person);
			
	}

	
	public  Person updatePerson(Person person) {
		
		logger.info("Updating One Person!!!");
		
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);		
	}
	
	public  void deletePerson(Long id) {
			
		logger.info("Deleting One Person!!!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!!"));
		repository.delete(entity);
	}
}