import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String name, email, gender;
		Scanner input = new Scanner(System.in);
		Author data;
		String ch;
		List<Author> details = new ArrayList<Author>();
		do {

			System.out.println("Enter the author name");
			name = input.nextLine();
			System.out.println("Enter the author email id");
			email = input.nextLine();
			System.out.println("Enter the author's gender");
			gender = input.nextLine();

			System.out
					.println("Do you want to add the details of another author? Type Yes/No (Not case sensitive)");
			ch = input.next();
			input.nextLine();
			data = new Author(name, email, gender);
			details.add(data);
		} while (ch.equalsIgnoreCase("yes"));

		AuthorBO obj = new AuthorBO();
		obj.displayAllAuthorDetails(details);

		System.out.println("Enter the name of the author to be searched");
		name = input.nextLine();
		data = obj.findAuthorByName(details, name);
		if (data == null) {
			System.out.println("Author not found");
		} else {
			System.out.println(data.toString());
		}

		obj.listAuthorNamesInSortedOrder(details);

	}
}


public class Author implements Comparable<Author> {

	private String name;
	private String email;
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Author(String name, String email, String gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public Author() {

	}

	@Override
	public int compareTo(Author o) {
		return this.getName().compareTo(o.getName());

	}

	public String toString() {
		return this.getName() + " (" + this.getGender() + ") contact at "
				+ this.getEmail();
	}

}
 
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AuthorBO {

	public void displayAllAuthorDetails(List<Author> authorList) {
		boolean flag = false;
		Author object = new Author();
		for (Iterator<Author> it = authorList.iterator(); it.hasNext();) {
			object = it.next();
			if (flag == false) {
				System.out.format("%-20s %-20s %-20s\n", "Name", "Email",
						"Gender");
				flag = true;
			}
			System.out.format("%-20s %-20s %-20s\n", object.getName(),
					object.getEmail(), object.getGender());

		}

	}

	public void listAuthorNamesInSortedOrder(List<Author> authorList) {
		Set<String> list = new TreeSet<String>();
		for (Iterator<Author> it = authorList.iterator(); it.hasNext();) {
			list.add(it.next().getName());
		}
		System.out.println("Alphabetically sorted author names");
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}

	public Author findAuthorByName(List<Author> authorList, String name) {
		Author author = new Author();
		boolean flag = true;
		for (Iterator<Author> it = authorList.iterator(); it.hasNext() && flag;) {
			author = it.next();
			if (author.getName().equalsIgnoreCase(name)) {
				flag = false;
			}
		}
		if(flag==true){
			author = null;
		}
		return author;

	}
}
