# spring-board-simple-crud
2020.09.03.화 스프링 게시판 단순 CRUD 

Spring + MyBatis + MySQL 기반의 초간단 CRUD 연습

## 개발환경 
```
Programming Language - Java 1.8
IDE - Eclipse
DB - MySQL 
Framework - MyBatis, Spring 4.3.2
Build Tool - Maven
```

## board.sql
```
CREATE TABLE board (
	b_no INT NOT NULL AUTO_INCREMENT,
	b_title VARCHAR(200) NOT NULL,
	b_detail TEXT NULL,
	b_writer VARCHAR(45) NOT NULL,
	b_date TIMESTAMP NULL,
	b_count INT NULL DEFAULT 0,
	PRIMARY KEY(b_no)
);
```

