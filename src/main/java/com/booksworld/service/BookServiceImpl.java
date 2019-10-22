package com.booksworld.service;

import java.util.List;

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
	public void saveBook(Book book) {
		  bookRepository.save(book);

	}
}
