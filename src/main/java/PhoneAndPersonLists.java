import java.util.List;

public class PhoneAndPersonLists {
	   private List<Phone> phoneList;
	    private List<Person> personList;

	    public PhoneAndPersonLists(List<Phone> phoneList, List<Person> personList) {
	        this.phoneList = phoneList;
	        this.personList = personList;
	    }

	    public List<Phone> getPhoneList() {
	        return phoneList;
	    }

	    public List<Person> getPersonList() {
	        return personList;
	    }
}
