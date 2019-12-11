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

import com.booksworld.service.TransactionService;

@RestController
public class TransactionRestController {

	@Autowired
	private TransactionService transactionService;
	
	@PutMapping("/api/book/initiateReturn/{bookId}/{userId")
	public Transaction returnBook(@RequestBody Transaction trans, @PathVariable(name = "bookId") Long bookId, 
			@PathVariable(name = "userId") Long userId) {
		Transaction existing_trans = transactionService.getTransaction(bookId);
		if (existing_trans != null) {
			trans.setBookId(existing_trans.getBookId());
			transactionService.returnBook(trans, bookId, userId);
		}
		return existing_trans;
	}
	
	
	
}
