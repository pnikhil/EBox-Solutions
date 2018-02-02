import java.util.Scanner;
public class Main {
	public static void main(String[] args) {

		Long id;
		Integer price;
		String pname, sname;

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the product id");
		id = input.nextLong();
		input.nextLine();
		System.out.println("Enter the product name");
		pname = input.nextLine();
		System.out.println("Enter the supplier name");
		sname = input.nextLine();
		System.out.println("Enter the product price");
		price = input.nextInt();

		Product ob1 = new Product(id, pname, sname, price);
		ProductBO obj = new ProductBO();
		obj.displayProductDetails(ob1);

		System.out.println("Update Menu :");
		System.out.println("1) Update product name");
		System.out.println("2) Update supplier name");
		System.out.println("3) Update product price");
		System.out.println("Enter Choice");

		int ch = input.nextInt();
		input.nextLine();
		switch (ch) {
		case 1:
			System.out.println("Enter new product name");
			pname = input.nextLine();
			obj.updateProductName(ob1, pname);
			break;
		case 2:
			System.out.println("Enter new supplier name");
			sname = input.nextLine();
			obj.updateSupplierName(ob1, sname);
			break;
		case 3:
			System.out.println("Enter new product price");
			price = input.nextInt();
			obj.updateProductPrice(ob1, price);
			break;

		}

		obj.displayProductDetails(ob1);
	}
}

public class Product {
	private Long id;
	private String productName;
	private String supplierName;
	private Integer price;

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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Product() {

	}

	public Product(Long id, String productName, String supplierName,
			Integer price) {
		this.id = id;
		this.productName = productName;
		this.supplierName = supplierName;
		this.price = price;
	}

}

 
public class ProductBO {
	public void displayProductDetails(Product product) {
		System.out.println("Product Id is " + product.getId());
		System.out.println("Product Name is " + product.getProductName());
		System.out.println("Supplier Name is " + product.getSupplierName());
		System.out.println("Product price is " + product.getPrice());
	}

	public void updateProductName(Product product, String pname) {
		product.setProductName(pname);
	}

	public void updateSupplierName(Product product, String sname) {
		product.setSupplierName(sname);
	}

	public void updateProductPrice(Product product, Integer p) {
		product.setPrice(p);
	}

}
