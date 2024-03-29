package com.booksworld.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name = "COMMENT", schema="booksworld")
public class Comment {
	
	@Id
	@Column(name = "COMMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;
	
	@ManyToOne
	@JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID")
	private Book bookId;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private User userId;
	
	@Column(name = "COMMENT", columnDefinition="TEXT")
	private String comment;

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
