//Lauren Hibbs, Daniel Deegan
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student {

    private String stLastName;
    private String stFirstName;
    private int grade;
    private int classroom;
    private int bus;
    private double GPA;
    private String tLastName;
    private String tFirstName;

    public Student(){
      stLastName = "ERROR";
      stFirstName = "ERROR";
      grade = -1;
      classroom = -1;
      bus = -1;
      GPA = -1;
      tLastName = "ERROR";
      tFirstName = "ERROR";
    }

    public Student(String ln, String fn, int gr, int cl, int bu, double gp, String tl, String tf){
      stLastName = ln;
      stFirstName = fn;
      grade = gr;
      classroom = cl;
      bus = bu;
      GPA = gp;
      tLastName = tl;
      tFirstName = tf;
    }

    public String getStLastName(){
        return stLastName;
    }

    public String getStFirstName(){
        return stFirstName;
    }

    public int getGrade(){
        return grade;
    }

    public int getClassroom(){
        return classroom;
    }

    public int getBus(){
        return bus;
    }

    public double getGPA(){
        return GPA;
    }

    public String getTLastName(){
        return tLastName;
    }

    public String getTFirstName(){
        return tFirstName;
    }

    public String toString(){
      //System.out.println(stFirstName + " " + stLastName + ", " + tFirstName + " " + tLastName);
      return stFirstName + " " + stLastName + ", " + grade + ", " + classroom + ", " + bus + ", " + GPA + ", " + tFirstName + " " + tLastName;
    }

    public String filteredPrint(List<String> attribs) {
        String s = ""; 
        Iterator<String> it = attribs.iterator(); 
        boolean first = true; 
        while(it.hasNext()) { 
            switch(it.next()){
                case "stLastName": 
                    s += "," + stLastName;
                    break;  
                case "stFirstName": 
                    s += "," + stFirstName; 
                    break;  
                case "grade":
                    s += "," + grade; 
                    break;  
                case "classroom":
                    s += "," + classroom;
                    break;  
                case "bus":
                    s += "," + bus;
                    break;   
                case "GPA" : 
                    s += "," + GPA;
                    break;   
                case "tLastName" : 
                    s += "," + tLastName;
                    break;  
                case "tFirstName": 
                    s += "," + tFirstName;
                    break;   
                default: 
                    System.out.println("error"); 
            }
            //remove the leading comma on first entry
            if(first){
                s = s.substring(1); 
                first = false; 
            }
        }
        return s.trim(); 
    }
}
