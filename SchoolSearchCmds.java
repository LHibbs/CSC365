import java.util.ArrayList;
import java.util.List;
import java.util.function.*; 
import java.util.stream.Collectors; 
import java.util.stream.Stream;  
import java.util.*; 

public class SchoolSearchCmds {

    private ArrayList<Student> listStudents;

    public SchoolSearchCmds(ArrayList<Student> s){
        listStudents = s; 
    }

    public void studentLastName(String lastName){
        List<String> printAttribs = 
            Stream.of("stLastName", "stFirstName", "grade", "classroom", "tLastName", "tFirstName")
            .collect(Collectors.toList());

        System.out.println("print dammit"); 
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

        executeQuery(s -> s.getGrade() == grade,
                     s -> System.out.println(s.filteredPrint(printAttribs)),
                    (Student one, Student two) -> 
                        Integer.valueOf(one.getGrade()).compareTo(Integer.valueOf(two.getGrade()))); 
    }

    /*public void gradeLow(int grade) {
        List<String> printAttribs = 
            Stream.of("stLastName", "stFirstName")
            .collect(Collectors.toList());

        executeQuery(s -> s.getGrade() == grade,
                     s -> System.out.println(s.filteredPrint(printAttribs)),
                    (Student one, Student two)-> one.getGrade().compareTo(two.getGrade())); 
    }*/

    public void bus(int busNum) {
        List<String> printAttribs = 
            Stream.of("stLastName", "stFirstName", "grade", "classroom")
            .collect(Collectors.toList());

        executeQuery(s -> s.getBus() == busNum,
                     s -> System.out.println(s.filteredPrint(printAttribs))); 
    }

    public void executeQuery(Predicate<Student> pred, Consumer<Student> print) {
        listStudents
            .stream()
            .filter(pred)
            .forEach(print);
    }

    public void executeQuery(Predicate<Student> pred, Consumer<Student> print, Comparator<Student> sort) {
        listStudents
            .stream()
            .filter(pred)
            .sorted(sort)
            .collect(Collectors.toList())
            .get(0); 
    }
}