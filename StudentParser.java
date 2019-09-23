import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
public class StudentParser{
  Scanner scan;
  File file;

  public StudentParser(){
    file = new File("students.txt");
    try{
      scan = new Scanner(file);
    }
    catch(FileNotFoundException f){
      System.out.println("students.txt not found");
      System.exit(-1);
    }
    scan.useDelimiter(Pattern.compile(",|\r\n|\n"));
  }

  public ArrayList<Student> parse(){
    ArrayList<Student> list = new ArrayList<Student>();
    String fName;
    String lName;
    int grade;
    int classroom;
    int bus;
    double GPA;
    String tFName;
    String tLName;
    //int num = 0;
    while(scan.hasNext()){
      //System.out.println("Line " + num);
      //num++;
      try{
        lName = scan.next();
        fName = scan.next();
        grade = scan.nextInt();
        classroom = scan.nextInt();
        bus = scan.nextInt();
        GPA = scan.nextDouble();
        tLName = scan.next();
        tFName = scan.next();
        //the tFName has to be trimmed to get rid of the carriage return character for some reason
        Student s = new Student(lName, fName, grade, classroom, bus, GPA, tLName, tFName);
        list.add(s);
      }
      catch(NoSuchElementException i){
        System.out.println("Invalid input!");
        System.exit(-1);
      }
    }
    return list;
  }
}
