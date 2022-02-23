import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOperation {
	
	String filePath ="C:\\Java\\Prog\\File\\";

	public static void main(String[] args) {
		FileOperation fileOperation = new FileOperation();
		
		fileOperation.welcomeScreen();
		
	}
	
	
	private void welcomeScreen()
	{
		System.out.println("------Welcome to SimpliLearn File Operation Project--------");
		System.out.println("------Enter 1 to DISPLAY all the file in the directory asecnding order");
		System.out.println("------Enter 2 to SEARCH/FIND the file in the directory");
		System.out.println("------Enter 3 to CREATE the file in the directory");
		System.out.println("------Enter 4 to DELETE the file in the directory");
		System.out.println("------Enter 5 to MAIN MENU ");
		
		//getting the value from command line
		  Scanner in = new Scanner(System.in);		  
          int commandLineInput = in.nextInt();
	        
	        
        switch (commandLineInput) {
        case 1:
            displayAllFileInDirectory();
            break;
        case 2:
           findFileInDirectory();
            break;
        case 3:
            createFileInDirectory();
            break;
        case 4:
            deleteFileInDirectory();
            break;
        case 5:
            mainMenu();
            break;
       
        default:
           System.out.println("Invalide input re-directing to MAIN MENU");;
           mainMenu();
           break;
        }
        
      
	}

	  private void displayAllFileInDirectory()
      {
		  
		  // Creates an array in which we will store the names of files and directories
	        String[] pathnames;

	        // Creates a new File instance by converting the given pathname string
	        // into an abstract pathname
	        File f = new File(filePath);

	        // Populates the array with names of files and directories
	        pathnames = f.list();

	        // For each pathname in the pathnames array
	        for (String pathname : pathnames)
	        {
	            // Print the names of files and directories
	            System.out.println(pathname);
      	    }
	  
      }
	  
	  
	  
	  private void findFileInDirectory()
      {
		  // Using Scanner for Getting Input from User
		  System.out.println("Please Enter the File Name with Extention to to be find");
	        Scanner in = new Scanner(System.in);	 
	        String fileName = in.nextLine();
	        File directory = new File(filePath);
	        
	     
	  
	        // store all names with same name 
	        // with/without extension
	        String[] flist = directory.list();
	  
	        // Empty array
	        if (flist == null) {
	            System.out.println(
	                "Empty directory or directory does not exists.");
	        }
	        else {
	  
	            // Print all files with same name in directory
	            // as provided in object of MyFilenameFilter
	        	int count=0;
	             for (int i = 0; i < flist.length; i++) {
	            	if(flist[i].equalsIgnoreCase(fileName))
	            	{
	            		count++;
	                System.out.println(flist[i]+" found");
	            	}
	            	else if(count ==0 && i==flist.length-1)
	            	{
	            		System.out.println(fileName +" file is not present in the directory please check the file name");
	            	}
	            }
	        }
      }
	  
	  
	  
	  private void createFileInDirectory()
      {
		  // Using Scanner for Getting Input from User
		  System.out.println("Please Enter the File Name to be created");
	        Scanner in = new Scanner(System.in);	 
	        String fileName = in.nextLine();
	        
	        try {
	            File myObj = new File(filePath+fileName);
	            System.out.println(filePath+fileName);
	            if (myObj.createNewFile()) {
	              System.out.println("File created: " + myObj.getName());
	            } else {
	              System.out.println("File already exists.");
	            }
	          } catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	          }  
      	
      }
	  
	  private void deleteFileInDirectory()
      {
		  // Using Scanner for Getting Input from User
		  System.out.println("Please Enter the File Name to be deleted");
		    Scanner in = new Scanner(System.in);	 
	        String fileName = in.nextLine();
	        
	        File myObj = new File(filePath+fileName);
			System.out.println(filePath+fileName);
			if (myObj.delete()) {
			  System.out.println("Deleted the file: " + myObj.getName());
			} else {
			  System.out.println("Failed to delete the file.");
			}  
      	
      }
	  
	  private void mainMenu()
      {
      	
      }
	  
	
	
}
