
package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class Record {
private static Record instance;
private Record() {}
public static Record getInstance() 
{
    if ( instance == null)
    {
        instance = new Record("record.txt");
    }
    return instance;
    
}
// Name of the associated file
private String filename;
private Record(String n) 
{
filename = n;
}
// Effects: Reads and prints the contents of the associated
// file to the standard output.
public void read() {
try 
{
    // pass the path to the file as a parameter
File homedir = new File(System.getProperty("user.home"));
File fileToRead = new File(homedir, "NetBeansProjects/coe528Lab4/record.txt");
//File file = new File("/home/hmakrod/java/record.txt");
Scanner sc = new Scanner(fileToRead);
 
while (sc.hasNextLine())
System.out.println(sc.nextLine());
 } 
catch (IOException e) 
{
System.out.println("An error occurred.");
e.printStackTrace();
}
}

// Effects: Appends the specified message, msg, to the
// associated file.
public void write(String msg) 
{
try 
{
String str = msg;
    FileWriter myWriter = new FileWriter("record.txt", true);
    myWriter.write(str);
    myWriter.close();
} 
catch (IOException e) 
{
System.out.println("An error occurred.");
e.printStackTrace();
}
}
public static void main(String[] args) throws IOException 
{
// Fill the blank below that obtains the sole instance
// of the Record class.
// (You should not invoke the Record constructor here.)
//______________________________________ ;
// Do not modify the code below

Record r = Record.getInstance();
r.write("Hello-1\n");
r.write("Hello-2\n");
System.out.println("Currently the file record.txt " +
"contains the following lines:");
r.read();
}
}
