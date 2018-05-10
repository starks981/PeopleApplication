
public class Faculty extends Person {
	// Private member variables
	private String rank;
	
	// Default Constructor
	Faculty() {
		super();
		this.rank = "Assistant Professor";
	}
	// Overloaded Constructor
	Faculty(String firstName, String lastName, int age, String maritalStatus, String gender, String rank) {
		super(firstName, lastName, age, maritalStatus, gender);
		setRank(rank);
	}
	// Set method for the private rank variable
	public void setRank(String rank) {
		if (rank.equalsIgnoreCase("instructor")) {
			this.rank = "Instructor";
		} else if (rank.equalsIgnoreCase("assistant professor")) {
			this.rank = "Assistant Professor";
		} else if (rank.equalsIgnoreCase("associate professor")) {
			this.rank = "Associate Professor";
		} else if (rank.equalsIgnoreCase("full professor")) {
			this.rank = "Full Professor";
		} else {
			this.rank = "Assistant Professor";
		}
	}
	// Get method for the rank variable
	public String getRank() {
		return this.rank;
	}
	// Override toString method
	public String toString() {
		return "Faculty";
	}

	// Method that will return a person's full info or simply their first and last name as well as their 
	String personInfo(boolean bool1) {
		if (bool1) {
			return super.personInfo(true) + "\nRank: " + getRank();
		} else {
			return super.personInfo(false);
		}
	}
	// Method that will add a new faculty object to the people array
	public static boolean addFaculty(String firstName, String lastName, int age, String gender, String maritalStatus, String rank) {
		if(totPeople == MAXPEOPLE) {
			return false;
		}
		else {
			people[totPeople] = new Faculty(firstName, lastName, age, gender, maritalStatus, rank);
			totPeople++;
			return true;
		}
	}

}
