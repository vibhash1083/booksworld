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
	
	private TransactionService transactionService;
	private BookService bookService;

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping("/api/transaction")
	public List<Transaction> Transactions() {
		List<Transaction> trans = transactionService.retrieveTransaction();
		return trans;
	}

	@GetMapping("/api/trans/{transId}")
	public Transaction getTrans(@PathVariable(name = "transId") Long transId) {
		return transactionService.getTransaction(transId);
	}
	
	@PostMapping(path = "/api/trans", consumes = "application/json", produces = "application/json")
	public void saveTrans(@RequestBody Transaction trans) {
		transactionService.saveTransaction(trans);
		System.out.println("Transaction Saved Successfully");
	}
	
	@PutMapping("/api/book/request/{bookId}/{userId}")
	public Book requestBook(@RequestBody Book book, @PathVariable(name = "bookId") Long bookId,@PathVariable(name = "userId") Long userId) {
		Book existing_book = bookService.getBook(bookId);
		if (existing_book != null) {
			transactionService.requestBook(existing_book, bookId, userId);
			System.out.println("Book is Requested");
		}
		return existing_book;
	}
	@PutMapping("/api/book/lend/{bookId}/{userId}")
	public void lendBook(@RequestBody Book book, @PathVariable(name = "bookId") Long bookId,@PathVariable(name = "userId") Long userId) {
		Book existing_book = bookService.getBook(bookId);
		if (existing_book != null) {
			transactionService.lendBook(existing_book, bookId, userId);
			System.out.println("Book is issued to you ");
		}
	}

	
	@PutMapping("/api/book/initiateReturn/{bookId}")
	public Transaction initiateReturnBook(@RequestBody Transaction trans, @PathVariable(name = "bookId") Long bookId) {
		Book book = new Book();
		Transaction existing_trans = transactionService.getTransaction(bookId);
		if (existing_trans != null) {
			trans.setBookId(existing_trans.getBookId());
			transactionService.initiateReturnBook(book, trans, bookId);
			System.out.println("Now you can return the book");
		}
		return existing_trans;
	}
	
	@PutMapping("/api/book/return/{bookId}")
	public Transaction returnBook(@RequestBody Transaction trans, @PathVariable(name = "bookId") Long bookId) {
		Book book = new Book();
		Transaction existing_trans = transactionService.getTransaction(bookId);
		if (existing_trans != null) {
			trans.setBookId(existing_trans.getBookId());
			transactionService.returnBook(book, trans, bookId);
			System.out.println("Book Returned Successfully");
		}
		return existing_trans;
	}
	
	
	
}
