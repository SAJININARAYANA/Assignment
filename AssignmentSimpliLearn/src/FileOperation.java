import java.io.File;
import java.util.Scanner;

public class FileOperation {
	
	String filePath ="C:\\Java\\Prog\\File";

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
      	
      }
	  
	  private void createFileInDirectory()
      {
      	
      }
	  
	  private void deleteFileInDirectory()
      {
      	
      }
	  
	  private void mainMenu()
      {
      	
      }
	  
	
	
}
