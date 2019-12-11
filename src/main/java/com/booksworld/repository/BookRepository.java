package com.booksworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booksworld.dao.Book;



@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
	
	@Query( value = "select * from BOOK  where BOOK.BOOK_NAME = :name",
			 nativeQuery = true)
	 List<Book> findBybook_name(@Param("name") String name) ;

}
