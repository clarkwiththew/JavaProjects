package lab9_project;

public class Person {

  //there should be 6 fields
  private final String lastName;  // required
  private final String email;  // optional

  private final String firstName;
  private final String address;
  private final String dateOfBirth;
  private final String phoneNumber;

  private Person(Builder builder) {
    this.address = builder.address;
    this.email = builder.email;
    this.phoneNumber = builder.phoneNumber;
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.dateOfBirth = builder.dateOfBirth;
  }

  public static class Builder {

    private final String lastName;  // required
    private final String dateOfBirth;  // optional

    private final String firstName;

    private String address = "123-DEF-AULT"; // optional
    private String email = "123-DEF-AULT"; // optional
    //TODO

    // optional parameters (3)-initialized to default values
    // (of course these should be more reasonable default values)
    // why are these not final?
    private String phoneNumber = "123-DEF-AULT";
    //TODO

    // Builder constructor with required fields (3)
    public Builder(String fName, String lName, String date) {
      this.firstName = fName;
      this.dateOfBirth = date;
      this.lastName = lName;
    }

    //methods below are to change the default values of the optional parameters
    public Builder address(String address) {
      this.address = address;
      return this;

    }

    public Builder phoneNumber(String number) {
      this.phoneNumber = number;
      return this;
    }

    public Builder email(String email) {
      //TODO
      this.email = email;
      return this;
    }

    public Person build() {
      Person person = new Person(this);

      return person;

    }
  }

  public String toString() {
    String fname = "First name: " + this.firstName;
    String lname = "Last name: " + this.lastName;
    String address = "Address: " + this.address;
    String dob = "Date of birth: " + this.dateOfBirth;
    String number = "Number: " + this.phoneNumber;
    String email = "Email: " + this.email;
    return fname + "\n" + lname + "\n" + dob + "\n" + address + "\n" + number + "\n" + email + "\n";
  }
}
