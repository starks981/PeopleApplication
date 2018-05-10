// Person Class
public class Person {
	
	// Private member variables
	private String firstName;
	private String lastName;
	private int age;
	private String maritalStatus;
	private String gender;
	protected static int totPeople = 0;
	protected static final int MAXPEOPLE = 3;
	protected static Person[] people = new Person[MAXPEOPLE];

	// Default Constructor
	Person() {
		firstName = "FIRST";
		lastName = "LAST";
		age = 0;
		maritalStatus = "unknown";
		gender = "unknown";
	}
	// Overloaded Constructor
	Person(String firstName, String lastName, int age, String maritalStatus, String gender) {
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
		setGender(gender);
		setMaritalStatus(maritalStatus);
	}
	// Method that will return a person's full info or simply their first and last name
	String personInfo(boolean bool1) {
		if (bool1) {
			return toString() + "\n" + "Name: " + firstName + " " + lastName + "\nAge: " + age + "\nMarital Status: " + maritalStatus + "\nGender: " + gender;
		} else {
			return toString() + ": " + firstName + " " + lastName;
		}
	}
	// Method that will check to see if a passed in string equals the fullname of a Person
	boolean equals(String fullName) {
		if (fullName.equalsIgnoreCase(firstName + " " + lastName)) {
			return true;
		} else {
			return false;
		}
	}
	// Method that returns the first name of a specified person
	public String getFirstName() {
		return firstName;
	}
	// Method that returns the last name of a specified person
	public String getLastName() {
		return lastName;
	}
	// Method that returns the age of a specified person
	public int getAge() {
		return age;
	}
	// Method that returns the marital status of a specified person
	public String getMaritalStatus() {
		return maritalStatus;
	}
	// Method that returns the gender of a specified person
	public String getGender() {
		return gender;
	}
	// First Name setter
	public void setFirstName(String firstName) {
		this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
	}
	// Last Name setter
	public void setLastName(String lastName) {
		this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
	}
	// Age setter
	public void setAge(int age) {
		if (age < 0) {
			this.age = 0;
		} else {
			this.age = age;
		}
	}
	// Marital Status setter
	public void setMaritalStatus(String maritalStatus) {
		
		if (maritalStatus.equalsIgnoreCase("married")) {
			this.maritalStatus = "Married";
		} 
		else if (maritalStatus.equalsIgnoreCase("single")) {
			this.maritalStatus = "Single";
		} 
		else if (maritalStatus.equalsIgnoreCase("divorced")) {
			this.maritalStatus = "Divorced";
		} 
		else if (maritalStatus.equalsIgnoreCase("widowed")) {
			this.maritalStatus = "Widowed";
		} 
		else {
			this.maritalStatus = "Unknown";
		}
	}
	// Gender Setter
	public void setGender(String gender) {
		if (gender.equalsIgnoreCase("male")) {
			this.gender = "Male";
		}
		else if (gender.equalsIgnoreCase("female")){
			this.gender = "Female";
		}
		else {
			this.gender = "Unknown";
		}
	}
	// Method that returns a list of names of Person Objects
	public static String listPersons() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<totPeople; i++) {
			sb.append(people[i].personInfo(false) + "\n");
		}
		
		return sb.toString();
	}
	// Method that performs a linear search of person's names
	public static int findPerson(String fullName) {
		int result = -1;
		
		for (int i=0; i<totPeople; i++) {	
			if(people[i].equals(fullName)) {
				result = i;
			}
		}
		return result;
	}
	// Method that will add a new person object
	public static boolean addPerson(String firstName, String lastName, int age, String gender, String maritalStatus) {
		if(totPeople == MAXPEOPLE) {
			return false;
		}
		else {
			people[totPeople] = new Person(firstName, lastName, age, gender, maritalStatus);
			totPeople++;
			return true;
		}
	}
	// Method that will calculate the average age of person objects
	public static double averageAge() {
		double age = 0.0;
		for(int i=0; i<totPeople; i++) {
			age += people[i].getAge();
		}
		return age/totPeople;
	}
	// Method that will return the array index of a person object
	public static Person getPerson(int index) {
		return people[index];
	}
	// Method that will check to ensure there is at least 1 person object
	public static boolean isEmpty() {
		if(totPeople == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	// Override toString method
	public String toString() {
		return "Person";
	}
	
}
