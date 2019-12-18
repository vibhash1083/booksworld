package com.booksworld.service;

import java.util.List;

import com.booksworld.dao.Book;
import com.booksworld.dao.Transaction;

public interface BookService {
	 public List<Book> retrieveBooks();
	 
	 public List<Book> getRequestedBooks(long userId, String status);
	 
	 public List<Book> getMyBooks(long userId);
	 
	 public Book getBook(Long bookId);
	 
	 public void saveBook(Book book);
	 
	 public void deleteBook(Long bookId);
	 
	 public void updateBook(Book book);
	 
	 public List<Book> searchBookName(String book_name);

}
