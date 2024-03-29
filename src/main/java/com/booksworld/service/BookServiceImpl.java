package com.booksworld.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booksworld.dao.Book;
import com.booksworld.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> retrieveBooks() {
		  List<Book> books = bookRepository.findAll();
		  return books;
	}
	
	@Override
	public List<Book> getRequestedBooks(long userID, String status) {
		  List<Book> books = bookRepository.findByUserid_and_status(userID,status);
		  return books;
	}
	
	@Override
	public List<Book> getMyBooks(long userID) {
		  List<Book> books = bookRepository.findByUserid(userID);
		  return books;
	}
	
	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);

	}

	@Override
	public Book getBook(Long bookId) {
		  Optional<Book> optBook = bookRepository.findById(bookId);
		  return optBook.get();
	}

	@Override
	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
		
	}
	
	@Override
	public List<Book> searchBookName(String book_name) {
		List<Book> booksNameSearched = bookRepository.findBybook_name(book_name);
		return booksNameSearched;
	}

}
