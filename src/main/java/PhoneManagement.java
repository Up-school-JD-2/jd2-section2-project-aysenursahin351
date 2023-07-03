import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneManagement {
//Kullanıcı, telefonun marka, model, seri numarası, depolama alanı 
	//ve işletim sistemi gibi bilgilerini girerek yeni telefonları sisteme ekleyebilmelidir.
	//addPhone function 
	
	public static List<Phone> addNewPhone(List<Phone> phoneList) {
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Enter the person's name: ");
	    String name = scanner.nextLine();
	    
	    System.out.println("Enter the person's surname: ");
	    String surname = scanner.nextLine();
	    
	    System.out.println("Enter the person's phone number: ");
	    String phoneNumber = scanner.nextLine();
	    
	    System.out.println("Enter the person's email: ");
	    String email = scanner.nextLine();
	    
	    Person person = new Person(name, surname, phoneNumber, email);
	    
	    System.out.println("Enter the phone's brand: ");
	    String brand = scanner.nextLine();
	    
	    System.out.println("Enter the phone's model: ");
	    String model = scanner.nextLine();
	    
	    System.out.println("Enter the phone's memory: ");
	    String memory = scanner.nextLine();
	    
	    System.out.println("Enter the phone's serial number: ");
	    String serialNo = scanner.nextLine();
	    
	    System.out.println("Enter the phone's operating system: ");
	    String opsys = scanner.nextLine();
	    
	    Phone newPhone = new Phone(person, brand, model, memory, serialNo, opsys);
	    
	    return Stream.concat(phoneList.stream(), Stream.of(newPhone))
	            .collect(Collectors.toList());
	}
	public static List<Phone> addPhone(List<Phone> phoneList,List<Person> personList) {
	    Scanner scanner = new Scanner(System.in);
	    
	    Person person=PersonManagement.searchPersonByID(personList,  2);
	    if(person!=null) {
	    	   System.out.println("Enter the phone's brand: ");
	   	    String brand = scanner.nextLine();
	   	    
	   	    System.out.println("Enter the phone's model: ");
	   	    String model = scanner.nextLine();
	   	    
	   	    System.out.println("Enter the phone's memory: ");
	   	    String memory = scanner.nextLine();
	   	    
	   	    System.out.println("Enter the phone's serial number: ");
	   	    String serialNo = scanner.nextLine();
	   	    
	   	    System.out.println("Enter the phone's operating system: ");
	   	    String opsys = scanner.nextLine();
	   	 Phone newPhone = new Phone(person, brand, model, memory, serialNo, opsys);
		    
		    return Stream.concat(phoneList.stream(), Stream.of(newPhone))
		            .collect(Collectors.toList());
	    }
	    
	    else {
	    	return null;
	    }
	    
	   
	}
	public static Phone findPhoneByID(List<Phone> phoneList, int id) {
	    for (Phone phone : phoneList) {
	        if (phone.getId() == id) {
	            return phone;
	        }
	    }
	    return null;
	}

	public static Optional<Phone> searchPhoneName(List<Phone> phoneList, String name) {
	    Optional<Phone> foundPhone = phoneList.stream()
	            .filter(phone -> phone.getPerson().getName().equals(name))
	            .findFirst();

	    if (foundPhone.isPresent()) {
	        System.out.println("Phone found:");
	        Phone.displayPhoneInfo(foundPhone.get());
	    } else {
	        System.out.println("Phone not found.");
	    }

	    return foundPhone;
	}
	public static List<Phone> deletePhone(List<Phone> phoneList, int id) {
		List<Phone> updatedList = new ArrayList<>(phoneList);
	    
	    Phone phoneToDelete = null;
	    for (Phone phone : updatedList) {
	        if (phone.getId() == id) {
	        	phoneToDelete = phone;
	            break;
	        }
	    }
	    
	    if (phoneToDelete != null) {
	        updatedList.remove(phoneToDelete);
	        System.out.println("Phone with ID " + id + " has been deleted.");
	    } else {
	        System.out.println("Phone with ID " + id + " does not exist.");
	    }
	    
	    return updatedList;
	}
	public static void updatePhone(List<Phone> phoneList, String updateName) {
	    Scanner scanner = new Scanner(System.in);

	    phoneList.stream()
	            .filter(phone -> phone.getPerson().getName().equals(updateName))
	            .findFirst()
	            .ifPresent(phone -> {
	                System.out.println("Enter the updated brand:");
	                String updatedBrand = scanner.nextLine();
	                phone.setBrand(updatedBrand);

	                System.out.println("Enter the updated model:");
	                String updatedModel = scanner.nextLine();
	                phone.setModel(updatedModel);

	                System.out.println("Enter the updated memory:");
	                String updatedMemory = scanner.nextLine();
	                phone.setMemory(updatedMemory);

	                System.out.println("Enter the updated serial number:");
	                String updatedSerialNo = scanner.nextLine();
	                phone.setSerialNo(updatedSerialNo);

	                System.out.println("Enter the updated operating system:");
	                String updatedOpsys = scanner.nextLine();
	                phone.setOpsys(updatedOpsys);

	                System.out.println("Phone updated successfully.");
	            });
	}

}