package br.com.curso_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.curso_spring.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}