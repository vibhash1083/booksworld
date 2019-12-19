package com.booksworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booksworld.dao.Book;

import com.booksworld.service.BookService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
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

	@GetMapping("/api/books/{bookId}")
	public Book getBook(@PathVariable(name = "bookId") Long bookId) {
		return bookService.getBook(bookId);
	}
	
	@GetMapping("/api/books/")
	public List<Book> getBooksUsingQueryParam(@RequestParam(name = "user_id") long userId, @RequestParam(name = "status", required = false) String status) {
		List<Book> bookRequests = bookService.getMyBooks(userId);
		if(status != null) {
			bookRequests = bookService.getRequestedBooks(userId,status.toUpperCase());
		}else {
			bookRequests = bookService.getMyBooks(userId);
		}
		return bookRequests;
	}

	
	@PostMapping(path = "/api/book", consumes = "application/json", produces = "application/json")
	public void saveBook(@RequestBody Book book) {
		System.out.println(book.getBookName());
		System.out.println(book.getBookAuthor());
		bookService.saveBook(book);
		System.out.println("Book Saved Successfully");
	}

	@DeleteMapping("/api/book/{bookId}")
	public void deleteBook(@PathVariable(name = "bookId") Long bookId) {
		bookService.deleteBook(bookId);
		System.out.println("Book Deleted Successfully");
	}

	@PutMapping("/api/book/{bookId}")
	public void updateBook(@RequestBody Book book, @PathVariable(name = "bookId") Long bookId) {
		Book existing_book = bookService.getBook(bookId);
		if (existing_book != null) {
			book.setBookId(existing_book.getBookId());
			bookService.updateBook(book);
		}
	}
	
	@GetMapping("/api/search/{bookName}")
	public List<Book> nameSearched(@PathVariable(name = "bookName") String bookName) {
		List<Book> books = bookService.searchBookName(bookName );
		return books;
	}
	
}
