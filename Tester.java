import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Tester{

  public static void main(String[] args){
    ArrayList<Student> s = new ArrayList<Student>();
    StudentParser p = new StudentParser();
    s = p.parse();
    /*for(Student g : s){
      System.out.println(g);
    }*/
    SchoolSearch searchCmds = new SchoolSearch(s); 

    Scanner scanner = new Scanner(System.in);
    String inputLine = scanner.nextLine(); 
    String[] inputs = inputLine.split(":");
    String input = inputs[0].trim(); 
    String searchParam; 

    while(!input.equals("Quit") && !input.equals("Q")){
        System.out.println(inputs[0]);
        System.out.println(inputs[1]);
        searchParam = inputs[1].trim(); 
        switch(input){
            case "S":
            case "Student": 
                System.out.println("student"); 
                String[] busParam = searchParam.split(" "); 
                if(busParam.length > 1 && (busParam[1].equals("B") || busParam[1].equals("Bus"))){
                    System.out.println("Bus"); 
                    searchCmds.studentLastNameBus(busParam[0]);
                }  
                else {
                    searchCmds.studentLastName(searchParam);
                }
            break; 
            default:
                System.out.println("polling error"); 
        }


        inputLine = scanner.nextLine(); 
        inputs = inputLine.split(":");
        input = inputs[0].trim(); 
    }

    System.out.println("quit");

  }
}
