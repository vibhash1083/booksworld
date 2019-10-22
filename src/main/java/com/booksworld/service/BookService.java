package com.booksworld.service;

import java.util.List;

import com.booksworld.dao.Book;

public interface BookService {
	 public List<Book> retrieveBooks();
	 	 
	 public void saveBook(Book book);
}
