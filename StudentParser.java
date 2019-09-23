import java.util.*;
import java.io.*;
public class StudentParser{
  Scanner scan;
  File file;

  public StudentParser(){
    file = new File("students.txt");
    scan = new Scanner(file);
    scan.useDelimiter(",");
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
    while(scan.hasNext()){
      try{
        fName = scan.next();
        lName = scan.next();
        grade = scan.nextInt();
        classroom = scan.nextInt();
        bus = scan.nextInt();
        GPA = scan.nextDouble();
        tFName = scan.next();
        tLName = scan.next();
      }
      catch(NoSuchElementException i){
        System.out.println("Invalid input!");
        System.exit(-1);
      }
      Student s = new Student(fName, lName, grade, classroom, bus, GPA, tFName, tLName);
      list.add(s);
    }
    return list;
  }
}
