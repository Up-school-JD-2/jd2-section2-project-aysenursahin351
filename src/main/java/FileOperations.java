import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileOperations {
//Bu sınıf, telefon ve kişi verilerini bir dosyaya kaydetme 
	//ve dosyadan yükleme işlemlerini gerçekleştirmektedir.
	
	//write files 
	public static void writeToFile(List<Phone> phoneList, String fileName) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	        phoneList.stream().forEach(phone -> {
	            Person person = phone.getPerson();
	            try {
	                // Write the data to the file
	                writer.write(person.getName() + "," + person.getSurname() + "," + person.getPhoneNumber() + "," + person.getEmail() + "," + phone.getBrand() + "," + phone.getModel() + "," + phone.getMemory() + "," + phone.getSerialNo() + "," + phone.getOpsys());
	                writer.newLine();
	            } catch (IOException e) {
	                System.out.println("File writing error: " + e.getMessage());
	            }
	        });
	        System.out.println("File writing operation completed.");
	    } catch (IOException e) {
	        System.out.println("File writing error: " + e.getMessage());
	    }
	}


	///Read file
	public static PhoneAndPersonLists readFromFile(String fileName) {
	    List<Phone> phoneList = new ArrayList<>();
	    List<Person> personList = new ArrayList<>();
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<String[]> lines = reader.lines()
                    .map(line -> line.split(","))
                    .collect(Collectors.toList());

            for (String[] parts : lines) {
                if (parts.length == 9) {
                    String name = parts[0];
                    String surname = parts[1];
                    String phoneNumber = parts[2];
                    String email = parts[3];
                    String brand = parts[4];
                    String model = parts[5];
                    String memory = parts[6];
                    String serialNo = parts[7];
                    String opsys = parts[8];

                    Person person = new Person(name, surname, phoneNumber, email);
                    personList.add(person);

                    Phone phone = new Phone(person, brand, model, memory, serialNo, opsys);
                    phoneList.add(phone);
                }
            }
            System.out.println("File reading operation completed.");
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }

	    return  new PhoneAndPersonLists(phoneList, personList);
    }

}
