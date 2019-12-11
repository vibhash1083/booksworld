package com.booksworld.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksworld.dao.Book;
import com.booksworld.dao.Transaction;
import com.booksworld.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transRepository;

	
	@Override
	public Transaction getTransaction(Long bookId) {
		 Optional<Transaction> optTrans = transRepository.findById(bookId);
		return optTrans.get();
	}


	@Override
	public void returnBook(Transaction trans) {
				
	}


	@Override
	public void saveTransaction(Transaction trans) {
		transRepository.save(trans);
		
	}


	@Override
	public void requestBook(Book existing_book, Long bookId, Long userId) {
		Transaction trans_book = new Transaction();
		if(existing_book.getStatus().equals("Available")) {
			trans_book.setBookId(bookId);
			trans_book.setOwnerId(userId);
			trans_book.setStatus();
		}
		
	}
	
	

}

