//Daniel Deegan, Lauren Hibbs
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class SchoolSearch{

  public static void main(String[] args){
    ArrayList<Student> s = new ArrayList<Student>();
    HashMap<Integer, List<Teacher>> map = new HashMap<Integer, List<Teacher>>();
    StudentParser p = new StudentParser();
    s = p.parse();
    map = p.parseTeachers();
    SchoolSearchCmds searchCmds = new SchoolSearchCmds(s, map);

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
                else if (highLowParam.length > 1 && (highLowParam[1].equals("T") || highLowParam[1].equals("Teacher"))){
                    searchCmds.gradeSearch(Integer.parseInt(highLowParam[0]));
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
            case "Analytics":
                String[] statsParam = searchParam.split(" ");
                if(statsParam.length > 1 && statsParam[1].equals("Grade")){
                    if(statsParam.length > 2 && statsParam[2].equals("All")) {
                        searchCmds.gradeAnalyticsAll(); 
                    } else {
                        searchCmds.gradeAnalytics(Integer.parseInt(statsParam[0])); 
                    }
                }
                else if(statsParam.length > 1 && statsParam[1].equals("Teacher")){
                    if(statsParam.length > 2 && statsParam[2].equals("All")) {
                        searchCmds.teacherAnalyticsAll(); 
                    } else {
                        searchCmds.teacherAnalytics(statsParam[0]); 
                    }
                }
                else if(statsParam.length > 1 && statsParam[1].equals("Bus")){
                    if(statsParam.length > 2 && statsParam[2].equals("All")) {
                        searchCmds.busAnalyticsAll(); 
                    } else {
                        searchCmds.busAnalytics(Integer.parseInt(statsParam[0])); 
                    }
                }
                break;
            case "C":
            case "Classroom":
                String[] teachParam = searchParam.split(" ");
                if(teachParam.length > 1 && (teachParam[1].equals("T") || teachParam[1].equals("Teacher"))){
                    searchCmds.classSearchTeacher(Integer.parseInt(teachParam[0]));
                }
                else if(teachParam.length > 1 && (teachParam[1].equals("E") || teachParam[1].equals("Enrollment"))){
                    searchCmds.classroomList(); 
                }
                else {
                    searchCmds.classSearch(Integer.parseInt(searchParam));
                }
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
