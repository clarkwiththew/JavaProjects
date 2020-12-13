package lab6_project;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;


public class executionOfProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) 	{
		
		// 1. Use hash map to map file extensions to their corresponding class names
	    // TODO: Create a HashMap called fileHashMap. 
			// note: the key and value types are String
		HashMap<String, String> fileHashMap = new HashMap<String, String>();
		// initialize fileHashMap to map the for each 'File' type
			// TODO complete the initializeHashMapWithFileExtension method
			// TODO call initializeHashMapWithFileExtension
		initializeHashMapWithFileExtension(fileHashMap);
		// 2. Extract file extension (eg. pdf, word, txt)
			// Imagine at this point you write code to get files off your HDD and you have extracted the file extension i.e. pdf or doc or txt
			// For learning purposes, we are going to hardcode the extension as a string variable
		
		// TODO Create a variable (String fileExtension) and hard code it to "pdf"
			// After you find "pdf" works, change the variable to "word" and then to "txt" to see that all work
		String fileExtension = "pdf";
		
		try 
		{
			// 3. Get the corresponding class name of the fileExtension
				// TODO Use the hashmap to figure out the corresponding class name and assign it to String className
			String className=fileHashMap.get(fileExtension);
			try 
			{
				// 4. Get instance of the class and run methods from the class
					// TODO 1. get class of className using Class.
					File file =(File) Class.forName(className).getDeclaredConstructor().newInstance();
					// TODO 2. get instance of the class using .getDeclaredConstructor().newInstance()
				//Object b = a.getDeclaredConstructor().newInstance();
					// TODO 3. assign the above instance of class to variable File file (NOTE: remember to cast)
				//File file = (File) b;
				file.printContentsOfFile();
				file.printDateOFfile();
				file.printOwnerOfFile();				
				
			} 
			catch (InstantiationException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void initializeHashMapWithFileExtension(HashMap<String, String> fileHashMap) 
	{
		// TODO pair each file extension names (eg. pdf, word, txt) 
		// with the corresponding class names (lab6_project.openPDF,lab6_project.openWord,lab6_project.openTXT)
		// Note: the class name must be preceded by the package name to run (eg. lab6_project.openPDF)

		fileHashMap.put("pdf","lab6_project.openPDF");
		fileHashMap.put("word","lab6_project.openWord");
		fileHashMap.put("txt","lab6_project.openTXT");


	}

}
