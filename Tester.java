import java.util.ArrayList;
public class Tester{
  public static void main(){
    ArrayList<Student> s = new ArrayList<Student>();
    StudentParser p = new StudentParser();
    s = p.parse();
    for(Student g : s){
      System.out.println(g);
    }
  }
}
