package paredes_PA4_p1;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class paredes_p1 {
		
	public static class DuplicateRemover {
		Scanner scnr = new Scanner(System.in);
		static ArrayList<String> uniqueWords = new ArrayList<String>();
		static int k;
		
		public static void remove(String dataFile) throws IOException {
			FileInputStream fileByteStreamIn = null;
			Scanner inFS = null;
			
			fileByteStreamIn = new FileInputStream(dataFile);
			inFS = new Scanner(fileByteStreamIn);
			BufferedReader br = new BufferedReader(new FileReader(dataFile));
			
			int i = 0, j = 0;
			int lineCount = 0;
			String temp;
			String stringSet[] = new String[100];
			
			while(  br.readLine() != null ) {
				++lineCount;
			}
			
			for(i = 0; i < lineCount; ++i) {
				
				temp = inFS.nextLine();
				stringSet = temp.split(" ");
				
				for(j = 0; j < stringSet.length; ++j) {
					
					if( ! uniqueWords.contains(stringSet[j]) ) {
						uniqueWords.add(stringSet[j]);
						++k;
					}
				}
			}
			
			inFS.close();
			br.close();
		    fileByteStreamIn.close();
		}
		
		public static void write(String outputFile) throws IOException {
			FileOutputStream fileByteStreamOut = null;
			PrintWriter outFS = null;
			
			fileByteStreamOut = new FileOutputStream(outputFile);
			outFS = new PrintWriter(fileByteStreamOut);
			
			for(int i = 0; i < k; ++i) {
				outFS.print(uniqueWords.get(i) + " ");
			} 
			
			outFS.flush();
			fileByteStreamOut.close();
		}
	}
	

	public static void main(String[] args) throws IOException {
	Scanner scnr = new Scanner(System.in);
	
	String dataFileName = "problem1.txt";
	String outputFileName = "unique_words.txt";
	String dataFolder = "", outputFolder = "";
	String dataFile = "", outputFile = "";
		
	System.out.println("Please enter problem1.txt folder location:");
	dataFolder = scnr.next();
		
	System.out.println("Please enter unique_words.txt folder destination:");
	outputFolder = scnr.next();
		
	dataFile = dataFile.concat(dataFolder).concat("\\").concat(dataFileName);
	outputFile = outputFile.concat(outputFolder).concat("\\").concat(outputFileName);
		
	DuplicateRemover.remove(dataFile);
	DuplicateRemover.write(outputFile);
	
	System.out.println("Duplicates Removed. Operation Complete");
		
	}
}
	
	
