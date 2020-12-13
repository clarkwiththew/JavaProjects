package lab9_project;

/**
 * Person class used as part of too many parameters demonstration.
 */
public class PersonBadApproach1 {

  private String lastName; // required
  private String firstName; // required
  private String dateOfBirth; // required
  private String address; // optional
  private String phoneNumber; // optional
  private String email; // optional

  // Constructor for all required fields
  public PersonBadApproach1(String lastName, String firstName, String dateOfBirth) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.dateOfBirth = dateOfBirth;
  }

  // Constructor with optional address
  public PersonBadApproach1(String lastName, String firstName, String dateOfBirth, String address) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.dateOfBirth = dateOfBirth;
    this.address = address;
  }

  // Constructor with optional address, phone number
  public PersonBadApproach1(String lastName, String firstName, String dateOfBirth,
      String address, String phoneNumber) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.dateOfBirth = dateOfBirth;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  // Constructor with optional address, phone number, email
  public PersonBadApproach1(String lastName, String firstName, String dateOfBirth,
      String address, String phoneNumber, String email) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.dateOfBirth = dateOfBirth;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
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