import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileOperation {
	
	String filePath ="C:\\Java\\Prog\\File\\";

	public static void main(String[] args) {
		FileOperation fileOperation = new FileOperation();
		
		fileOperation.welcomeScreen();
		
	}
	
	
	private void welcomeScreen()
	{
		System.out.println("------WELCOME TO SIMPLILEARN  --------");
		System.out.println("********************************************");
		System.out.println("----- DEVELOPER DETAILS--------------- ");
		System.out.println("APPLICATION NAME: File Operation Project");
		System.out.println("DEVELOPER :SAJINI G");
		System.out.println("COURSE :Implement OOPS using JAVA with Data Structures and Beyond");
		System.out.println("START DATE:Jan 15th 2022");
		System.out.println("END DATE:  Feb 19th 2022");
		System.out.println("********************************************");
		int commandLineInput;
		do
		{
		
		System.out.println("------ENTER ANY OPTION----------------");
		System.out.println("------Enter 1 to DISPLAY all the file in the directory asecnding order");
		System.out.println("------Enter 2 to ADD/Delete/FIND the file in the directory");
		System.out.println("------Enter 3 to EXIT");
		
		
		//getting the value from commandline
		  Scanner in = new Scanner(System.in);		  
          commandLineInput = in.nextInt();
	        
	        
        switch (commandLineInput) {
        case 1:
        	System.out.println("DISPLAY ALL FINE IN DIRECTORY IN ACSENDING ORDER");
        	displayAscendingorder();
            break;
        case 2:
        	 int enterOption;
        	do
            {
        	System.out.println("------ENTER ANY OPTION----------------");
    		System.out.println("------Enter 01 to ADD FILE IN THE DIRECTORY");
    		System.out.println("------Enter 02 to SEARCH FILE IN THE DIRECTORY");
    		System.out.println("------Enter 03 to DELETE FILE IN THE DIRECTORY");
    		System.out.println("------Enter 04 to EXIT");
    		Scanner innew = new Scanner(System.in);		  
             enterOption = innew.nextInt();
    		
            
        	switch(enterOption) 
        	  {
        	    
                 case 01:
        	    	System.out.println("ADD FILE TO THE DIRECTORY");
        	    	createFileInDirectory();;
        	      break;
        	      
        	   
        	    case 02: 
        	    	System.out.println("SEARCH FILE IN THE DIRECTORY");
        	    	findFileInDirectory();
        	      break;
        	      
        	 
        	    case 03: 
        	    	System.out.println("DELETE FILE IN THE DIRECTORY");
        	    	deleteFileInDirectory();
        	      break;
        	      
        	    case 04:
        	    	System.out.println("GO TO MAIN MENU ...");
                    break;
        	      
        	      // code to be executed if num 
        	      // doesn't match any cases
        	      default: 
        	  }
        }
        	while(enterOption!=04);
        	
           	   
           break;
        case 3:
        	System.out.println("Exiting Program...");
            System.exit(0);
            break;
       
        default:
           System.out.println("Invalide input re-directing to MAIN MENU");;
           mainMenu();
           break;
        }
		}
		while(commandLineInput!=3);
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
	  
	  private void displayAscendingorder()
      {
		  File fileDir = new File(filePath);
			if(fileDir.isDirectory()){
				List<String> listFile = Arrays.asList(fileDir.list());
				System.out.println("Listing files unsorted");
				for(String s:listFile){
					System.out.println(s);
				}
				Collections.sort(listFile);
				System.out.println("---------------------------------------");
				System.out.println("Sorting by filename in ascending order");
				for(String s:listFile){
					System.out.println(s);
				}
			}
				else
				{
					System.out.println(fileDir.getAbsolutePath() + " is not a directory");
				}
			}
      
	  
	
	private void mainMenu()
	{
		
	}
	}

