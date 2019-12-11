package com.booksworld.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.booksworld.dao.Book;
import com.booksworld.dao.Transaction;
import com.booksworld.service.BookService;
import com.booksworld.service.TransactionService;

public class TransactionRestController {
	
	private TransactionService transactionService;
	private BookService bookService;

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	
	@PutMapping("/api/book/request/{bookId}/{userId}")
	public Book requestBook(@RequestBody Book book, @PathVariable(name = "bookId") Long bookId,@PathVariable(name = "userId") Long userId) {
		Book existing_book = bookService.getBook(bookId);
		Transaction trans_book = new Transaction();
		if (existing_book != null) {
			if(existing_book.getStatus().equals("Available")) {
				trans_book.setBookId(bookId);
				trans_book.setOwnerId(userId);
				trans_book.setStatus();
			}
		}
		transactionService.saveTransaction(trans_book);
		return existing_book;
	}
	@PutMapping("/api/book/lend/{bookId}/{userId}")
	public void lendBook(@RequestBody Book book, @PathVariable(name = "bookId") Long bookId,@PathVariable(name = "userId") Long userId) {
		Book existing_book = bookService.getBook(bookId);
		Transaction trans_book = new Transaction();
		if (existing_book != null) {
			if(existing_book.getStatus().toString().equals("AVAILABLE") ||existing_book.getStatus().toString().equals("INITIATE_REQUEST") ) {
				trans_book.setBookId(bookId);
				trans_book.setOwnerId(userId);
				trans_book.setStatus("LENDED");
				existing_book.setStatus("LENDED");
			}
		}
		
		bookService.saveBook(existing_book);
		transactionService.saveTransaction(trans_book);

	}

}
