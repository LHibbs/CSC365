
//Daniel Deegan, Lauren Hibbs
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
import java.text.*;

public class SchoolSearchCmds {

    private ArrayList<Student> listStudents;
    private HashMap<Integer, List<Teacher>> mapTeachers;

    public SchoolSearchCmds(ArrayList<Student> s, HashMap<Integer, List<Teacher>> m) {
        listStudents = s;
        mapTeachers = m ;
    }

    public void studentLastName(String lastName) {
        for(Student s : listStudents) { 
            if(s.getLastName().equals(lastName)){
                for(Teacher t : mapTeachers.get(s.getClassroom())) {
                    System.out.print(s.getLastName() + "," + s.getFirstName() + "," + s.getGrade() + "," + s.getClassroom() + 
                        "," + t.getLastName() + "," + t.getFirstName()); 
                }
            }
        }
    }

    public void studentLastNameBus(String lastName) {
        for(Student s : listStudents) { 
            if(s.getLastName().equals(lastName)){
                    System.out.print(s.getLastName() + "," + s.getFirstName() + "," + s.getBus()); 
                }
            } 
    }

    public void teacherLastName(String lastName) {
        /*List<String> printAttribs = Stream.of("stLastName", "stFirstName").collect(Collectors.toList());
        int c = 0;
        for(Teacher t : listTeachers){
          if(lastName.equals(t.getLastName())){
            c = t.getClassroom();
            break;
          }
        }
        final int j = c;
        executeQuery(s -> s.getClassroom() == j, s -> System.out.println(s.filteredPrint(printAttribs)));
        */
    }

    public void grade(int grade) {
        for(Student s : listStudents) { 
            if(s.getGrade() == grade){
                    System.out.print(s.getLastName() + "," + s.getFirstName()); 
                }
            } 
    }

    public void gradeHigh(int grade) {
        Student highestStudent = listStudents.get(0); 
        for(Student s : listStudents) { 
            if(s.getGrade() == grade){
                if(s.getGPA() >= highestStudent.getGPA()){
                    highestStudent = s; 
                }
            }
        }
        for(Teacher t : mapTeachers.get(highestStudent.getClassroom())) {
            System.out.print(highestStudent.getLastName() + "," + highestStudent.getFirstName() + "," + highestStudent.getGPA() + "," + 
                t.getLastName() + "," + t.getFirstName() + "," + highestStudent.getBus()); 
        }
    }

    public void gradeLow(int grade) {
        Student lowestStudent = listStudents.get(0); 
        for(Student s : listStudents) { 
            if(s.getGrade() == grade){
                if(s.getGPA() <= lowestStudent.getGPA()){
                    lowestStudent = s; 
                }
            }
        }
        for(Teacher t : mapTeachers.get(lowestStudent.getClassroom())) {
            System.out.print(lowestStudent.getLastName() + "," + lowestStudent.getFirstName() + "," + lowestStudent.getGPA() + "," + 
                 t.getLastName() + "," + t.getFirstName() + "," + lowestStudent.getBus()); 
        }
    }

    public void bus(int busNum) {
        for(Student s : listStudents) { 
            if(s.getBus() == busNum){
                    System.out.print(s.getLastName() + "," + s.getFirstName() + "," + s.getGrade() + "," + s.getClassroom()); 
                }
        } 
    }

    public void average(int gradeNum) {
        int num = 0;
        double gpas = 0;
        for (Student s : listStudents) {
            if (s.getGrade() == gradeNum) {
                num++;
                gpas += s.getGPA();
            }
        }
        if (num == 0) {
            return;
        }
        double av = gpas / num;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(av));
    }

    public void info() {
        int[] counts = { 0, 0, 0, 0, 0, 0, 0 };
        for (Student s : listStudents) {
            counts[s.getGrade()]++;
        }
        for (int i = 0; i < 7; i++) {
            System.out.println(i + ": " + counts[i]);
        }
    }

    public void classSearch(int num){
      for(Student s : listStudents){
        if(s.getClassroom() == num){
          System.out.println(s.getLastName() + "," + s.getFirstName());
        }
      }
    }

    public void classSearchTeacher(int num){
      for(Teacher t : mapTeachers.get(num)){
        System.out.println(t.getLastName() + "," + t.getFirstName());
      }
    }

    public void gradeSearch(int num){
      ArrayList<Integer> rooms = new ArrayList<Integer>();
      for(Student s : listStudents){
        if(s.getGrade() == num){
          if(!rooms.contains(s.getClassroom())){
            rooms.add(s.getClassroom());
          }
        }
      }
      for(Integer i : rooms){
        for(Teacher t : mapTeachers.get(num)){
          System.out.println(t.getLastName() + "," + t.getFirstName());
        }
      }
    }

    public void classroomList(){
      int[] counts = new int[20];
      for(Student s : listStudents){
        counts[s.getClassroom()%100]++;
      }
      for(int i = 0; i < 20; i++){
        if(counts[i] != 0){
            System.out.print(100 + i);
            System.out.println(": " + counts[i]);
        }
      }
    }
}
