import java.util.List;

public class Phone {
private static int nextId = 1;
Person person;
String brand;
String model;
String memory;
float usageMemory;
public Phone(Person person, String brand, String model, String memory, float usageMemory, String serialNo, String opsys,
		int id) {
	super();
	this.person = person;
	this.brand = brand;
	this.model = model;
	this.memory = memory;
	this.usageMemory = usageMemory;
	this.serialNo = serialNo;
	this.opsys = opsys;
	this.id = id;
}
String serialNo;
public float getUsageMemory() {
	return usageMemory;
}
public void setUsageMemory(float mem) {
	this.usageMemory = mem;
}
String opsys;
int id;

public Phone(Person person, String brand, String model, String memory, String serialNo, String opsys) {
	super();
	this.id = generateId();
	this.person = person;
	this.brand = brand;
	this.model = model;
	this.memory = memory;
	this.serialNo = serialNo;
	this.opsys = opsys;
}
public String getOpsys() {
	return opsys;
}
public void setOpsys(String opsys) {
	this.opsys = opsys;
}
public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getMemory() {
	return memory;
}
public void setMemory(String memory) {
	this.memory = memory;
}
public String getSerialNo() {
	return serialNo;
}
public void setSerialNo(String serialNo) {
	this.serialNo = serialNo;
}

private int generateId() {
    return nextId++;
}
public void displayPhoneInfo() {
	System.out.println("ID: " + id);
    System.out.println("Brand: " + brand);
    System.out.println("Model: " + model);
    System.out.println("Memory: " + memory);
    System.out.println("Serial Number: " + serialNo);
    System.out.println("Operating System: " + opsys);
}
public static void displayPhoneList(List<Phone> phoneList) {
    for (Phone phone : phoneList) {
        System.out.println("Brand: " + phone.getBrand());
        System.out.println("Memory: " + phone.getMemory());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Opsys: " + phone.getOpsys());
        System.out.println("SerialNo: " + phone.getSerialNo());
        System.out.println("----------------------------------");
    }
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public static void displayPhoneInfo(Phone phone) {
	System.out.println("Brand: " + phone.getBrand());
    System.out.println("Memory: " + phone.getMemory());
    System.out.println("Model: " + phone.getModel());
    System.out.println("Opsys: " + phone.getOpsys());
    System.out.println("SerialNo: " + phone.getSerialNo());
    System.out.println("----------------------------------");
}

}
