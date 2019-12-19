package com.booksworld.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TRANSACTION_HISTORY")
public class TrasactionHistory {

	@Id
	@Column(name = "TRANSACTION_HISTORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionHistoryId;
	
	@ManyToOne
	@JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "TRANSACTION_ID")
	private Transaction transactionId;
	
	@ManyToOne
	@JoinColumn(name = "BOOK_STATUS", referencedColumnName = "BOOK_STATUS")
	private Book bookStatus;
	
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.DATE)
    private Date createdDate;

	public Long getTransactionHistoryId() {
		return transactionHistoryId;
	}

	public void setTransactionHistoryId(Long transactionHistoryId) {
		this.transactionHistoryId = transactionHistoryId;
	}


	public Transaction getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Transaction transactionId) {
		this.transactionId = transactionId;
	}

	public void setTransactionHistoryId(long transactionHistoryId) {
		this.transactionHistoryId = transactionHistoryId;
	}

	public Book getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(Book bookStatus) {
		this.bookStatus = bookStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
