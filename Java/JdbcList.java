import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection con = DbConnector.connect();
		ContactBO sql = new ContactBO();

		sql.getConnection(con);

		sql.display(con);

		DbConnector.closeConnection();
	}
}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbConnector {

	static Connection connection;

	public static Connection connect() {

		ResourceBundle rb = ResourceBundle.getBundle("mysql");
		String url = rb.getString("db.url");
		String username = rb.getString("db.username");
		String password = rb.getString("db.password");

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactBO {

	Statement stmt = null;
	static Connection connect;
	static String insertQuery = "insert into contact(firstName,lastName,email,phoneNo) values(?,?,?,?)";
	static String displayQuery = "select * from contact";
	Statement statement = null;
	ResultSet resultset = null;
	static PreparedStatement pStatement;

	public void insert(Contact O, Connection con) {

		try {

			pStatement = con.prepareStatement(insertQuery);
			pStatement.setString(1, O.getFirstName());
			pStatement.setString(2, O.getLastName());
			pStatement.setString(3, O.getEmail());
			pStatement.setString(4, O.getPhoneNo());

			pStatement.executeUpdate(); // inserting of record

			statement.executeQuery("commit");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void getConnection(Connection connect) {
		try {
			pStatement = connect.prepareStatement(insertQuery);
			statement = connect.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void display(Connection connect) {

		String fName, lName, email, phoneNo;
		try {
			Statement statement1 = connect.createStatement();
			resultset = statement1.executeQuery(displayQuery);

			System.out.format("%-15s %-15s %-30s %-15s\n", "Firstname",
					"Lastname", "E-Mail", "Phone Number");
			// resultset.next();
			// System.out.println(resultset.getString(1));
			while (resultset.next()) {
				fName = resultset.getString(2);
				lName = resultset.getString(3);
				email = resultset.getString(4);
				phoneNo = resultset.getString(5);

				System.out.format("%-15s %-15s %-30s %-15s\n", fName, lName,
						email, phoneNo);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
public class Contact {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Contact(String firstName, String lastName, String email,
			String phoneNo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public Contact() {

	}
}
