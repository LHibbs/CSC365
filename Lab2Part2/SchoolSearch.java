//Daniel Deegan, Lauren Hibbs
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class SchoolSearch{

  public static void main(String[] args){
    ArrayList<Student> s = new ArrayList<Student>();
    ArrayList<Teacher> t = new ArrayList<Teacher>();
    HashMap<Integer, List<Teacher>> map = new HashMap<Integer, List<Teacher>>();
    StudentParser p = new StudentParser();
    s = p.parse();
    map = p.parseTeachers();
    SchoolSearchCmds searchCmds = new SchoolSearchCmds(s, t, map);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter search command: ");
    String inputLine = scanner.nextLine();
    String[] inputs = inputLine.split(":");
    String input = inputs[0].trim();
    String searchParam = "";

    while(!input.equals("Quit") && !input.equals("Q")){
        if(inputs.length > 1) {
            searchParam = inputs[1].trim();
        }
        else {
            searchParam = "";
        }

        switch(input){
            case "S":
            case "Student":
                String[] busParam = searchParam.split(" ");
                if(busParam.length > 1 && (busParam[1].equals("B") || busParam[1].equals("Bus"))){
                    searchCmds.studentLastNameBus(busParam[0]);
                }
                else {
                    searchCmds.studentLastName(searchParam);
                }
                break;
            case "T":
            case "Teacher":
                searchCmds.teacherLastName(searchParam);
                break;
            case "G":
            case "Grade":
                String[] highLowParam = searchParam.split(" ");
                if(highLowParam.length > 1 && (highLowParam[1].equals("H") || highLowParam[1].equals("High"))){
                    try{
                     searchCmds.gradeHigh(Integer.parseInt(highLowParam[0]));
                    }
                    catch(NumberFormatException e){
                    }
                }
                else if (highLowParam.length > 1 && (highLowParam[1].equals("L") || highLowParam[1].equals("Low"))){
                    searchCmds.gradeLow(Integer.parseInt(highLowParam[0]));
                }
                else {
                    try{
                     searchCmds.grade(Integer.parseInt(highLowParam[0]));
                    }
                    catch(NumberFormatException e){
                    }
                }
                break;
            case "B":
            case "Bus":
                try{
                  searchCmds.bus(Integer.parseInt(searchParam));
                }
                catch(NumberFormatException e){
                }
                break;
            case "A":
            case "Average":
                try{
                   searchCmds.average(Integer.parseInt(searchParam));
                }
                catch(NumberFormatException e){
                }
                break;
            case "I":
            case "Info":
                searchCmds.info();
                break;
            default:
                break;
        }

        System.out.print("\nEnter search command: ");
        inputLine = scanner.nextLine();
        inputs = inputLine.split(":");
        input = inputs[0].trim();
    }
  }
}
