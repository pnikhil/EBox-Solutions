import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int count = 0;
		Scanner input = new Scanner(System.in);
		Address obj = new Address();
		User search = new User();
		List<User> details = new ArrayList<User>();
		System.out.println("Enter the number of user details to be inserted");
		count = input.nextInt();
		String uName;
		String uNo, eMail, ccNO;
		input.nextLine();
		for (int i = 0; i < count; i++) {
			System.out.println("Enter details of user " + (i + 1));
			System.out.println("Enter name");
			uName = input.nextLine();

			System.out.println("Enter mobile number");
			uNo = input.nextLine();

			System.out.println("Enter email address");
			eMail = input.nextLine();

			System.out.println("Enter address details");

			System.out.println("Enter door number");
			obj.setDoorNumber(input.nextInt());
			input.nextLine();

			System.out.println("Enter street name");
			obj.setStreet(input.nextLine());
			System.out.println("Enter city name");
			obj.setCity(input.nextLine());

			System.out.println("Enter district name");
			obj.setDistrict(input.nextLine());

			System.out.println("Enter state name");
			obj.setState(input.nextLine());

			System.out.println("Enter pin code");
			obj.setPinCode(input.nextInt());
			input.nextLine();

			System.out.println("Enter credit card number");
			ccNO = input.nextLine();

			User data = new User(uName, uNo, eMail, obj, ccNO);
			details.add(data);

		}
		
		System.out.println("Menu");
		System.out.println("1) Search for user details using mobile number.");
		System.out
				.println("2) Search for user details using mobile number and then change the email id of the above user to new id provided.");
		System.out
				.println("3) List the names of users in which the given string is a substring.");
		System.out
				.println("4) List the names of users from a particular district.");
		System.out.println("Any other choice : Exit");
		boolean flag = false;
		while (flag == false) {
			System.out.println("Enter your choice");

			count = input.nextInt();
			input.nextLine();

			switch (count) {
			case 1:
				System.out.println("Enter the mobile number");
				uNo = input.nextLine();
				search.searchByMoblieNumber(details, uNo);
				
				break;
			case 2:
				System.out.println("Enter the mobile number");
				uNo = input.nextLine();
				System.out.println("Enter the new email id");
				eMail = input.nextLine();
				search.searchAndChange(details, uNo, eMail);
				break;
			case 3:
				System.out.println("Enter the substring");
				uName = input.nextLine();
				search.searchUserName(details, uName);
				break;
			case 4:
				System.out.println("Enter the district name");
				uName = input.nextLine();
				search.searchNamesInDistrict(details, uName);
				break;
			default:
				System.out.println("Application Terminated");
				flag = true;
			}
		}
	}
}
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Address {

	private Integer doorNumber;
	private String street;
	private String city;
	private String district;
	private String state;
	private Integer pinCode;

	public Integer getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(Integer doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Address() {

	}

	public Address(Integer doorNumber, String street, String city,
			String district, String state, Integer pinCode) {

		this.doorNumber = doorNumber;
		this.street = street;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
	}

	public void listDistrict(List<Address> object, String stateName) {
		boolean flag = false;
		Address ob = new Address();
		Set<String> sort = new TreeSet<String>();

		for (Iterator<Address> it = object.iterator(); it.hasNext();) {
			ob = it.next();

			if (ob.state.equalsIgnoreCase(stateName)) {
				if (flag == false) {
					flag = true;
					System.out.println("List of districts in " + ob.state
							+ " are");

				}
				sort.add(ob.getDistrict());

			}

		}

		if (flag == false) {
			System.out.println("No records found");
		} else {

			for (Iterator<String> it = sort.iterator(); it.hasNext();) {
				System.out.println(it.next());
			}
		}

	}

	public void listCities(List<Address> object, String districtName) {
		boolean flag = false;
		Address ob = new Address();
		Set<String> sort = new TreeSet<String>();

		for (Iterator<Address> it = object.iterator(); it.hasNext();) {
			ob = it.next();
			if (ob.district.equalsIgnoreCase(districtName)) {
				if (flag == false) {
					flag = true;
					System.out.println("List of cities in " + ob.district
							+ " are");

				}
				sort.add(ob.getCity());

			}

		}

		if (flag == false) {
			System.out.println("No records found");
		} else {

			for (Iterator<String> it1 = sort.iterator(); it1.hasNext();) {
				System.out.println(it1.next());
			}
		}

	}

}

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class User {

	private String name;
	private String mobileNumber;
	private String email;
	private Address address;
	private String creditCardNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public User(String name, String mobileNumber, String email,
			Address address, String creditCardNumber) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		this.creditCardNumber = creditCardNumber;
	}

	public User() {

	}

	public void displayDetails(User object) {
		System.out.println("User Details:");
		System.out.println("Name : " + object.getName());
		System.out.println("Email : " + object.getEmail());
		System.out.println("Credit Card Number : "
				+ object.getCreditCardNumber());

	}

	public void searchByMoblieNumber(List<User> details, String mobileNo) {
		boolean flag = false;
		User ob = new User();
		for (Iterator<User> it = details.iterator(); it.hasNext();) {
			ob = it.next();
			if (ob.getMobileNumber().equalsIgnoreCase(mobileNo)) {
				flag = true;
				displayDetails(ob);
			}
		}
		if (flag == false) {
			System.out.println("No records found");
		}
	}

	public void searchAndChange(List<User> details, String mobileNo,
			String email) {
		boolean flag = false;
		User ob = new User();
		//ArrayList<User> waste = new ArrayList<User>();
		for (Iterator<User> it = details.iterator(); it.hasNext();) {
			ob = it.next();
			if (ob.getMobileNumber().equalsIgnoreCase(mobileNo)) {
				flag = true;
				ob.setEmail(email);
				//details.add(ob);
			}
		}
		if (flag == false) {
			System.out.println("No records found");
		} else {
		//	details.removeAll(waste);
		}
	}

	public void searchUserName(List<User> details, String subStringName) {
		boolean flag = false;
		User ob = new User();

		Set<String> names = new TreeSet<String>();
		for (Iterator<User> it = details.iterator(); it.hasNext();) {
			ob = it.next();
			
			if (ob.getName().toLowerCase().contains(subStringName.toLowerCase())) {
				flag = true;
				names.add(ob.getName());
			}
		}
		if (flag == false) {
			System.out.println("No records found");
		} else {
			System.out.println("List of user names that contain the substring "
					+ subStringName);
			for (Iterator<String> it1 = names.iterator(); it1.hasNext();) {
				System.out.println(it1.next());
			}
		}

	}

	public void searchNamesInDistrict(List<User> details, String dName) {
		boolean flag = false;
		User ob = new User();

		Set<String> names1 = new TreeSet<String>();
		for (Iterator<User> it = details.iterator(); it.hasNext();) {
			ob = it.next();
			
			if (ob.getAddress().getDistrict().equalsIgnoreCase(dName)) {
				flag = true;
				names1.add(ob.getName());
				
			}
		}
		if (flag == false) {
			System.out.println("No records found");
		} else {
			System.out.println("List of users from " + dName);
			for (Iterator<String> it1 = names1.iterator(); it1.hasNext();) {
				System.out.println(it1.next());
			}
		}
	}
}
