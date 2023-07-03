import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PersonManagement {
	//filterPersonbyName
	public static Optional<Person> searchPersonByName(List<Person> personList, String name) {
	    Optional<Person> foundPerson = personList.stream()
	            .filter(person -> person.getName().equals(name))
	            .findFirst();
	    
	    if (foundPerson.isPresent()) {
	        System.out.println("Person found: " + foundPerson.get().getName()+" "+foundPerson.get().getSurname());
	        Person.displayPersonInfo(foundPerson);
	    } else {
	        System.out.println("Person not found.");
	    }
	    
	    return foundPerson;
	}
	///searchwithid
	public static Person searchPersonByID(List<Person> personList, int ID) {
	    for (Person person : personList) {
	        if (person.getId() == ID) {
	            System.out.println("Person found: " + person.getName() + " " + person.getSurname());
	            Person.displayPersonInfo(person);
	            return person;
	        }
	    }
	    
	    System.out.println("Person not found.");
	    return null;
	}

//addPerson
	public static List<Person> addPerson(List<Person> personList) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter name: ");
	    String name = scanner.nextLine();

	    System.out.print("Enter surname: ");
	    String surname = scanner.nextLine();

	    
	    System.out.print("Enter phone number: ");
	    String phoneNumber = scanner.nextLine();

	    System.out.print("Enter email: ");
	    String email = scanner.nextLine();

	    Person person = new Person(name, surname, phoneNumber, email);
	    List<Person> updatedList = new ArrayList<>(personList);
	    updatedList.add(person);

	    return updatedList;
	}

///delete person
	public static List<Person> deletePerson(List<Person> personList, int id) {
	    List<Person> updatedList = new ArrayList<>(personList);
	    
	    // Silinecek kişiyi bulma
	    Person personToDelete = null;
	    for (Person person : updatedList) {
	        if (person.getId() == id) {
	            personToDelete = person;
	            break;
	        }
	    }
	    
	    // Kişiyi listeden kaldırma
	    if (personToDelete != null) {
	        updatedList.remove(personToDelete);
	        System.out.println("Person with ID " + id + " has been deleted.");
	    } else {
	        System.out.println("Person with ID " + id + " does not exist.");
	    }
	    
	    return updatedList;
	}
	//edit person
	public static void updatePerson(List<Person> personList, String name) {
	    Scanner scanner = new Scanner(System.in);

	    Optional<Person> optionalPerson = personList.stream()
	            .filter(person -> person.getName().equals(name))
	            .findFirst();

	    if (optionalPerson.isPresent()) {
	        Person person = optionalPerson.get();

	        System.out.print("Enter new name: ");
	        String newName = scanner.nextLine();
	        person.setName(newName);

	        System.out.print("Enter new surname: ");
	        String newSurname = scanner.nextLine();
	        person.setSurname(newSurname);

	        System.out.print("Enter new phone number: ");
	        String newPhoneNumber = scanner.nextLine();
	        person.setPhoneNumber(newPhoneNumber);

	        System.out.print("Enter new email: ");
	        String newEmail = scanner.nextLine();
	        person.setEmail(newEmail);

	        System.out.println("Person updated successfully.");
	    } else {
	        System.out.println("Person not found.");
	    }
	}


}
