import java.io.BufferedReader;
import java.io.FileReader;

public class DataAnalyzerMethods {

	boolean findWord(String linetoAnalyze, String word) {
		String lineToAnalyzeLowerCase = linetoAnalyze.toLowerCase();
		if (lineToAnalyzeLowerCase.contains(word)){
			return true;
		}
		else {
			return false;
		}
	}
	
	int [] getNumComments(String fileToRead) {
		int [] numComments = new int[6466];
		
		try {
			FileReader fileReader = new FileReader(fileToRead);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			String line = null;
			int counter = 0;
			while ((line = bufferReader.readLine()) != null) {
				int numCommentsPost = Integer.parseInt(line);
				
				numComments[counter] = numCommentsPost;
				counter += 1;
			}
			return numComments;		
		}
		catch (Exception ex) {
			System.out.println("The file was not found");
		}
		return numComments;	
	}
	
	RedditPost [] getPosts(String fileToRead) {
		RedditPost [] theTitle = new RedditPost[6466];
		
		try {
			FileReader fileReader = new FileReader(fileToRead);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			String line = null;
			int counter = 0;
			while ((line = bufferReader.readLine()) != null) {
				theTitle[counter] = new RedditPost(line);
				counter += 1;
			}
			return theTitle;
		}
		catch (Exception ex) {
			System.out.println("The file was not found");
		}
		return theTitle;
	}	
	
	void numPosts(String filetoAnalyze, String word) {
		try {
			FileReader reader = new FileReader(filetoAnalyze);
			BufferedReader bufferReader = new BufferedReader(reader);
			DataAnalyzerMethods reader2 = new DataAnalyzerMethods();
			RedditPost [] title = reader2.getPosts("title.txt");
			int [] numComments = reader2.getNumComments("numComments.txt");
			String line = null;
			int counter = 0;
			int totalComments = 0;
			int averageComments = 0;
			int counter2 = 0;
			while ((line = bufferReader.readLine()) != null) {
				counter2++;
				if (findWord(line, word) == true) { 
					totalComments=totalComments+numComments[counter2];
					counter++;
				}
			}
			averageComments = totalComments/counter;
			System.out.println("The number of posts with "+word+" in it's title is: "+counter);
			System.out.println("The average amount of comments for those posts are: "+averageComments);
			System.out.println("The total amount of comments are: "+totalComments);
		}
		catch (Exception e) {
			System.out.println("The word was not located in any of the post titles.");
		}
	}
}