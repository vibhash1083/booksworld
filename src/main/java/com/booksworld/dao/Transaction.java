package com.booksworld.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

enum Status{
	AVAILABLE,LENT
}

@Entity
@Table(name = "TRANSACTION")
public class Transaction {
	
	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	@Column(name = "BORROWER_ID")
	private long borrowerId;
	
	@Column(name = "BORROWED_DATE")
	private String borrowedDate;
	
	@Column(name = "ESTIMATED_RETURN_DATE")
	private String estimatedReturnDate;
	
	@Column(name = "MEETING_LOCATION")
	private String meetingLocation;
	
	@Column(name = "ACTUAL_RETURN_DATE")
	private String actualReturnDate;
	
	@Column(name = "BOOK_STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "OWNER_ID", referencedColumnName = "EMP_ID")
	private User ownerId;


	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public long getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(long borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(String borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public String getEstimatedReturnDate() {
		return estimatedReturnDate;
	}

	public void setEstimatedReturnDate(String estimatedReturnDate) {
		this.estimatedReturnDate = estimatedReturnDate;
	}

	public String getActualReturnDate() {
		return actualReturnDate;
	}

	public void setActualReturnDate(String actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(User ownerId) {
		this.ownerId = ownerId;
	}

	public String getMeetingLocation() {
		return meetingLocation;
	}

	public void setMeetingLocation(String meetingLocation) {
		this.meetingLocation = meetingLocation;
	}

}
