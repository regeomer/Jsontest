package interview.executable;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class CustomerData {

	private String firstName;
	private String lastName;
	private int age;
	private Address address;
	private PhoneNumbers[] phoneNumbers;

	public CustomerData(String firstName, String lastName, int age, final String streetAddress, final String city,
			int postalCode, String type, String number) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = new Address(streetAddress, city, postalCode);
		PhoneNumbers phone = new PhoneNumbers(type, number);
		this.phoneNumbers = new PhoneNumbers[] { phone };
	}

	@JsonAutoDetect(fieldVisibility = Visibility.ANY)
	class Address {

		private String streetAddress;
		private String city;
		private int postalCode;

		public Address(String streetAddress, String city, int postalCode) {
			this.streetAddress = streetAddress;
			this.city = city;
			this.postalCode = postalCode;
		}
	}

	@JsonAutoDetect(fieldVisibility = Visibility.ANY)
	class PhoneNumbers {

		private String type;
		private String number;

		public PhoneNumbers(String type, String number) {
			this.type = type;
			this.number = number;
		}

	}
}
