package stringTkn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Article {

	public Article()	{
		this.price = 0.0;
		this.name = "";
		this.inputDate = new GregorianCalendar().getTime();
	}
	
	public Article(double price, String name)	{
		this();
		this.price = price;
		this.name = name;
	}
	
	public Article(double price, String name, int year, int month, int day)	{
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

	public void setInputDate(Date inputDate)	{
		this.inputDate = inputDate;
	}

	public void setInputDate(int year, int month, int day)	{
		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		this.inputDate = calendar.getTime();
	}
	
	@Override
	public String toString()	{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(this.inputDate);
		return this.price + " £; name: " + this.name + " " 
			+ calendar.get(Calendar.YEAR) + " year " + " " 
			+ calendar.get(Calendar.MONTH) + " month " + " " 
			+ calendar.get(Calendar.DAY_OF_MONTH) + " day ";
	}

	public static void writeIntoFile(Article[] article, PrintWriter outputStream)	{
        outputStream.println(article.length);
        GregorianCalendar calendar = new GregorianCalendar();
        
        for (int i = 0; i < article.length; i++)	        {
            calendar.setTime(article[i].getInputDate());
            outputStream.println(article[i].getPrice() + ":" 
            + article[i].getName() + ":" 
            + calendar.get(Calendar.YEAR) + ":" 
            + calendar.get(Calendar.MONTH) + ":" 
            + calendar.get(Calendar.DAY_OF_MONTH));        
        }
    }

	public static Article[] readFromFile(BufferedReader inputStream) throws IOException	    {
			
        int articlesTableLength = Integer.parseInt(inputStream.readLine());
        
        Article[] article = new Article[articlesTableLength];
        
        for (int i = 0; i < articlesTableLength; i++)	{	
            String readLine = inputStream.readLine();
            StringTokenizer token = new StringTokenizer(readLine, ":");
           
            double price = Double.parseDouble(token.nextToken());
            String name = token.nextToken();
            int year = Integer.parseInt(token.nextToken());
            int month = Integer.parseInt(token.nextToken());
            int day = Integer.parseInt(token.nextToken());
            article[i] = new Article(price, name, year, month, day);	
        }
        return article;
    }
	private double price;
	private String name;
	private Date inputDate;
}
