//Daniel Deegan, Lauren Hibbs

import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class StudentParser {
    Scanner scan;
    Scanner teacherScan;
    File file;
    File teachers;

    public StudentParser() {
        file = new File("list.txt");
        teachers = new File("teachers.txt");
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException f) {
            System.out.println("list.txt not found");
            System.exit(-1);
        }
        try {
            teacherScan = new Scanner(teachers);
        } catch (FileNotFoundException f) {
            System.out.println("teachers.txt not found");
            System.exit(-1);
        }
        scan.useDelimiter(Pattern.compile(", |\r\n|\n|,"));
        teacherScan.useDelimiter(Pattern.compile(", |\r\n|\n|,"));
    }

    public ArrayList<Student> parse() {
        ArrayList<Student> list = new ArrayList<Student>();
        String fName;
        String lName;
        int grade;
        int classroom;
        int bus;
        double GPA;
        // int num = 0;
        while (scan.hasNext()) {
            // System.out.println("Line " + num);
            // num++;
            try {
                lName = scan.next();
                fName = scan.next();
                grade = scan.nextInt();
                classroom = scan.nextInt();
                bus = scan.nextInt();
                GPA = scan.nextDouble();
                Student s = new Student(lName, fName, grade, classroom, bus, GPA);
                list.add(s);
            } catch (NoSuchElementException i) {
                System.out.println("Invalid list.txt!");
                System.exit(-1);
            }
        }
        return list;
    }

    public HashMap<Integer, List<Teacher>> parseTeachers(){
        HashMap<Integer, List<Teacher>> map = new HashMap<Integer, List<Teacher>>();
        String lName;
        String fName;
        int classroom;
        // int num = 0;
        while (teacherScan.hasNext()) {
            try {
                lName = teacherScan.next();
                fName = teacherScan.next();
                classroom = teacherScan.nextInt();
                Teacher t = new Teacher(lName, fName, classroom);
                if(map.containsKey(classroom)){
                  map.get(classroom).add(t);
                }
                else{
                  ArrayList<Teacher> list = new ArrayList<Teacher>();
                  list.add(t);
                  map.put(classroom, list);
                }
            } catch (NoSuchElementException i) {
                System.out.println("Invalid teachers.txt!");
                System.exit(-1);
            }
        }
        return map;
    }
}
