package com.chenghao.work;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Book {
	private int id;
	private String name;
	private double price;
	private String type;
	private LocalDate publishDate;

	public Book(int id, String name, double price, String type, LocalDate publishDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.publishDate = publishDate;
	}
	public static List<Book> books(){
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "tomcat", 70d, "服务器", LocalDate.parse("2014-05-17")));
		books.add(new Book(2, "jetty", 60d, "服务器", LocalDate.parse("2015-12-01")));
		books.add(new Book(3, "nginx", 65d, "服务器", LocalDate.parse("2016-10-17")));
		books.add(new Book(4, "java", 66d, "编程语言", LocalDate.parse("2011-04-09")));
		books.add(new Book(5, "ruby", 80d, "编程语言", LocalDate.parse("2013-05-09")));
		books.add(new Book(6, "php", 40d, "编程语言", LocalDate.parse("2014-08-06")));
		books.add(new Book(7, "html", 44d, "编程语言", LocalDate.parse("2011-01-06")));
		books.add(new Book(8, "oracle", 150d, "数据库", LocalDate.parse("2013-08-09")));
		return books;
	}

}
