import java.util.List;
import java.util.Optional;

public class Person {
int id;
private static int nextId = 1;
String name;
String surname;
String phoneNumber;
String email;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public Person( String name, String surname, String phoneNumber, String email) {
	super();
   this.id = generateId();
	this.name = name;
	this.surname = surname;
	this.phoneNumber = phoneNumber;
	this.email = email;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public static int getNextId() {
	return nextId;
}
public static void setNextId(int nextId) {
	Person.nextId = nextId;
}
private int generateId() {
    return nextId++;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public static void displayPersonInfo(Person person) {
    System.out.println("Name: " + person.getName());
    System.out.println("Surname: " + person.getSurname());
    System.out.println("Phone Number: " + person.getPhoneNumber());
    System.out.println("Email: " + person.getEmail());
}
public static void displayPersonList(List<Person> personList) {
    for (Person person : personList) {
        System.out.println("Name: " + person.getName());
        System.out.println("Surname: " + person.getSurname());
        System.out.println("Phone Number: " + person.getPhoneNumber());
        System.out.println("Email: " + person.getEmail());
        System.out.println("----------------------------------");
    }
}
public static void displayPersonInfo(Optional<Person> person) {
	   System.out.println("Name: " + person.get().getName());
	    System.out.println("Surname: " + person.get().getSurname());
	    System.out.println("Phone Number: " + person.get().getPhoneNumber());
	    System.out.println("Email: " + person.get().getEmail());	
}

}
