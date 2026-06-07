import java.util.Scanner; 
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class t1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
    
    try {
        //Get file names
        System.out.print("Enter the name of the first file: ");
        String readFile = input.nextLine();

        System.out.print("Enter the name of the second file: ");
        String writeFile = input.nextLine();

 
        //===================================================================================================
       
   

       // Open file for reading
       File myObj = new File(readFile);
       Scanner myFile = new Scanner(myObj);
        
       // Open  file for writing
        FileWriter myWriter = new FileWriter(writeFile);

       //=====================================================================================================

       //Step #3 Read until end of file

       while(myFile.hasNextLine()){
            String line= myFile.nextLine();
            myWriter.write(line+"\n");
       }
        //===================================================================================================


       //Close the files

       myFile.close();
       myWriter.close();  

      }

        //===================================================================================================

      catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }

    }
}
