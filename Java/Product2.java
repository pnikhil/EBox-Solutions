import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Long id;
		Integer price;
		String pname, sname;
		String choice;
		Scanner input = new Scanner(System.in);
		List<Product> ob = new ArrayList<Product>();
		Product objProduct;
		ProductBO obj = new ProductBO();
		do {
			System.out.println("Enter the product id");
			id = input.nextLong();
			input.nextLine();
			System.out.println("Enter the product name");
			pname = input.nextLine();
			System.out.println("Enter the supplier name");
			sname = input.nextLine();
			System.out.println("Enter the product price");
			price = input.nextInt();

			objProduct = new Product(id, pname, sname, price);
			ob.add(objProduct);
			System.out
					.println("Do you want to enter the details of another product? Enter yes or no (not case sensitive)");
			choice = input.next();

		} while (choice.equalsIgnoreCase("YES"));
		input.nextLine();
		System.out.println("Enter the minimum price range");
		int pl = input.nextInt();
		System.out.println("Enter the maximum price range");
		int ph = input.nextInt();
		obj.searchProductByPriceRange(ob, pl, ph);
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

import java.util.Iterator;
import java.util.List;

public class ProductBO {
	int flag = 0;

	public void displayProductDetails(Product product) {

		System.out.format("%-10s %-20s %-20s %-10s\n", product.getId(),
				product.getProductName(), product.getSupplierName(),
				product.getPrice());

	}

	public void searchProductByPriceRange(List<Product> productList, int pl,
			int ph) {

		Product object;
		int price;
		for (Iterator<Product> it = productList.iterator(); it.hasNext();) {
			object = it.next();
			price = object.getPrice();
			if (price >= pl && price <= ph) {
				if (flag == 0) {
					System.out.format("%-10s %-20s %-20s %-10s\n", "Id",
							"ProductName", "SupplierName", "Price");
				}
				displayProductDetails(object);
				flag = 1;
			}
		}

		if (flag == 0) {
			System.out.println("No records found");
		}

	}

	public void searchProductByNameAndSupplier(List<Product> productList,
			String pname, String sname) {
		Product object;
		for (Iterator<Product> it = productList.iterator(); it.hasNext();) {
			object = it.next();
			if (object.getProductName().equalsIgnoreCase(pname)
					&& object.getSupplierName().equalsIgnoreCase(sname)) {
				System.out.format("%-10s %-20s %-20s %-10s\n", "Id",
						"ProductName", "SupplierName", "Price");
				displayProductDetails(object);
				flag = 1;
			}
		}

		if (flag == 0) {
			System.out.println("No records found");
		}
	}
}
