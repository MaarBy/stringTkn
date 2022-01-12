package stringTkn;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		Article[] article = new Article[3];
		
		article[0] = new Article();
		article[1] = new Article(77.1, "Broken bucket");
		article[2] = new Article(307.12, "Wooden tomato", 2020, 11, 17);
		
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("testFile.txt"));

//			Article.writeIntoFile(article, writer);
			writer.close();
//			BufferedReader reader = new BufferedReader(new FileReader("testFile.txt"));
//            
//            Article[] article2 = Article.readfromFile(reader);
//            for (int i = 0; i < article2.length; i++)
//                System.out.println(article2[i]);
//            reader.close();
			
			Article.writeIntoFile(article, writer);
			
			writer.close();
			
			Article.writeIntoFile(article, writer);
			
			writer.close();
			
			BufferedReader reader = new BufferedReader(new FileReader("testFile.txt"));
            
            Article[] article2 = Article.readFromFile(reader);
            
            for (int i = 0; i < article2.length; i++)
                System.out.println(article2[i]);
            
            reader.close();

		} 
		catch (IOException e) {
			System.out.println(e.getMessage());		
		}
		
	}
}
