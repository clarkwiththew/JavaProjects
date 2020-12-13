package lab9_project;

public class TestPersonBadApproach2 {

	public static void main(String[] args) {

		PersonBadApproach2 Harry = new PersonBadApproach2();
		System.out.println(Harry);
		

		Harry.setFirstName("Harry");
		Harry.setLastName("Potter");
		Harry.setAddress("4 Privet Drive");
		Harry.setPhoneNumber("123");
		Harry.setDateOfBirth("111");
		Harry.setEmail("seeker@hogwarts.uk");
		System.out.println(Harry);

	}

}
