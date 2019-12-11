package com.booksworld.service;

import java.util.List;

import com.booksworld.dao.Book;
import com.booksworld.dao.Transaction;

public interface TransactionService {

	public Transaction getTransaction(Long bookId);

	public void returnBook(Transaction trans);

	public void saveTransaction(Transaction trans);

	public void requestBook(Book existing_book, Long bookId, Long userId);
	
}

