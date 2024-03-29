CREATE TABLE USER(
	USER_ID int PRIMARY KEY,
	USER_NAME varchar(255),
	USER_LOCATION varchar(255),
	IMAGE varchar(255),
	EMAIL_ID varchar(255),
	PASSWORD varchar(255)
);

CREATE TABLE CATEGORY (
	CATEGORY_ID int PRIMARY KEY,
	CATEGORY_NAME varchar(255),
	CATEGORY_IMAGE varchar(255)
);

CREATE TABLE BOOK (
	BOOK_ID int PRIMARY KEY,
	BOOK_NAME varchar(255),
	BOOK_AUTHOR varchar(255),
	BOOK_IMAGE varchar(255),
	BOOK_DESCRIPTION varchar(255),
	BOOK_STATUS varchar(255),
	CREATED_DATE DATE NOT NULL DEFAULT CURRENT_DATE,
	USER_ID int REFERENCES User(USER_ID),
	CATEGORY_ID int REFERENCES Category(CATEGORY_ID),
	PRIMARY KEY (USER_ID,CATEGORY_ID)
);