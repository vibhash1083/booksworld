package com.booksworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booksworld.dao.Book;
import com.booksworld.dao.Transaction;
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

	@GetMapping("/api/books/{bookId}")
	public Book getBook(@PathVariable(name = "bookId") Long bookId) {
		return bookService.getBook(bookId);
	}
	
	@PostMapping(path = "/api/book", consumes = "application/json", produces = "application/json")
	public void saveBook(@RequestBody Book book) {
		System.out.println(book.getName());
		System.out.println(book.getAuthor());
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
	@PutMapping("/api/book/request/{bookId}/{userId}")
	public Book requestBook(@RequestBody Book book, @PathVariable(name = "bookId") Long bookId,@PathVariable(name = "userId") Long userId) {
		Book existing_book = bookService.getBook(bookId);
		Transaction trans_book = new Transaction();
		if (existing_book != null) {
			if(existing_book.getStatus().equals("Available")) {
				trans_book.setBookId(bookId);
				trans_book.setOwnerId(ownerId);
				trans_book.setStatus("REQUESTED");
			}
		}
		return existing_book;
	}
	@PutMapping("/api/book/lend/{bookId}/{userId}")
	public void lendBook(@RequestBody Book book, @PathVariable(name = "bookId") Long bookId,@PathVariable(name = "userId") Long userId) {
		Book existing_book = bookService.getBook(bookId);
		Transaction trans_book = new Transaction();
		if (existing_book != null) {
			if(existing_book.getStatus().equals("AVAILABLE") ||existing_book.getStatus().equals("INITIATE_REQUEST") ) {
				trans_book.setBookId(bookId);
				trans_book.setOwnerId(userId);
				trans_book.setStatus("LENDED");
			}
		}
		return existing_book;
	}
}
