package stringTkn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Article {

	public Article()
	{
		this.price = 0.0;
		this.name = "";
		this.inputDate = new GregorianCalendar().getTime();
	}
	
	public Article(double price, String name) 
	{
		this();
		this.price = price;
		this.name = name;
	}
	
	public Article(double price, String name, int year, int month, int day)
	{
		this(price, name);
		GregorianCalendar gregorianCalendar = new GregorianCalendar(year, month, day);
		this.inputDate = gregorianCalendar.getTime();
	}
	
	
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public void setInputDate(int year, int month, int day) {
		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		this.inputDate = calendar.getTime();
	}
	
	private double price;
	private String name;
	private Date inputDate;
}
