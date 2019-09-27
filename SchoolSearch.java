import java.util.ArrayList;

public class SchoolSearch{

    ArrayList<Student> students; 

    public SchoolSearch(ArrayList<Student> students){
        this.students = students; 
    }

    public void studentByLastName(String lastName){
        ArrayList<Student> results = new ArrayList<Student>(); 
        for(Student s : students) {
            if(s.getStLastName().equals(lastName)){
                results.add(s); 
            }
        }
        
    }


}