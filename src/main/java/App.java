import java.util.List;

public class App {
	String Appname;
	String version;
	String AppMemory;
    Phone phone;

	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public App(String appname, String version, String memorySize, Phone phone) {
		super();
		Appname = appname;
		this.version = version;
		AppMemory = memorySize;
		this.phone = phone;
	}
	public String getAppname() {
		return Appname;
	}
	public void setAppname(String appname) {
		Appname = appname;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getAppMemory() {
		return AppMemory;
	}
	public static void displayAppList(List<App> appList) {
	    if (appList.isEmpty()) {
	        System.out.println("App list is empty.");
	    } else {
	        System.out.println("App List:");
	        for (App app : appList) {
	            System.out.println("App Name: " + app.getAppname());
	            System.out.println("Version: " + app.getVersion());
	            System.out.println("App Memory: " + app.getAppMemory());
	            System.out.println("----------------------");
	        }
	    }
	}
	public void setAppMemory(String memory) {
		// TODO Auto-generated method stub
		
	}
	
	
}
