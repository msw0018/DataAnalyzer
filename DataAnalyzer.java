import java.util.Scanner;

public class DataAnalyzer {
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		DataAnalyzerMethods reader = new DataAnalyzerMethods();
		String word = null;
		
		System.out.println("Hello. This bot is here to track the average amount of comments \na post gets with a certain word within it's title.");
	
		System.out.println("Please enter a word you would like to search for.");
		word = input.nextLine();
		String newWord = word.toLowerCase();
		
		reader.numPosts("title.txt", newWord);
	}
}