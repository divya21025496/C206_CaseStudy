import java.time.LocalDate;

/**
 * 
 */

/**
 * @author 21025254
 *
 */
public class Customer {

	
	private String name;
	private String contactNum; 
	private String email; 
	private String status;
	


public Customer(String name, String contactNum, String email, String status) {
	super();
	this.name = name;
	this.contactNum = contactNum;
	this.email = email;
	this.status = "New";
}



public String getName() {
	return name;
}



public String getContactNum() {
	return contactNum;
}



public String getEmail() {
	return email;
}



public String getStatus() {
	return status;
}

public void display() {
	System.out.println(String.format("\n-15 %-20s %-15s %-20s", getName(), getContactNum(), getEmail(), getStatus()));
}

}
