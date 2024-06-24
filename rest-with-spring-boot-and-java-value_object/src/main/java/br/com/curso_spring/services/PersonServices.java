package br.com.curso_spring.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso_spring.data.vo.v1.PersonVO;
import br.com.curso_spring.exceptions.ResourceNotFoundException;
import br.com.curso_spring.mapper.DozerMapper;
import br.com.curso_spring.model.Person;
import br.com.curso_spring.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<PersonVO> findAll(){
		
		logger.info("Finding All Persons!!!");
		
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public  PersonVO findById(Long id) {
		
		logger.info("Finding One Person!!!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!!"));
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public  PersonVO createPerson(PersonVO person) {
			
		logger.info("Creating One Person!!!");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		
		return vo;
			
	}

	
	public  PersonVO updatePerson(PersonVO person) {
		
		logger.info("Updating One Person!!!");
		
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		
		return vo;
			
	}
	
	public  void deletePerson(Long id) {
			
		logger.info("Deleting One Person!!!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!!"));
		repository.delete(entity);
	}
}