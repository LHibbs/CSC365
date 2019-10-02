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
        file = new File("teachers.txt");
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException f) {
            System.out.println("list.txt not found");
            System.exit(-1);
        }
        try {
            teacherScan = new Scanner(file);
        } catch (FileNotFoundException f) {
            System.out.println("teachers.txt not found");
            System.exit(-1);
        }
        scan.useDelimiter(Pattern.compile(",|\r\n|\n"));
        teacherScan.useDelimiter(Pattern.compile(",|\r\n|\n"));
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
                System.out.println("Invalid file!");
                System.exit(-1);
            }
        }
        return list;
    }

    public ArrayList<Teacher> parseTeachers(){
        ArrayList<Teacher> list = new ArrayList<Teacher>();
        String lName;
        String fName;
        int classroom;
        // int num = 0;
        while (scan.hasNext()) {
            try {
                lName = scan.next();
                fName = scan.next();
                classroom = scan.nextInt();
                Teacher t = new Teacher(lName, fName, classroom);
                list.add(t);
            } catch (NoSuchElementException i) {
                System.out.println("Invalid file!");
                System.exit(-1);
            }
        }
        return list;
    }
}
