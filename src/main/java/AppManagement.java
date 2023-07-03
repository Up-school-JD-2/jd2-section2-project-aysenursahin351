import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppManagement {
	static Scanner scanner=new Scanner(System.in);

    public static List<App> addApp(List<App> appList,List<Phone> phoneList) {
    	  System.out.println("You have to choose the phone you will use.Enter the phone id");
  	         int phoneID = scanner.nextInt();
  	        scanner.nextLine();
  	       Phone phone=null;
  	         if(PhoneManagement.findPhoneByID(phoneList, phoneID)!=null) {
  	  	          phone=PhoneManagement.findPhoneByID(phoneList, phoneID);

  	         }
  	         else {
  	        	 System.out.println("The id is not correct");
  	         }
    	    System.out.println("Enter the application name:");
    	    String appName = scanner.nextLine();
    	    
    	    System.out.println("Enter the application version:");
    	    String version = scanner.nextLine();
    	    
    	    System.out.println("Enter the application memory usage: Format 50MB/50GB otherwise invalid format");
    	    String memory = scanner.nextLine();
    	    float memorySize = 0;
    	   memory= memory.toUpperCase();
    	    if (memory.endsWith("GB")) {
    	        try {
    	            memorySize = Integer.parseInt(memory.substring(0, memory.length() - 2));
    	        } catch (NumberFormatException e) {
    	            System.out.println("Invalid memory format: " + memory);
    	            return null; // Hatalı giriş olduğunda işlemi sonlandırın
    	        }
    	    } else if (memory.endsWith("MB")) {
    	        try {
    	            memorySize = Integer.parseInt(memory.substring(0, memory.length() - 2));
    	            memorySize /= 1024; // MB'yi GB'ye çevirin
    	        } catch (NumberFormatException e) {
    	            System.out.println("Invalid memory format: " + memory);
    	            return null; // Hatalı giriş olduğunda işlemi sonlandırın
    	        }
    	    } else {
    	        System.out.println("Invalid memory format: " + memory);
    	        return null; // Hatalı giriş olduğunda işlemi sonlandırın
    	    }

    	    // Geçerli bellek formatına sahip olduğunda bellek boyutunu kullanabilirsiniz
    	    System.out.println("Memory size: " + memorySize + "GB");
    	    float mem=phone.usageMemory;
    	    mem=mem+memorySize;
    	    phone.setUsageMemory(mem);
        App newApp = new App(appName, version, memory,phone);
        
        List<App> updatedList = new ArrayList<>(appList);
        updatedList.add(newApp);
        return updatedList;
    }

    
    public static List<App> deleteApp(List<App> appList, String appName) {
        List<App> updatedList = new ArrayList<>(appList);
        
        App appToDelete = null;
        for (App app : updatedList) {
            if (app.getAppname().equals(appName)) {
                appToDelete = app;
                break;
            }
        }
        
        if (appToDelete != null) {
            updatedList.remove(appToDelete);
            System.out.println("App \"" + appName + "\" has been deleted.");
        } else {
            System.out.println("App \"" + appName + "\" does not exist.");
        }
        
        return updatedList;
    }
    public static void displayAppList(App app) {
        if (app==null) {
            System.out.println("App  is not found.");
        } else {
            System.out.println("App List:");
                System.out.println("App Name: " + app.getAppname());
                System.out.println("Version: " + app.getVersion());
                System.out.println("App Memory: " + app.getAppMemory());
                System.out.println("----------------------");
            
        }
    }
    public static Optional<App> searchAppName(List<App> appList, String appName) {
        Optional<App> foundApp = appList.stream()
                .filter(app -> app.getAppname().equals(appName))
                .findFirst();

        if (foundApp.isPresent()) {
            System.out.println("App found: " + foundApp.get().getAppname());
            displayAppList(foundApp.get());
        } else {
            System.out.println("App not found.");
            return null;
        }

        return foundApp;
    }

    public static List<App> updateApp(List<App> appList, String updateName) {
        if (searchAppName(appList, updateName) != null) {
            System.out.println("Enter the application name:");
            String appName = scanner.nextLine();

            System.out.println("Enter the application version:");
            String version = scanner.nextLine();

            System.out.println("Enter the application memory usage: Format 50MB/50GB otherwise invalid format");
            String memory = scanner.nextLine();
            float memorySize = 0;
            if (memory.endsWith("GB")) {
                try {
                    memorySize = Integer.parseInt(memory.substring(0, memory.length() - 2));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid memory format: " + memory);
                    return appList; // Hatalı giriş olduğunda mevcut appList'i döndürün
                }
            } else if (memory.endsWith("MB")) {
                try {
                    memorySize = Integer.parseInt(memory.substring(0, memory.length() - 2));
                    memorySize /= 1024; // MB'yi GB'ye çevirin
                } catch (NumberFormatException e) {
                    System.out.println("Invalid memory format: " + memory);
                    return appList; // Hatalı giriş olduğunda mevcut appList'i döndürün
                }
            } else {
                System.out.println("Invalid memory format: " + memory);
                return appList; // Hatalı giriş olduğunda mevcut appList'i döndürün
            }

            // Geçerli bellek formatına sahip olduğunda bellek boyutunu kullanabilirsiniz
            System.out.println("Memory size: " + memorySize + "GB");
            appList.stream()
                    .filter(app -> app.getAppname().equals(appName))
                    .findFirst()
                    .ifPresent(app -> {
                        app.setVersion(version);
                        app.setAppMemory(memory); 
                    });
        } else {
            System.out.println("This appName is not correct. You have to add this app first.");
        }

        return appList;
    }

    
}