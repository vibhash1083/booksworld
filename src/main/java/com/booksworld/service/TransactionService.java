package com.booksworld.service;

import java.util.List;

import com.booksworld.dao.Transaction;

public interface TransactionService {

	public Transaction getTransaction(Long bookId);

	public void returnBook(Transaction trans);

}

