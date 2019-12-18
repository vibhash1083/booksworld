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

import com.booksworld.dao.Book.Status;

enum Ratings{
	 VERYPOOR,POOR,AVERAGE,GOOD,BEST
}
@Entity
@Table(name = "RATINGS")
public class Rating {
	
	@Id
	@Column(name = "RATING_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ratingId;
	
	@ManyToOne
	@JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID")
	private Book bookId;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private User userId;
	
	@Column(name = "RATING_VALUE")
	@Enumerated(EnumType.STRING)
	private Status ratingValue;

	public long getRatingId() {
		return ratingId;
	}

	public void setRatingId(long ratingId) {
		this.ratingId = ratingId;
	}

	public Book getBookId() {
		return bookId;
	}

	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Status getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(Status ratingValue) {
		this.ratingValue = ratingValue;
	}
	

}
