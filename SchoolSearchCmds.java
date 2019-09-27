import java.util.ArrayList;
import java.util.List;
import java.util.function.*; 
import java.util.stream.Collectors; 
import java.util.stream.Stream;  
import java.util.*; 
import java.text.*;

public class SchoolSearchCmds {

    private ArrayList<Student> listStudents;

    public SchoolSearchCmds(ArrayList<Student> s){
        listStudents = s; 
    }

    public void studentLastName(String lastName){
        List<String> printAttribs = 
            Stream.of("stLastName", "stFirstName", "grade", "classroom", "tLastName", "tFirstName")
            .collect(Collectors.toList());

        executeQuery(s -> s.getStLastName().equals(lastName),
                     s -> System.out.println(s.filteredPrint(printAttribs))); 
    }

    public void studentLastNameBus(String lastName) { 
        List<String> printAttribs = 
            Stream.of("stLastName", "stFirstName", "bus")
            .collect(Collectors.toList());

        executeQuery(s -> s.getStLastName().equals(lastName),
                     s -> System.out.println(s.filteredPrint(printAttribs))); 
    }

    public void teacherLastName(String lastName) {
        List<String> printAttribs = 
            Stream.of("stLastName", "stFirstName")
            .collect(Collectors.toList());

        executeQuery(s -> s.getTLastName().equals(lastName),
                     s -> System.out.println(s.filteredPrint(printAttribs))); 
    }

    public void grade(int grade) {
        List<String> printAttribs = 
            Stream.of("stLastName", "stFirstName")
            .collect(Collectors.toList());

        executeQuery(s -> s.getGrade() == grade,
                     s -> System.out.println(s.filteredPrint(printAttribs))); 
    }

    public void gradeHigh(int grade) {
        List<String> printAttribs = 
            Stream.of("stLastName", "stFirstName", "GPA", "tLastName", "tFirstName", "bus")
            .collect(Collectors.toList());

        Comparator<Student> c = Comparator.comparing((Student s) -> s.getGPA());

        executeQuery(s -> s.getGrade() == grade,
                    printAttribs,
                    c.reversed()); 
    }

    public void gradeLow(int grade) {
        List<String> printAttribs = 
            Stream.of("stLastName", "stFirstName", "GPA", "tLastName", "tFirstName", "bus")
            .collect(Collectors.toList());

        Comparator<Student> c = Comparator.comparing((Student s) -> s.getGPA());
         
        executeQuery(s -> s.getGrade() == grade,
                    printAttribs,
                    c.reversed()); 
    }

    public void bus(int busNum) {
        List<String> printAttribs = 
            Stream.of("stLastName", "stFirstName", "grade", "classroom")
            .collect(Collectors.toList());

        executeQuery(s -> s.getBus() == busNum,
                     s -> System.out.println(s.filteredPrint(printAttribs))); 
    }

   public void average(int gradeNum){
      int num = 0;
      double gpas = 0;
      for(Student s: listStudents){
         if(s.getGrade() == gradeNum){
            num++;
            gpas += s.getGPA();
         }
      }
      if(num == 0){
         return;
      }
      double av = gpas/num;
      DecimalFormat df = new DecimalFormat("#.##");
      System.out.print(df.format(av));
   }

   public void info(){
      int[] counts = {0, 0, 0, 0, 0, 0, 0};
      for(Student s: listStudents){
         counts[s.getGrade()]++;
      }
      for(int i = 0; i < 7; i++){
         System.out.println(i + ": " + counts[i]);
      }
   }

    public void executeQuery(Predicate<Student> pred, Consumer<Student> print) {
        listStudents
            .stream()
            .filter(pred)
            .forEach(print);
    }

    public void executeQuery(Predicate<Student> pred, List<String> printAttribs, Comparator<Student> sort) {
        List<Student> highest = listStudents
            .stream()
            .filter(pred)
            .sorted(sort)
            .collect(Collectors.toList());
        
        //can't figure out optionals with the stream
        for (Student s : highest) { 
            s.filteredPrint(printAttribs); 
        }
    }
}
