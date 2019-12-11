package com.booksworld.dao;

import com.booksworld.dao.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "BOOK")
public class Book {
	

	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;

	@Column(name = "BOOK_NAME")
	private String name;

	@Column(name = "BOOK_AUTHOR")
	private String author;
	
	@Column(name = "BOOK_IMAGE")
	private String imagePath;
	
	@Column(name = "BOOK_LANGUAGE")
	private String language;
	
	@Column(name = "BOOK_GENRE")
	private String genre;
	
	@ManyToOne
	@JoinColumn(name = "OWNER_ID", referencedColumnName = "EMP_ID")
	private User ownerId;
	
	@Column(name = "BOOK_CREATED_DATE")
	private String createdDate;
	
	@Column(name = "BOOK_DELETED_DATE")
	private String deletedDate;
	
	@Column(name = "BOOK_UPDATED_DATE")
	private String updatedDate;
	
	@Column(name = "BOOK_PAGES")
	private int pages;
	
	@Column(name = "BOOK_DAYS")
	private int days;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	
	public User getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(User ownerId) {
		this.ownerId = ownerId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}	

}

