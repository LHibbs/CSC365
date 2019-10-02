
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
    private ArrayList<Teacher> listTeachers;

    public SchoolSearchCmds(ArrayList<Student> s, ArrayList<Teacher> t) {
        listStudents = s;
        listTeachers = t;
    }

    public void studentLastName(String lastName) {
        List<String> printAttribs = Stream
                .of("stLastName", "stFirstName", "grade", "classroom", "tLastName", "tFirstName")
                .collect(Collectors.toList());

        executeQuery(s -> s.getLastName().equals(lastName), s -> System.out.println(s.filteredPrint(printAttribs)));
    }

    public void studentLastNameBus(String lastName) {
        List<String> printAttribs = Stream.of("stLastName", "stFirstName", "bus").collect(Collectors.toList());

        executeQuery(s -> s.getLastName().equals(lastName), s -> System.out.println(s.filteredPrint(printAttribs)));
    }

    public void teacherLastName(String lastName) {
        List<String> printAttribs = Stream.of("stLastName", "stFirstName").collect(Collectors.toList());
        int c = 0;
        for(Teacher t : listTeachers){
          if(lastName.equals(t.getLastName())){
            c = t.getClassroom();
            break;
          }
        }
        final int j = c;
        executeQuery(s -> s.getClassroom() == j, s -> System.out.println(s.filteredPrint(printAttribs)));
    }

    public void grade(int grade) {
        List<String> printAttribs = Stream.of("stLastName", "stFirstName").collect(Collectors.toList());

        executeQuery(s -> s.getGrade() == grade, s -> System.out.println(s.filteredPrint(printAttribs)));
    }

    public void gradeHigh(int grade) {
        List<String> printAttribs = Stream.of("stLastName", "stFirstName", "GPA", "tLastName", "tFirstName", "bus")
                .collect(Collectors.toList());

        Comparator<Student> c = Comparator.comparing((Student s) -> s.getGPA());

        executeQuery(s -> s.getGrade() == grade, printAttribs, c.reversed());
    }

    public void gradeLow(int grade) {
        List<String> printAttribs = Stream.of("stLastName", "stFirstName", "GPA", "tLastName", "tFirstName", "bus")
                .collect(Collectors.toList());

        Comparator<Student> c = Comparator.comparing((Student s) -> s.getGPA());

        executeQuery(s -> s.getGrade() == grade, printAttribs, c);
    }

    public void bus(int busNum) {
        List<String> printAttribs = Stream.of("stLastName", "stFirstName", "grade", "classroom")
                .collect(Collectors.toList());

        executeQuery(s -> s.getBus() == busNum, s -> System.out.println(s.filteredPrint(printAttribs)));
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
      for(Teacher t : listTeachers){
        if(t.getClassroom() == num){
          System.out.println(t.getLastName() + "," + t.getFirstName());
        }
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
      for(Teacher t : listTeachers){
        if(rooms.contains(t.getClassroom())){
          System.out.println(t.getLastName()+ "," + t.getFirstName());
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

    public void executeQuery(Predicate<Student> pred, Consumer<Student> print) {
        listStudents.stream().filter(pred).forEach(print);
    }

    public void executeQuery(Predicate<Student> pred, List<String> printAttribs, Comparator<Student> sort) {
        List<Student> filteredStudents = listStudents.stream().filter(pred).sorted(sort).collect(Collectors.toList());

        // can't figure out optionals with the stream
        if (filteredStudents.size() > 0) {
            System.out.println(filteredStudents.get(0).filteredPrint(printAttribs));
        }
    }
}
