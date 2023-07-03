import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Phone> phoneList = new ArrayList<>();
	static List<Person> personList = new ArrayList<>();
	static List<App> appList = new ArrayList<>();

	static //You can change path
	String filePath="C:\\Users\\ayşe nur şahin\\Desktop\\phones.txt";
	static Scanner scanner=new Scanner(System.in);


	public static void main(String[] args) {
		//Default persons 
		Person person1 = new Person("John", "Doe", "1234567890", "john.doe@example.com");
		Person person2 = new Person("Jane", "Smith", "9876543210", "jane.smith@example.com");
		Person person3 = new Person("Alice", "Johnson", "5555555555", "alice.johnson@example.com");
		Person person4 = new Person("Bob", "Brown", "1111111111", "bob.brown@example.com");
		Person person5 = new Person("Emma", "Davis", "9999999999", "emma.davis@example.com");
     //Default phones
		Phone phone1 = new Phone(person1, "Samsung", "Galaxy S20", "128GB", "1234567890", "Android");
		Phone phone2 = new Phone(person2, "Apple", "iPhone 12", "256GB", "9876543210", "iOS");
		Phone phone3 = new Phone(person3, "Google", "Pixel 5", "64GB", "5555555555", "Android");
		Phone phone4 = new Phone(person4, "OnePlus", "9 Pro", "256GB", "1111111111", "Android");
		Phone phone5 = new Phone(person5, "Xiaomi", "Mi 11", "128GB", "9999999999", "Android");
		
		phoneList.add(phone1);
		phoneList.add(phone2);
		phoneList.add(phone3);
		phoneList.add(phone4);
		phoneList.add(phone5);

		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		personList.add(person5);
		
		String newAppName = "MyApp";
		String newVersion = "1.0";
		String newAppMemory = "10";
		appList.add(new App(newAppName, newVersion, newAppMemory,phone1));
	Menu();
    String choice = scanner.nextLine(); 
    processChoice(choice);

}
	public static void processChoice(String choice) {
		while(!choice.equals(Constants.EXIT)) {
		 switch (choice) {
	       case Constants.APP_MANAGEMENT:
	           System.out.println("You chose General App Management");
	           System.out.println("You can back to Menu Press M");
	           System.out.println("Do you want to delete App? Press D");
	           System.out.println("Do you want to search App? Press S");
	           System.out.println("Do you want to edit/change App? Press C");
	           System.out.println("Do you want to add App? Press A");
	           String dataChoice = scanner.nextLine();            
	           if (dataChoice.equalsIgnoreCase(Constants.DELETE)) {
	        	  System.out.println("Type app name  which app delete please.");
	        	 String nameToDelete=scanner.nextLine();
	        	  appList=AppManagement.deleteApp(appList, nameToDelete);
                    App.displayAppList(appList);
	           }
	           else if (dataChoice.equalsIgnoreCase(Constants.SEARCH)) {
		        System.out.println("Type app name which app search please.");
				String searchName=scanner.nextLine();    
				AppManagement.searchAppName(appList, searchName);
			   }
	           else if (dataChoice.equalsIgnoreCase(Constants.UPDATE)) {
	        	   System.out.println("Type app name which app update please.");
					String updateName=scanner.nextLine();    
					AppManagement.updateApp(appList,updateName);
					System.out.println("New App List");
	                   App.displayAppList(appList);

               }
	           else if (dataChoice.equalsIgnoreCase(Constants.ADD)) {
	        	   appList=AppManagement.addApp(appList,phoneList);		
                   App.displayAppList(appList);
               }
	           else if (dataChoice.equalsIgnoreCase(Constants.MENU)) {
	        	   Menu();
	        	   choice = scanner.nextLine(); 
	        	   processChoice(choice);
               }
	           else if(dataChoice.equals(Constants.EXIT)) {
	        	   choice="0";
	        	   System.out.println("You logged out of the application ");
	        	   break;
	        	   
	           }
	           else {
	        	   System.out.println("You have to choose.options or press the M for back to Menu");
	           }

	           break;
	       case Constants.PERSON_MANAGEMENT:
	           System.out.println("You chose Person Management");
	           System.out.println("You can back to Menu Press M");
	           System.out.println("Do you want to delete Person? Press D");
	           System.out.println("Do you want to search person? Press S");
	           System.out.println("Do you want to edit/change person? Press C");
	           System.out.println("Do you want to add person? Press A");
	          	           
	           String dataChoice1 = scanner.nextLine();            
	           if (dataChoice1.equalsIgnoreCase(Constants.DELETE)) {
	        	  System.out.println("Type person id  which person delete please.");
	        	  int idToDelete=scanner.nextInt();
	        	  personList=PersonManagement.deletePerson(personList, idToDelete);
              Person.displayPersonList(personList);
	           }
	           else if (dataChoice1.equalsIgnoreCase(Constants.SEARCH)) {
		        System.out.println("Type person name which person search please.");
				String searchName=scanner.nextLine();    
				PersonManagement.searchPersonByName(personList, searchName);
			   }
	           else if (dataChoice1.equalsIgnoreCase(Constants.UPDATE)) {
	        	   System.out.println("Type person name which person update please.");
					String updateName=scanner.nextLine();    
					PersonManagement.updatePerson(personList, updateName);
					System.out.println("New Person List");
		              Person.displayPersonList(personList);


               }
	           else if (dataChoice1.equalsIgnoreCase(Constants.ADD)) {
	        	   PersonManagement.addPerson(personList);		
	        	   System.out.println(personList);

               }
	           else if (dataChoice1.equalsIgnoreCase(Constants.MENU)) {
	        	   Menu();
	        	   choice = scanner.nextLine(); 
	        	   processChoice(choice);
               }
	           else if(dataChoice1.equals(Constants.EXIT)) {
	        	   choice="0";
	        	   System.out.println("You logged out of the application ");
	        	   break;
	        	   
	           }
	           else {
	        	   System.out.println("You have to choose.options or press the M for back to Menu");
	           }

	           break;
	       case Constants.MEMORY_MANAGEMENT:
	           System.out.println("You chose Memory Management");
	           System.out.println("you have to type which phone do you learn memory storage?Type phone id ");
				int idToControl=scanner.nextInt();    
                MemoryControl.checkStorage(phoneList,idToControl);
                System.out.println("You can back to Menu with M,Exit with 0 and you can control another phone memory wit H");
				String in=scanner.nextLine();    

                 if (in.equalsIgnoreCase(Constants.MENU)) {
 	        	   Menu();
 	        	   choice = scanner.nextLine(); 
 	        	   processChoice(choice);
                }
                 else if(in.equalsIgnoreCase(Constants.STORAGE_CHECK)) {
                	 System.out.println("you have to type which phone do you learn memory storage?Type phone id ");
     				 idToControl=scanner.nextInt();    
                     MemoryControl.checkStorage(phoneList,idToControl);
                 }
 	           else if(in.equals(Constants.EXIT)) {
 	        	   choice="0";
 	        	   System.out.println("You logged out of the application ");
 	        	   break;
 	        	   
 	           }
	           break;
	       case Constants.PHONE_BOOK_MANAGEMENT:
	           System.out.println("You chose Phone Book Management");
	           System.out.println("You can back to Menu Press M");
	           System.out.println("Do you want to add phone? Press A");
	           
	           System.out.println("Do you want to delete phone? Press D");
	           System.out.println("Do you want to search phone? Press S");
	           System.out.println("Do you want to edit/change phone? Press C");
 	           
	           String dataChoice11 = scanner.nextLine();            
	           if (dataChoice11.equalsIgnoreCase(Constants.DELETE)) {
	        	  System.out.println("Type phone id  which phone delete please.");
	        	  int idToDelete=scanner.nextInt();
	        	  phoneList=PhoneManagement.deletePhone(phoneList, idToDelete);
                  Phone.displayPhoneList(phoneList);
	           }
	           else if (dataChoice11.equalsIgnoreCase(Constants.SEARCH)) {
		        System.out.println("Type person name belongs to  phone search please.");
				String searchName=scanner.nextLine();    
				PhoneManagement.searchPhoneName(phoneList, searchName);
			   }
	           else if (dataChoice11.equalsIgnoreCase(Constants.UPDATE)) {
	        	   System.out.println("Type phone name which person search please.");
					String updateName=scanner.nextLine();    
					PhoneManagement.updatePhone(phoneList, updateName);
					System.out.println("New Phone List");
	                  Phone.displayPhoneList(phoneList);

               }
	           else if (dataChoice11.equalsIgnoreCase(Constants.ADD)) {
	        	   System.out.println("If the phone you are going to register belongs to someone in the system and you know the id, Press R.");
	        	   String input = scanner.nextLine();            
		           if (input.equalsIgnoreCase(Constants.NEW)) {
		        	   phoneList=PhoneManagement.addPhone(phoneList,personList)	;	

		           }
		           else if (dataChoice11.equalsIgnoreCase(Constants.REGISTERED)) {
		        	   phoneList=PhoneManagement.addNewPhone(phoneList)	;	

				   }
		           else {
		        	   System.out.println("you have to choose");
		           }

		           
               }
	           else if (dataChoice11.equalsIgnoreCase(Constants.MENU)) {
	        	   Menu();
	        	   choice = scanner.nextLine(); 
	        	   processChoice(choice);
               }
	           else if(dataChoice11.equals(Constants.EXIT)) {
	        	   choice="0";
	        	   System.out.println("You logged out of the application ");
	        	   break;
	        	   
	           }
	           else {
	        	   System.out.println("You have to choose.options or press the M for back to Menu");
	           }

	           break;
	       case Constants.DATA_MANAGEMENT:
	           System.out.println("You chose Data Management");
	           System.out.println("You can back to Menu Press M");
	           System.out.println("Do you want to back up your data? Press B");
	           System.out.println("Do you want to upload your data? Press U");
	           String dataChoice111 = scanner.nextLine();            
	           if (dataChoice111.equalsIgnoreCase(Constants.BACKUP)) {
	        	   FileOperations.writeToFile(phoneList, filePath);
			   }
	           else if (dataChoice111.equalsIgnoreCase(Constants.UPLOAD)) {
	        	   PhoneAndPersonLists result = (PhoneAndPersonLists) FileOperations.readFromFile(filePath);
	               phoneList = result.getPhoneList();
	               personList= result.getPersonList();
			   }
	           else if (dataChoice111.equalsIgnoreCase(Constants.MENU)) {
	        	   Menu();
	        	   choice = scanner.nextLine(); 
	        	   processChoice(choice);
               }
	           else if(dataChoice111.equals(Constants.EXIT)) {
	        	   choice="0";
	        	   System.out.println("You logged out of the application ");
	        	   break;
	        	   
	           }
	           else {
	        	   System.out.println("You have to choose.options or press the M for back to Menu");
	           }

	           break;
	       case Constants.EXIT:
        	   System.out.println("You logged out of the application ");
               break;
	       default:
	           System.out.println("You have to choose one");
	           break;
	   }}
	}	

	public static void Menu() {
		System.out.println("Welcome to Smart Phone Management App");
		System.out.println();
		System.out.println("Managament Areas ,you have to choose one");
		System.out.println("General App Management. / You have to press 1");
		System.out.println("Person Management / You have to press 2");
		System.out.println("Memmory Management / You have to press 3");
		System.out.println("Phone Book Management / You have to press 4");
		System.out.println("Data Management / You have to press 5");
	}
	
	 
}

