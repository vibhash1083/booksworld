package com.booksworld.service;

import java.util.List;

import com.booksworld.dao.Book;
import com.booksworld.dao.Transaction;
import com.booksworld.dao.Book;

public interface TransactionService {

	public Transaction getTransaction(Long bookId);

	public void returnBook(Book book, Transaction trans, Long bookId);

	public void initiateReturnBook(Book book, Transaction trans, Long bookId);

	public void lendBook(Book existing_book, Long bookId, Long userId);

	public void saveTransaction(Transaction trans);

	public void requestBook(Book existing_book, Long bookId, Long userId);

	public List<Transaction> retrieveTransaction();
	
}

