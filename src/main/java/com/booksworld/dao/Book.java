package com.booksworld.dao;


import com.booksworld.dao.Category;
import com.booksworld.dao.User;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

enum Status{
	AVAILABLE,REQUESTED,REQUEST_ACCEPTED,BOOKED,DISABLED
}

@Entity
@Table(name = "BOOK")
public class Book{

	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;

	@Column(name = "BOOK_NAME")
	private String bookName;

	@Column(name = "BOOK_AUTHOR")
	private String bookAuthor;
	

	@Column(name = "BOOK_IMAGE")
	private String bookImage;
	
	@Column(name = "BOOK_DESCRIPTION", columnDefinition="TEXT")
	private String bookDescription;
	
	@Column(name = "BOOK_STATUS")
	@Enumerated(EnumType.STRING)
	private Status bookStatus;
	
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.DATE)
    private Date createdDate;

	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "EMP_ID")
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID",referencedColumnName = "CATEGORY_ID")
	private Category categoryId;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public Status getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(Status bookStatus) {
		this.bookStatus = bookStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}
}
