import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class SchoolSearch {

    private ArrayList<Student> listStudents;

    public void studentLastName(String lastName){
        ArrayList<String> printAttribs = new ArrayList<String> (
            List.of("stLastName", "stFirstName", "grade", "classroom", "tLastName", "tFirstName")
        );
        executeQuery(s -> s.getStLastName().equals(lastName),
                     s -> System.out.println(s.filteredPrint(printAttribs)));
    }

    public void studentLastNameBus(String lastName) {
        ArrayList<String> printAttribs = new ArrayList<String> (
            List.of("stLastName", "stFirstName", "bus")
        );
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
