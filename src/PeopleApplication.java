/* Created by Chris Starkey
 * 5/27/2018
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
				// Set the choice string to 5 if the user has clicked cancel or the exit button
				if (choice == null){
					choice = "5";
				}
				// Ensure the user has entered a number
				selection = Integer.parseInt(choice);
				// Switch statement to perform the proper option as selected by the user
				switch (selection) {
				// If the user enters 1, collect the information about the new person
				case 1: {
					showMenu = true;
					String firstName = JOptionPane.showInputDialog(null, "Enter the first name", "Person Data Input", JOptionPane.DEFAULT_OPTION);
					String lastName = JOptionPane.showInputDialog(null, "Enter the last name", "Person Data Input", JOptionPane.DEFAULT_OPTION);
					int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the age" , "Person Data Input", JOptionPane.DEFAULT_OPTION));
					String gender = JOptionPane.showInputDialog(null, "Enter the gender", "Person Data Input", JOptionPane.DEFAULT_OPTION);
					String maritalStatus = JOptionPane.showInputDialog(null, "Enter the marital status", "Person Data Input", JOptionPane.DEFAULT_OPTION);
					
					if(Person.addPerson(firstName, lastName, age, maritalStatus, gender)) {
						JOptionPane.showMessageDialog(null, "Person Added", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Insufficient Space to Add Person", "Failure", JOptionPane.WARNING_MESSAGE);
					}
					break;
				}
				// If the user enters 2 check to ensure there are person objects already created, if so list them, if not alert the user there are no people
				case 2 : {
					showMenu = true;
					if(Person.isEmpty()){
						JOptionPane.showMessageDialog(null, "There are no people in the list", "People List", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, "List of People Below:\n" + Person.listPersons(), "People List", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
				// If the user enters 3 check to ensure there are person objects already created, if so perform a linear search, if not alert the user there are no people
				case 3 :{
					showMenu = true;
					if(Person.isEmpty()) {
						JOptionPane.showMessageDialog(null, "There are no people in the list", "People List", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					else {
						String personSearch = JOptionPane.showInputDialog(null,"Enter the first and last name of the person to search for", "Person Search", JOptionPane.QUESTION_MESSAGE);
						int index = Person.findPerson(personSearch);
						if (index == -1) {
							JOptionPane.showMessageDialog(null, "Sorry, person cannot be found", "Search Failure", JOptionPane.WARNING_MESSAGE);
							break;
						}
						else {
						Person person1 = Person.getPerson(index);
						JOptionPane.showMessageDialog(null, person1.personInfo(true),"Person Information", JOptionPane.INFORMATION_MESSAGE);
						break;
						}
					}
				
				}
				// If the user enters 4 check to ensure there are person objects already created, if so calculate their average age, if not alert the user there are no people
				case 4 :{
					showMenu = true;
					if(Person.isEmpty()){
						JOptionPane.showMessageDialog(null, "There are no people in the list", "People List", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, Person.averageAge(), "Average Age", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
				// if the user enters 5 exit the program
				case 5: {
					JOptionPane.showMessageDialog(null, "Goodbye", "End Program", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				}
			}
			// Catch any exceptions and show the error menu to the user
			catch (Exception e) {
				 choice = showErrorMenu();
				 showMenu = false;
			}
			// if the user enters 5 exit the menu driven loop
		} while (selection != 5);

	}
	// Method that will show a menu to the end user
	static String menuChoice() {

		String choice = JOptionPane.showInputDialog(null,
				"\nChoices are:\n\t(1) Add New Person\n\t(2) List People\n\t(3) Display Information about a Person"
						+ "\n\t(4) Display the Average Age of the People\n\t(5) Quit\n\nWhat is your choice?",
				"Welcome to the People Application", JOptionPane.QUESTION_MESSAGE);

		return choice;
		
	}
	// Method that will show an error menu to the end user
	static String showErrorMenu() {
		
		String choice = JOptionPane.showInputDialog(null,
				"***Inavlid choice, please try again\n\nChoices are:\n\t(1) Add New Person\n\t(2) List People\n\t(3) Display Information about a Person"
						+ "\n\t(4) Display the Average Age of the People\n\t(5) Quit\n\nWhat is your choice?",
				"Welcome to the People Application", JOptionPane.QUESTION_MESSAGE);
		return choice;
	}
}
