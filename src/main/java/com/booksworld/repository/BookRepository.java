package com.booksworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.booksworld.dao.Book.Status;

import com.booksworld.dao.Book;



@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
	
	@Query( value = "select * from BOOK  where BOOK.BOOK_NAME = :name",
			 nativeQuery = true)
	 List<Book> findBybook_name(@Param("name") String name) ;
	@Query( value = "select * from BOOK  where BOOK.USER_ID = :userid and BOOK.BOOK_STATUS = :status",
			 nativeQuery = true)
	 List<Book> findByUserid_and_status(@Param("userid") long userid, @Param("userid") String status) ;

	@Query( value = "select * from BOOK where BOOK.USER_ID = :userid",
			 nativeQuery = true)
	 List<Book> findByUserid(@Param("userid") long userid) ;

//	@Query( value = "select * from transaction inner JOIN book ON transaction.book_id=book.id where transaction.status='booked' and user_id=user",nativeQuery = true)
}
