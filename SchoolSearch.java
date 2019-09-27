import java.util.ArrayList;
import java.util.List;
import java.util.function.*; 
import java.util.stream.Collectors; 
import java.util.stream.Stream;  

public class SchoolSearch {

    private ArrayList<Student> listStudents;

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

    public void executeQuery(Predicate<Student> pred, Consumer<Student> print) {
        listStudents
            .stream()
            .filter(pred)
            .forEach(print); 
    }
}