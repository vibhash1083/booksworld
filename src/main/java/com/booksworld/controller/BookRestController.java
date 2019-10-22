package com.booksworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booksworld.dao.Book;
import com.booksworld.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	private BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/api/books")
	public List<Book> Books() {
		List<Book> books = bookService.retrieveBooks();
		return books;
	}

	@PostMapping(path = "/api/books", consumes = "application/json", produces = "application/json")
	public void saveBook(@RequestBody Book book) {
		System.out.println(book.getName());
		System.out.println(book.getAuthor());
		bookService.saveBook(book);
		System.out.println("Book Saved Successfully");
	}
}
