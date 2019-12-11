package com.booksworld.service;

import java.util.List;

import com.booksworld.dao.Transaction;
import com.booksworld.dao.Book;

public interface TransactionService {

	public Transaction getTransaction(Long bookId);

	public void returnBook(Book book, Transaction trans, Long bookId);

	public void initiateReturnBook(Book book, Transaction trans, Long bookId);

	

}

