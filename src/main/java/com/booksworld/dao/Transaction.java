package com.booksworld.dao;

import com.booksworld.dao.Book;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Transaction")
public class Transaction {
	
	@Id
	@Column(name = "TRANSACTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	
	@OneToOne
	@JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID")
	private Book bookId;
	
	@Column(name = "EMP_NAME")
	private String empName;
	
	@Column(name = "EMP_EMAIL")
	private String empEmail;
	
	@Column(name = "EMP_ID")
	private String empID;
	
	@Column(name = "EMP_LOCATION")
	private String empLocation;
	
	@Column(name = "PICKUP_DATE")
	@Temporal(TemporalType.DATE)
	private Date pickupDate;
	
	@Column(name = "MESSAGE", columnDefinition="TEXT")
	private String message;
	
	@Column(name = "PICKUP_LOCATION")
	private String pickupLocation;
	
	@Column(name = "ESTIMATED_RETURN_DATE")
	@Temporal(TemporalType.DATE)
	private Date estimatedReturnDate;
	
	@OneToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "EMP_ID")
	private Book userId;
	
	@OneToOne
	@JoinColumn(name = "BOOK_STATUS", referencedColumnName = "BOOK_STATUS")
	private Book bookStatus;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public Book getBookId() {
		return bookId;
	}

	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Date getEstimatedReturnDate() {
		return estimatedReturnDate;
	}

	public void setEstimatedReturnDate(Date estimatedReturnDate) {
		this.estimatedReturnDate = estimatedReturnDate;
	}

	public Book getUserId() {
		return userId;
	}

	public void setUserId(Book userId) {
		this.userId = userId;
	}

	public Book getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(Book bookStatus) {
		this.bookStatus = bookStatus;
	}
	
}
