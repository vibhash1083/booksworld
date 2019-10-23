package com.booksworld.service;

import java.util.List;

import com.booksworld.dao.Book;

public interface BookService {
	 public List<Book> retrieveBooks();
	 
	 public Book getBook(Long bookId);
	 
	 public void saveBook(Book book);
	 
	 public void deleteBook(Long bookId);
	 
	 public void updateBook(Book book);
}
