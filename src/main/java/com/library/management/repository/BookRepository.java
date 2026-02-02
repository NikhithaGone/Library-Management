package com.library.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.management.DTO.CreateBookRequest;
import com.library.management.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Query("select b from Book b where id = :id")
	Book getById(@Param("id") CreateBookRequest id);
	

}
