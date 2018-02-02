import java.util.Scanner;

public class ConstructorOverloading {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Product object = new Product();
		System.out.println("Enter the product id");
		object.setId(input.nextLong());
		input.nextLine();
		System.out.println("Enter the product name");
		object.setProductName(input.nextLine());

		System.out
				.println("Is the product supplied by Nivas Suppliers? Type yes or no (not case sensitive)");
		if (input.next().equalsIgnoreCase("yes")) {
			object.setSupplierName("Nivas");
		} else {
			input.nextLine();
			System.out.println("Enter the supplier name");
			object.setSupplierName(input.nextLine());
		}
		System.out.println("Product Id is " + object.getId());
		System.out.println("Product Name is " + object.getProductName());
		System.out.println("Supplier Name is " + object.getSupplierName());
	}

}



public class Product {
	private Long id;
	private String productName;
	private String supplierName;

	public Product() {

	}
	public Product(Long id, String productName) {
		this.id = id;
		this.productName = productName;
		this.supplierName = "Nivas";
	}

	public Product(Long id, String productName, String supplierName) {
		this.id = id;
		this.productName = productName;
		this.supplierName = supplierName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	void display() {
		System.out.println("Product Id is " + this.id);
		System.out.println("Product Name is " + this.productName);
		System.out.println("Supplier Name is " + this.supplierName);

	}

	public String toString() {
		return (this.id + " : " + this.productName + " : " + this.supplierName);
	}

	public boolean equals(Product temp) {
		boolean flag;
		if (this.id == temp.id && this.productName.equals(temp.productName)
				&& this.supplierName.equals(temp.supplierName)) {
			flag = true;

		} else {
			flag = false;

		}
		return flag;
	}
}
