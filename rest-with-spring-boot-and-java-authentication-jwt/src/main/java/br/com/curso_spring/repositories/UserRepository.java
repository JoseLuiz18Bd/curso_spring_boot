package br.com.curso_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.curso_spring.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("SELECT u FROM User u WHERE u.userName =:userName") //REFERENCIA DE OBJETOS NÃO DE TABELA
	User findByUserName(@Param("userName") String userName);
}
