public class Student {

    private String stLastName;
    private String stFirstName;
    private int grade;
    private int classroom;
    private int bus;
    private double GPA;
    private String tLastName;
    private String tFirstName;

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
      return stFirstName + " " + stLastName + ", " + grade + ", " + classroom + ", " + bus + ", " + GPA + ", " + tFirstName + ", " + tLastName;
    }

}
