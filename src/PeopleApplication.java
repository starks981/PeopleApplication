/* Created by Chris Starkey
 * 5/10/2018
 * 
 */

import javax.swing.JOptionPane;

public class PeopleApplication {
	// Main Method
	public static void main(String[] args) {
		// Create variables to run the menu driven loop
		int selection = 0;
		String choice = new String();
		boolean showMenu = true;

		do {
			try {
				// Show the menu unless a selection has been made on the error menu
				if (showMenu) {
					choice = menuChoice();
				}
				// Set the choice string to 6 if the user has clicked cancel or the exit button
				if (choice == null) {
					choice = "6";
				}
				// Ensure the user has entered a number
				selection = Integer.parseInt(choice);
				// Switch statement to perform the proper option as selected by the user
				switch (selection) {
				// If the user enters 1, ask if it will be a person, student or faculty and collect the information about the new object
				case 1: {
					showMenu = true;
					String personType = JOptionPane.showInputDialog(null,
							"What type of Person will this be?\n\nEnter:\n(1) for a Regular Person\n"
									+ "(2) for a Faculty Member\n(3) for a Student",
							"Person Data Input", JOptionPane.DEFAULT_OPTION);
					// Check to ensure the user enters a valid entry
					if(personType == null) {
						choice = showErrorMenu();
						showMenu = false;
						break;
					}
					// Ensure the user has entered a number and its a 1,2 or 3
					int type = Integer.parseInt(personType);
					
					if(type!=1 && type!=2 && type!=3) {
						choice = showErrorMenu();
						showMenu = false;
						break;
					}
					// Collect the person's info
					String firstName = JOptionPane.showInputDialog(null, "Enter the First Name", "Person Data Input",
							JOptionPane.DEFAULT_OPTION);
					String lastName = JOptionPane.showInputDialog(null, "Enter the Last Name", "Person Data Input",
							JOptionPane.DEFAULT_OPTION);
					int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Age", "Person Data Input",
							JOptionPane.DEFAULT_OPTION));
					String gender = JOptionPane.showInputDialog(null, "Enter the Gender", "Person Data Input",
							JOptionPane.DEFAULT_OPTION);
					String maritalStatus = JOptionPane.showInputDialog(null, "Enter the Marital Status",
							"Person Data Input", JOptionPane.DEFAULT_OPTION);
					
					// Boolean to check if the person was added successfully
					boolean added = true;
					// Regular person constructor called
					if(type == 1) {
						added = Person.addPerson(firstName, lastName, age, maritalStatus, gender);
					}
					// Faculty constructor called
					else if (type == 2) {
						String rank = JOptionPane.showInputDialog(null, "Enter the Rank", "Person Data Input",
								JOptionPane.DEFAULT_OPTION);
						added = Faculty.addFaculty(firstName, lastName, age, maritalStatus, gender, rank);
					}
					// Student constructor called
					else if (type == 3) {
						String major = JOptionPane.showInputDialog(null, "Enter the Major", "Person Data Input", JOptionPane.DEFAULT_OPTION);
						String classStanding = JOptionPane.showInputDialog(null, "Enter the Class Standing", "Person Data Input", JOptionPane.DEFAULT_OPTION);
						String gpa = JOptionPane.showInputDialog(null, "Enter the GPA", "Person Data Input", JOptionPane.DEFAULT_OPTION);
						
						double stuGpa = Double.parseDouble(gpa);
						added = Student.addStudent(firstName, lastName, age, maritalStatus, gender, major, classStanding, stuGpa);
					}
					// If the user was added successfully show a success message, else display a failure
					if (added) {
						JOptionPane.showMessageDialog(null, "Person Added", "Success", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Insufficient Space to Add Person", "Failure",
								JOptionPane.WARNING_MESSAGE);
					}
					break;
				}
				/* If the user enters 2 check to ensure there are person objects already
				created, if so list them, if not alert the user there are no people */
				case 2: {
					showMenu = true;
					if (Person.isEmpty()) {
						JOptionPane.showMessageDialog(null, "There are no people in the list", "People List",
								JOptionPane.INFORMATION_MESSAGE);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "List of People Below:\n" + Person.listPersons(),
								"People List", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
				/* If the user enters 3 check to ensure there are person objects already
				created, if so perform a linear search, if not alert the user there are no
				people */
				case 3: {
					showMenu = true;
					if (Person.isEmpty()) {
						JOptionPane.showMessageDialog(null, "There are no people in the list", "People List",
								JOptionPane.INFORMATION_MESSAGE);
						break;
					} else {
						String personSearch = JOptionPane.showInputDialog(null,
								"Enter the first and last name of the person to search for", "Person Search",
								JOptionPane.QUESTION_MESSAGE);
						int index = Person.findPerson(personSearch);
						if (index == -1) {
							JOptionPane.showMessageDialog(null, "Sorry, person cannot be found", "Search Failure",
									JOptionPane.WARNING_MESSAGE);
							break;
						} else {
							Person person1 = Person.getPerson(index);
							JOptionPane.showMessageDialog(null, person1.personInfo(true), "Person Information",
									JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}

				}
				/* If the user enters 4 check to ensure there are person objects already
				created, if so calculate their average age, if not alert the user there are
				no people*/
				case 4: {
					showMenu = true;
					if (Person.isEmpty()) {
						JOptionPane.showMessageDialog(null, "There are no people in the list", "People List",
								JOptionPane.INFORMATION_MESSAGE);
						break;
					} else {
						JOptionPane.showMessageDialog(null, Person.averageAge(), "Average Age",
								JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
				/* If the user enters 5 check to ensure there are person objects already created
				 * if so calculate how many students are in the array and display the avg GPA
				 */
				case 5: {
					showMenu = true;
					if (Person.isEmpty()) {
						JOptionPane.showMessageDialog(null, "There are no people in the list", "People List",
								JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, Student.showOverallGpa(), "Student GPA", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					
				}
				// if the user enters 6 exit the program
				case 6: {
					JOptionPane.showMessageDialog(null, "Goodbye", "End Program", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				default :{
					choice = showErrorMenu();
					showMenu = false;
				}
				}
			}
			// Catch any exceptions and show the error menu to the user
			catch (Exception e) {
				choice = showErrorMenu();
				showMenu = false;
			}
			// if the user enters 6 exit the menu driven loop
		} while (selection != 6);

	}

	// Method that will show a menu to the end user
	static String menuChoice() {

		String choice = JOptionPane.showInputDialog(null,
				"\nChoices are:\n\t(1) Add New Person\n\t(2) List People\n\t(3) Display Information about a Person"
						+ "\n\t(4) Display the Average Age of the People\n\t(5) List the average GPA of all Students\n\t(6) Quit\n\nWhat is your choice?",
				"Welcome to the People Application", JOptionPane.QUESTION_MESSAGE);

		return choice;

	}

	// Method that will show an error menu to the end user
	static String showErrorMenu() {

		String choice = JOptionPane.showInputDialog(null,
				"***Inavlid choice, please try again\n\nChoices are:\n\t(1) Add New Person\n\t(2) List People\n\t(3) Display Information about a Person"
						+ "\n\t(4) Display the Average Age of the People\n\t(5) List the average GPA of all Students\n\t(6) Quit\n\nWhat is your choice?",
				"Welcome to the People Application", JOptionPane.QUESTION_MESSAGE);
		return choice;
	}
}
