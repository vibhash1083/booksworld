package com.booksworld.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksworld.dao.Book;
import com.booksworld.dao.Book.BStatus;
import com.booksworld.dao.Transaction;
import com.booksworld.dao.Transaction.Status;
import com.booksworld.dao.User;
import com.booksworld.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transRepository;
	
	private UserService userService;

	
	@Override
	public Transaction getTransaction(Long bookId) {
		Optional<Transaction> optTrans = transRepository.findById(bookId);
		return optTrans.get();
	}

	
	@Override
	public void initiateReturnBook(Book book, Transaction trans, Long bookId) {
		if(trans.getStatus().toString().equals("INITIATE_REQUEST") ) {
//			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			System.out.println(dtf.format(now)); 
//			DateUtils.add(now, 30);
			trans.setEstimatedReturnDate(dtf.format(now));
			trans.setStatus(Status.INITIATE_REQUEST);
//			book.setStatus(Status.AVAILABLE);
		}
		
	}


	@Override
	public void saveTransaction(Transaction trans) {
		transRepository.save(trans);
		
	}


	@Override
	public void requestBook(Book existing_book, Long bookId, Long userId) {
		Transaction trans_book = new Transaction();
		User user = userService.getUser(userId);
		if(existing_book.getBStatus().equals("Available")) {
			trans_book.setBookId(existing_book);
			trans_book.setOwnerId(user);
			trans_book.setStatus(Status.REQUESTED);
		}
		
	}
	
	@Override
	public void lendBook(Book existing_book, Long bookId, Long userId) {
		Transaction trans_book = new Transaction();
		User user = userService.getUser(userId);
		if (existing_book != null) {
			if(existing_book.getBStatus().toString().equals("AVAILABLE") ||existing_book.getBStatus().toString().equals("INITIATE_REQUEST") ) {
				trans_book.setBookId(existing_book);
				trans_book.setOwnerId(user);
				trans_book.setStatus(Status.LENT);
				existing_book.setBStatus(BStatus.LENT);
			}
	}
	}
	
	@Override
	public void returnBook(Book book, Transaction trans, Long bookId) {
		if(trans.getStatus().toString().equals("INITIATE_REQUEST") ) {
//			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
//			System.out.println(dtf.format(now)); 
			trans.setActualReturnDate(dtf.format(now));
			trans.setStatus(Status.AVAILABLE);
			book.setBStatus(BStatus.AVAILABLE);
		}
	}


	@Override
	public List<Transaction> retrieveTransaction() {
		List<Transaction> trans = transRepository.findAll();
		  return trans;
	}
	

}

