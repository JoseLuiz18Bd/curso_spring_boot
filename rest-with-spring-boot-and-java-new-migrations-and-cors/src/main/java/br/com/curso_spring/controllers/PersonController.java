package br.com.curso_spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso_spring.data.vo.v1.PersonVO;
import br.com.curso_spring.services.PersonServices;
import br.com.curso_spring.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

//@CrossOrigin // permitir cors em toda a aplicação
@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for Managing Peoples") // Customização de documentação SWAGGER
public class PersonController {
	@Autowired
	private PersonServices service;
	
	@CrossOrigin( origins = {"http://localhost:8080", "http://localhost:3000"})  // permitir cors em determinado endpoint
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	// Customização de documentação SWAGGER
	@Operation(summary = "Finds a People", description = "Finds a People",
		tags = {"People"}, 
		responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
				content = @Content(schema = @Schema(implementation = PersonVO.class))
			),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception{
	
		return service.findById(id);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	// Customização de documentação SWAGGER
	@Operation(summary = "Find All People", description = "Find All People",
		tags = {"People"},
		responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
				content = {
					@Content(
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
					)
			    }),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public List<PersonVO> findAll(){
	
		return service.findAll();
	}
	
	@CrossOrigin( origins = {"http://localhost:8080", "http://localhost:3000"})  // permitir cors em determinado endpoint
	@PostMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
				 consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	// Customização de documentação SWAGGER
	@Operation(summary = "Adds a new Person", 
		description = "Adds a new Person by passing in a JSON, XML OR YML",
		tags = {"People"}, 
		responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
				content = @Content(schema = @Schema(implementation = PersonVO.class))
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public PersonVO createPerson(@RequestBody PersonVO person) {
	
		return service.createPerson(person);
	}
	
	@PutMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
			    consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Updates a Person", 
		description = "Updates a Person by passing in a JSON, XML OR YML",
		tags = {"People"}, 
		responses = {
			@ApiResponse(description = "Updated", responseCode = "200", 
				content = @Content(schema = @Schema(implementation = PersonVO.class))
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public PersonVO updatePerson(@RequestBody PersonVO person) {

		return service.updatePerson(person);
	}
	
	@DeleteMapping(value="/{id}")
	@Operation(summary = "Deletes a Person", 
		description = "Deletes a Person by passing in a JSON, XML OR YML",
		tags = {"People"}, 
		responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long id) {
		service.deletePerson(id);
		return ResponseEntity.noContent().build();
	}
	
}


