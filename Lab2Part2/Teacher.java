public class Teacher{
  private String lastName;
  private String firstName;
  private int classroom;

  public Teacher(){
    lastName = "ERROR";
    firstName = "ERROR";
    classroom = -1;
  }

  public Teacher(String ln, String fn, int room){
    lastName = ln;
    firstName = fn;
    classroom = room;
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
