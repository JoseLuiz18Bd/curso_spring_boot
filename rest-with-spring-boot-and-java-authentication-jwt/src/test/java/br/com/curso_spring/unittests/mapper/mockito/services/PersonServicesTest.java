package br.com.curso_spring.unittests.mapper.mockito.services;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.curso_spring.data.vo.v1.security.PersonVO;
import br.com.curso_spring.exceptions.RequiredObjectIsNullException;
import br.com.curso_spring.model.Person;
import br.com.curso_spring.repositories.PersonRepository;
import br.com.curso_spring.services.PersonServices;
import br.com.curso_spring.unittests.mapper.mocks.MockPerson;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {

	MockPerson input;

	@InjectMocks
	private PersonServices service;

	@Mock
	PersonRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		input = new MockPerson();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() {

		Person entity = input.mockEntity(1);
		entity.setId(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));

		var result = service.findById(1L);

		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

	@Test
	void testCreatePerson() {

		Person entity = input.mockEntity(1);
		entity.setId(1L);

		Person persisted = entity;
		persisted.setId(1L);

		PersonVO vo = input.mockVO(1);
		vo.setKey(1L);


		when(repository.save(any(Person.class))).thenReturn(persisted);

		var result = service.createPerson(vo);

		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

	@Test
	void testCreatePersonWithNullObject() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.createPerson(null);
		});

		String expectedMessage = "It isn't allowed to persist a null object!";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	void testUpdatePerson() {
		Person entity = input.mockEntity(1);
		entity.setId(1L);

		Person persisted = entity;
		persisted.setId(1L);

		PersonVO vo = input.mockVO(1);
		vo.setKey(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);

		var result = service.updatePerson(vo);

		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

	@Test
	void testUpdatePersonWithNullObject() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.updatePerson(null);
		});

		String expectedMessage = "It isn't allowed to persist a null object!";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}


	@Test
	void testFindAll() {

		List<Person> listEntity = input.mockEntityList();

		when(repository.findAll()).thenReturn(listEntity);

		var people = service.findAll();

		assertNotNull(people);
		assertEquals(14, people.size());

		var peopleOne = people.get(1);

		assertNotNull(peopleOne);
		assertNotNull(peopleOne.getKey());
		assertNotNull(peopleOne.getLinks());
		assertTrue(peopleOne.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", peopleOne.getAddress());
		assertEquals("First Name Test1", peopleOne.getFirstName());
		assertEquals("Last Name Test1", peopleOne.getLastName());
		assertEquals("Female", peopleOne.getGender());

		var peopleSix = people.get(6);

		assertNotNull(peopleSix);
		assertNotNull(peopleSix.getKey());
		assertNotNull(peopleSix.getLinks());
		assertTrue(peopleSix.toString().contains("links: [</api/person/v1/6>;rel=\"self\"]"));
		assertEquals("Addres Test6", peopleSix.getAddress());
		assertEquals("First Name Test6", peopleSix.getFirstName());
		assertEquals("Last Name Test6", peopleSix.getLastName());
		assertEquals("Male", peopleSix.getGender());

		var peopleNine = people.get(9);

		assertNotNull(peopleNine);
		assertNotNull(peopleNine.getKey());
		assertNotNull(peopleNine.getLinks());
		assertTrue(peopleNine.toString().contains("links: [</api/person/v1/9>;rel=\"self\"]"));
		assertEquals("Addres Test9", peopleNine.getAddress());
		assertEquals("First Name Test9", peopleNine.getFirstName());
		assertEquals("Last Name Test9", peopleNine.getLastName());
		assertEquals("Female", peopleNine.getGender());
	}

	@Test
	void testDeletePerson() {
		Person entity = input.mockEntity(1);
		entity.setId(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));

		service.deletePerson(1L);
	}

}
