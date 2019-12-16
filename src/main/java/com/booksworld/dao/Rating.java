package com.booksworld.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@OneToOne
	@JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID")
	private Book bookId;
	
	@OneToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "EMP_ID")
	private Book userId;
	
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

	public Book getUserId() {
		return userId;
	}

	public void setUserId(Book userId) {
		this.userId = userId;
	}

	public Status getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(Status ratingValue) {
		this.ratingValue = ratingValue;
	}
	

}
