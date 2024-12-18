//package br.com.curso_spring.controllers;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.curso_spring.data.vo.v1.BookVO;
//import br.com.curso_spring.services.BookServices;
//import br.com.curso_spring.util.MediaType;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.tags.Tag;
//
//@RestController
//@RequestMapping("/api/book/v1")
//@Tag(name = "Book", description = "Endpoints for Managing Book")
//public class BookController {
//	
//	@Autowired
//	private BookServices service;
//	
//	@GetMapping(
//		produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
//	@Operation(summary = "Finds all Book", description = "Finds all Book",
//		tags = {"Book"},
//		responses = {
//			@ApiResponse(description = "Success", responseCode = "200",
//				content = {
//					@Content(
//						mediaType = "application/json",
//						array = @ArraySchema(schema = @Schema(implementation = BookVO.class))
//					)
//				}),
//			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
//			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
//			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
//			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
//		}
//	)
//	public List<BookVO> findAll() {
//		return service.findAll();
//	}
//	
//	@GetMapping(value = "/{id}",
//		produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML  })
//	@Operation(summary = "Finds a Book", description = "Finds a Book",
//		tags = {"Book"},
//		responses = {
//			@ApiResponse(description = "Success", responseCode = "200",
//				content = @Content(schema = @Schema(implementation = BookVO.class))
//			),
//			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
//			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
//			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
//			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
//			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
//		}
//	)
//	public BookVO findById(@PathVariable(value = "id") Long id) {
//		return service.findById(id);
//	}
//	
//	@PostMapping(
//		consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML  },
//		produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML  })
//	@Operation(summary = "Adds a new Book",
//		description = "Adds a new Book by passing in a JSON, XML or YML representation of the book!",
//		tags = {"Book"},
//		responses = {
//			@ApiResponse(description = "Success", responseCode = "200",
//				content = @Content(schema = @Schema(implementation = BookVO.class))
//			),
//			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
//			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
//			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
//		}
//	)
//	public BookVO create(@RequestBody BookVO book) {
//		return service.create(book);
//	}
//	
//	@PutMapping(
//		consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML  },
//		produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML  })
//	@Operation(summary = "Updates a Book",
//		description = "Updates a Book by passing in a JSON, XML or YML representation of the book!",
//		tags = {"Book"},
//		responses = {
//			@ApiResponse(description = "Updated", responseCode = "200",
//				content = @Content(schema = @Schema(implementation = BookVO.class))
//			),
//			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
//			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
//			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
//			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
//		}
//	)
//	public BookVO update(@RequestBody BookVO book) {
//		return service.update(book);
//	}
//	
//	
//	@DeleteMapping(value = "/{id}")
//	@Operation(summary = "Deletes a Book",
//		description = "Deletes a Book by passing in a JSON, XML or YML representation of the book!",
//		tags = {"Book"},
//		responses = {
//			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
//			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
//			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
//			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
//			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
//		}
//	)
//	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
//}
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

import br.com.curso_spring.data.vo.v1.BookVO;
import br.com.curso_spring.services.BookServices;
import br.com.curso_spring.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

//@CrossOrigin   //permitir cors para toda a aplicação atravez do controller
@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "Book", description = "Endpoints for Managing Books") // Customização de documentação SWAGGER
public class BookController {
	@Autowired
	private BookServices service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	// Customização de documentação SWAGGER
	@Operation(summary = "Find All Books", description = "Find All Books",
		tags = {"Book"},
		responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
				content = {
					@Content(
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = BookVO.class))
					)
			    }),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public List<BookVO> findAll(){
	
		return service.findAll();
	}
	@CrossOrigin( origins = {"http://localhost:8080", "http://localhost:3000"}) // permitir cors em determinado endpoint
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	// Customização de documentação SWAGGER
	@Operation(summary = "Finds a Book", description = "Finds a Book",
		tags = {"Book"}, 
		responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
				content = @Content(schema = @Schema(implementation = BookVO.class))
			),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public BookVO findById(@PathVariable(value = "id") Long id) throws Exception{
	
		return service.findById(id);
	}
	
	@CrossOrigin( origins = {"http://localhost:8080", "http://localhost:3000"})  // permitir cors em determinado endpoint
	@PostMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
				 consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	// Customização de documentação SWAGGER
	@Operation(summary = "Adds a new book", 
		description = "Adds a new book by passing in a JSON, XML OR YML",
		tags = {"Book"}, 
		responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
				content = @Content(schema = @Schema(implementation = BookVO.class))
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public BookVO addBook(@RequestBody BookVO book) {
	
		return service.addBook(book);
	}
	
	@PutMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
			    consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Updates a book", 
		description = "Updates a book by passing in a JSON, XML OR YML",
		tags = {"Book"}, 
		responses = {
			@ApiResponse(description = "Updated", responseCode = "200", 
				content = @Content(schema = @Schema(implementation = BookVO.class))
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public BookVO updateBook(@RequestBody BookVO book) {

		return service.updateBook(book);
	}
	
	@DeleteMapping(value="/{id}")
	@Operation(summary = "Deletes a book", 
		description = "Deletes a book by passing in a JSON, XML OR YML",
		tags = {"Book"}, 
		responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long id) {
		service.deleteBook(id);
		return ResponseEntity.noContent().build();
	}
	
}