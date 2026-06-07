import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors


public class T2 {
    public static void main(String[] args) {
        
    Scanner input = new Scanner(System.in);

    try{

    //Get File name
     System.out.print("Enter the name of the first file: ");
     String readFile = input.nextLine();

    //Open file for reading
    File myObj= new File(readFile);
    Scanner myFile= new Scanner(myObj);

    //Read until end of file
    int count=0;
    while (myFile.hasNextLine()){
        myFile.nextLine();
        count++;
    }
    


  
       

    }
    
}

}
