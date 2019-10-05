public class Teacher{
  private String lastName;
  private String firstName;
  private int classroom; 

  public Teacher(String ln, String fn, int c){
    lastName = ln;
    firstName = fn;
    classroom = c; 
  }

  public String getLastName() {
      return lastName;
  }

  public String getFirstName() {
      return firstName;
  }

  public int getClassroom(){
    return classroom; 
  }

}
