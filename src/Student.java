
public class Student extends Person {
	// Private member variables
	private String major;
	private String classStanding;
	private double gpa;
	// Default Constructor
	Student() {
		super();
		major = "Undeclared";
		classStanding = "Freshman";
		gpa = 0.0;
	}
	// Overloaded Constructor
	Student(String firstName, String lastName, int age, String maritalStatus, String gender, String major,
			String classStanding, double gpa) {
		super(firstName, lastName, age, maritalStatus, gender);
		setMajor(major);
		setClassStanding(classStanding);
		setGpa(gpa);
	}
	// Set method for the major variable
	public void setMajor(String major) {
		if (major.equalsIgnoreCase("CIS")) {
			this.major = "CIS";
		} else if (major.equalsIgnoreCase("Marketing")) {
			this.major = "Marketing";
		} else if (major.equalsIgnoreCase("Management")) {
			this.major = "Management";
		} else if (major.equalsIgnoreCase("Finance")) {
			this.major = "Finance";
		} else if (major.equalsIgnoreCase("Accounting")) {
			this.major = "Accounting";
		} else {
			this.major = "Undeclared";
		}
	}
	// Set method for the Class Standing variable
	public void setClassStanding(String classStanding) {
		if (classStanding.equalsIgnoreCase("freshman")) {
			this.classStanding = "Freshman";
		} else if (classStanding.equalsIgnoreCase("sophmore")) {
			this.classStanding = "Sophmore";
		} else if (classStanding.equalsIgnoreCase("junior")) {
			this.classStanding = "Junior";
		} else if (classStanding.equalsIgnoreCase("senior")) {
			this.classStanding = "Senior";
		} else {
			this.classStanding = "Freshman";
		}
	}
	// Set method for the GPA variable
	public void setGpa(double gpa) {
		if (gpa > 0.0 && gpa <= 4.0) {
			this.gpa = gpa;
		} else {
			this.gpa = 0.0;
		}
	}
	// Get method for the major variable
	public String getMajor() {
		return this.major;
	}
	// Get method for the class standing variable
	public String getClassStanding() {
		return this.classStanding;
	}
	// Get method for the GPA variable
	public double getGpa() {
		return this.gpa;
	}
	// Override the toString method
	public String toString() {
		return "Student";
	}
	// Method that will return a person's full info or simply their first and last name as well as their 
	String personInfo(boolean bool1) {
		if (bool1) {
			return super.personInfo(true) + "\nMajor: " + getMajor() + "\nClass Standing: " + getClassStanding() + "\nGPA: " + getGpa();
		} else {
			return super.personInfo(false);
		}
	}
	// Method to calculate the overall GPA of all the students in the people array
	public static String showOverallGpa() {

		double num = 0.0;
		int count = 0;

		for (int i = 0; i < totPeople; i++) {
			if (people[i] instanceof Student) {
				num += ((Student)people[i]).getGpa();
				count++;
			}
		}
		return "There are " + count + " students and the overall GPA is: " + num / count;
	}

	// Method that will add a new student object to the people array
	public static boolean addStudent(String firstName, String lastName, int age, String maritalStatus, String gender,
			String major, String classStanding, double gpa) {
		if (totPeople == MAXPEOPLE) {
			return false;
		} else {
			people[totPeople] = new Student(firstName, lastName, age, maritalStatus, gender, major, classStanding, gpa);
			totPeople++;
			return true;
		}
	}
}
