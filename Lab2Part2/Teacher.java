public class Teacher{
  private String lastName;
  private String firstName;
  private int classroom;

  public Teacher(){
    lastname = "ERROR";
    firstName = "ERROR";
    classroom = -1;
  }

  public Teacher(String ln, String fn, int class){
    lastName = ln;
    firstName = fn;
    classroom = class;
  }

  public String getLastName() {
      return lastName;
  }

  public String getFirstName() {
      return firstName;
  }

  public int getClassroom() {
      return classroom;
  }
}
