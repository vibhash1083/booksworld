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

import com.booksworld.dao.Transaction;
import com.booksworld.dao.Transaction.Status;
import com.booksworld.dao.Book;
import com.booksworld.dao.Book.BStatus;
import com.booksworld.service.BookService;
import com.booksworld.service.TransactionService;

@RestController
public class TransactionRestController {
	
	private TransactionService transactionService1;
	private BookService bookService;

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService1 = transactionService;
	}
	
	
	@PutMapping("/api/book/request/{bookId}/{userId}")
	public Book requestBook(@RequestBody Book book, @PathVariable(name = "bookId") Long bookId,@PathVariable(name = "userId") Long userId) {
		Book existing_book = bookService.getBook(bookId);
		Transaction trans_book = new Transaction();
		if (existing_book != null) {
			if(existing_book.getBStatus().equals("Available")) {
				trans_book.setBookId(bookId);
				trans_book.setOwnerId(userId);
				trans_book.setStatus(Status.AVAILABLE);
			}
		}
		transactionService1.saveTransaction(trans_book);
		return existing_book;
	}
	@PutMapping("/api/book/lend/{bookId}/{userId}")
	public void lendBook(@RequestBody Book book, @PathVariable(name = "bookId") Long bookId,@PathVariable(name = "userId") Long userId) {
		Book existing_book = bookService.getBook(bookId);
		Transaction trans_book = new Transaction();
		if (existing_book != null) {
			if(existing_book.getBStatus().toString().equals("AVAILABLE") ||existing_book.getBStatus().toString().equals("INITIATE_REQUEST") ) {
				trans_book.setBookId(bookId);
				trans_book.setOwnerId(userId);
				trans_book.setStatus(Status.AVAILABLE);
				existing_book.setBStatus(BStatus.AVAILABLE);
			}
		}
		
		bookService.saveBook(existing_book);
		transactionService1.saveTransaction(trans_book);

	}

	@Autowired
	private TransactionService transactionService;
	
	@PutMapping("/api/book/initiateReturn/{bookId}")
	public Transaction initiateReturnBook(@RequestBody Transaction trans, @PathVariable(name = "bookId") Long bookId) {
		Book book = new Book();
		Transaction existing_trans = transactionService1.getTransaction(bookId);
		if (existing_trans != null) {
			trans.setBookId(existing_trans.getBookId());
			transactionService1.initiateReturnBook(book, trans, bookId);
		}
		return existing_trans;
	}
	
	@PutMapping("/api/book/return/{bookId}")
	public Transaction returnBook(@RequestBody Transaction trans, @PathVariable(name = "bookId") Long bookId) {
		Book book = new Book();
		Transaction existing_trans = transactionService1.getTransaction(bookId);
		if (existing_trans != null) {
			trans.setBookId(existing_trans.getBookId());
			transactionService1.returnBook(book, trans, bookId);
		}
		return existing_trans;
	}
	
	
	
}
