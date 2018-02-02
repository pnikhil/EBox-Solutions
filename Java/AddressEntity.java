import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String street, city, district, state;
		Integer doorNumber, pinCode;

		Scanner in = new Scanner(System.in);
		Address obj = new Address();
		List<Address> address = new ArrayList<Address>();
		System.out.println("Enter the number of addresses to be inserted");
		int num = in.nextInt();
		for (int i = 1; i <= num; i++) {
			System.out.println("Enter address " + i + " details");
			System.out.println("Enter door number");
			doorNumber = in.nextInt();
			in.nextLine();
			System.out.println("Enter street name");
			street = in.nextLine();
			System.out.println("Enter city name");
			city = in.nextLine();
			System.out.println("Enter district name");
			district = in.nextLine();
			System.out.println("Enter state name");
			state = in.nextLine();
			System.out.println("Enter pin code");
			pinCode = in.nextInt();
			in.nextLine();
			address.add(new Address(doorNumber, street, city, district, state,
					pinCode));
		}

		System.out.println("Enter a state name");
		String sName = in.nextLine();

		obj.listDistrict(address, sName);

		System.out.println("Enter a district name");
		String dName = in.nextLine();

		obj.listCities(address, dName);

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
