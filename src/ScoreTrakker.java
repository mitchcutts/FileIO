import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class ScoreTrakker {

	ArrayList<Student> studentList = new ArrayList<Student>();
	
	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		FileReader fileStream = null;
		String studentName = "";
		int studentScore;
		String studentScoreStr = "";
		
		System.out.println("\n...Opening file...");
		//file opening
	    try{ 
	    	fileStream = new FileReader(fileName);
	    	
	    }catch (FileNotFoundException e){
	    	throw new FileNotFoundException("file not found");
	    }
	   
	    
	    Scanner inFS = new Scanner(fileStream);
	    
	   
	    
	    while(inFS.hasNext()) {
	    	try {
	    		
	    		studentName = inFS.nextLine();
	    		studentScoreStr = inFS.nextLine();
	    		studentScore = Integer.parseInt(studentScoreStr);
	    		//studentScore = inFS.nextInt();
	    		//System.out.println(studentName);
	    		//System.out.println(studentScore);
	    		Student addingStudent = new Student(studentName, studentScore);
	    		studentList.add(addingStudent);
	    	}catch(InputMismatchException e){
	    		String errorMsg = "Input Mismatch";
	    		System.out.println(errorMsg);
	    	}catch(NoSuchElementException e){
	    		String errorMsg1 = "No Such Element";
	    		System.out.println(errorMsg1);
	    	}catch(NumberFormatException e) {
	    		System.out.println("incorrect format for " + studentName + " not a valid score: " + studentScoreStr);
	    	}
	    	
	    }
	    
	  
	    
	    
	    
	    inFS.close();
	    //fileStream.close(); 
	    //TODO: Code Exception for Closing Input Stream
	}
	
	public void printInOrder() {
		//TODO:Fix NullPointerExceptions
		System.out.println("\nStudent Score List: \n");
		Collections.sort(this.studentList); //uses comparator to sort Student List
		for (Student i: studentList){
			System.out.println(i.toString());
		}
	}
	
	public void processFiles() throws FileNotFoundException {
		
		String[] myFiles = {"scores.txt", "badscore.txt", "nofile.txt"};
		
		for(String str : myFiles) {
			studentList.clear();
			try	{
				loadDataFromFile(str);
				System.out.println("\n File opened successfully!");
				printInOrder();
			} catch	(FileNotFoundException e) {
				System.out.println("File " + str + " cannot be opened or does not exist");
				continue;
			}
			
			
		}
				
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles();
	}
	
	
	
	
	
}
