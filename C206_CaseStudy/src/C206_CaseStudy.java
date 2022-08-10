import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class C206_CaseStudy {

	private static final int CUSTOMER_DELETE = 3;
	private static final int CUSTOMER_VIEW = 2;
	private static final int CUSTOMER_ADD = 1;
	private static final int DELETE_PACKAGE = 3;
	private static final int ADD_PACKAGE = 2;
	private static final int VIEW_PACKAGE = 1;
	private static final int QUOTATION = 4;
	private static final int REQUEST_QUOTATION = 3;
	private static final int OPTION_APPOINTMENT = 5;
	private static final int CHOICE_DELETE = 3;
	private static final int CHOICE_ADD = 2;
	private static final int CHOICE_VIEW = 1;

	private static final int OPTION_CUSTOMER = 1;
	private static final int OPTION_QUIT = 7;
	private static final int OPTION_PACKAGE = 2;

	public static void main(String[] args) {

		// Manage customer <arrayList>
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		// Manage Package <arrayList>
		ArrayList<Packages> packageList = new ArrayList<Packages>();
		// Request for quotation <arrayList>
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
		// Manage Quotation <arrayList>
		ArrayList<ManageQuotation> manageList = new ArrayList<ManageQuotation>();
		// Manage Appointment <arrayList>
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		// OPTION 1 - Jerstine
		Customer c1 = new Customer("Jasmine", "90254666", "jasminele@yahoo.com", "New");
		Customer c2 = new Customer("Jackie", "80534567", "jackiechan@yahoo.com", "New");
		Customer c3 = new Customer("Jaime", "83257899", "jaimeloiuse@yahoo.com", "New");
		customerList.add(c1);
		customerList.add(c2);
		customerList.add(c3);
		// OPTION 2-divya
		Packages pl = new Packages("S01", "Renovating Whole Place", "10/09/2022", "23/02/2023", "$15000.00 ");
		Packages p2 = new Packages("S02", "Renovating Restrooms Only", "10/08/2022", "10/11/2022", "$6000.00 ");
		Packages p3 = new Packages("S03", "Renovation Kitchen Only", "10/06/2022", "23/10/2022", "$7000.0 ");
		packageList.add(pl);
		packageList.add(p2);
		packageList.add(p3);
		// OPTION 3 - Hwee liang
		Quotation d = new Quotation("test1", "Landed", 1, "name1", 123456789, "test@email.com", 100000,
				LocalDate.parse("1111-11-11"), "whole house", 1, 1, "whole house", "no");
		quotationList.add(d);
		// OPTION 4
		// ManageQuotation mq = new ManageQuotation(132546, 523145, "Hall", "Tiles",
		// "Alan", "12/02/2022", 2000);
		// manageList.add(mq);
		// OPTION 5 - Nurin
		Appointment app1 = new Appointment("Siti", "Sam", "12-12-2022", "8:30:00", "Pasir Ris ave 8");
		Appointment app2 = new Appointment("John", "Andrew", "29-01-2023", "14:45:00", "Woodlands Drive");
		Appointment app3 = new Appointment("James", "Alex", "30-12-2022", "16:30:00", "Punggol Place");
		appointmentList.add(app1);
		appointmentList.add(app2);
		appointmentList.add(app3);

		int option = 0;
		while (option != OPTION_QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_CUSTOMER) {
				if (option == 1) {
					int mngCustChoice = Helper.readInt("Enter Choice > ");
					if (mngCustChoice == CUSTOMER_ADD) {
						// add customer
						Customer c = inputCustomer();
						C206_CaseStudy.addCustomer(customerList, c);

					} else if (mngCustChoice == CUSTOMER_VIEW) {
						// view all customer account
						C206_CaseStudy.viewAllCustomer(customerList);

					} else if (mngCustChoice == CUSTOMER_DELETE) {
						// delete customer user account
						C206_CaseStudy.inputDeleteCustomer(customerList);
					}
				}
			} else if (option == OPTION_PACKAGE) {
				Choice();
				int choice = Helper.readInt("Enter Choice > ");
				if (choice == VIEW_PACKAGE) {
					// view package
					C206_CaseStudy.viewAllPackage(packageList);
				} else if (choice == ADD_PACKAGE) {
					// add package
					Packages p = inputPackages();
					C206_CaseStudy.addPackage(packageList, p);
					System.out.println("Package Added");
				} else if (choice == DELETE_PACKAGE) {
					// delete package
					C206_CaseStudy.inputDeletePackages(packageList);
					System.out.println("Package deleted");
				}

			} else if (option == REQUEST_QUOTATION) {
				// requestQuotation(quotationList);
			} else if (option == QUOTATION) {
				/*
				 * quotationMenu(); int choice=Helper.readInt("Enter the option >");
				 * if(choice==1) { C206_CaseStudy.viewAllManageQuotation(manageList); }else
				 * if(choice==2) { ManageQuotation mq1=inputManageQuotation();
				 * C206_CaseStudy.addManageQuotation(manageList,mq1) ;
				 * System.out.println("Quotation Added"); }else if(choice==3) { int
				 * id=Helper.readInt("Enter the ID of quptation to be Deleted >");
				 * doRemoveManageQuotation(manageList,id);
				 * System.out.println("Quotation Deleted"); }
				 */
			}
			// option: appointment
			else if (option == OPTION_APPOINTMENT) {

				appointmentTypeMenu();

				int choice = Helper.readInt("Enter choice > ");
				if (choice == CHOICE_VIEW) {

					C206_CaseStudy.viewAllAppointment(appointmentList);
					C206_CaseStudy.retrieveAllAppointment(appointmentList);

				} else if (choice == CHOICE_ADD) {

					Appointment app = inputAppointment();
					C206_CaseStudy.addAppointment(appointmentList, app);
					System.out.println("Appointment added");

				} else if (choice == CHOICE_DELETE) {

					C206_CaseStudy.inputDeleteAppointment(appointmentList);
					System.out.println("Appointment deleted");

				}
			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option!");
			}
		}
	}

	private static void quotationMenu() {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("Quotation Management");
		System.out.println("1. View All Quotation");
		System.out.println("2. Add a Quotation");
		System.out.println("3. Delete a quotation");

	}

	public static void Choice() {
		C206_CaseStudy.setHeader("CHOICE");
		System.out.println("1. View Package");
		System.out.println("2. Add Package");
		System.out.println("3. Delete Package");
	}

	private static void appointmentTypeMenu() {
		C206_CaseStudy.setHeader("APPOINTMENT TYPES");
		System.out.println("1. View Appointment");
		System.out.println("2. Add Appointment");
		System.out.println("3. Delete Appointment");
	}

	public static void menu() {
		C206_CaseStudy.setHeader("Renovation APP");
		System.out.println("1. Manage Customer");
		System.out.println("2. Manage Package");
		System.out.println("3. Request Quotation");
		System.out.println("4. Manage Quotation ");
		System.out.println("5. Manage Appointment");
		System.out.println("6. Delete Quotation");
		System.out.println("7. Quit");
		Helper.line(80, "-");

	}

	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");

	}

//===================================================================Option 1======================================================================
	public static String retrieveAllCustomer(ArrayList<Customer> customerList) {
		String output = "";
		for (int i = 0; i < customerList.size(); i++) {

			String name = customerList.get(i).getName();
			final String contactNum = customerList.get(i).getContactNum();
			final String email = customerList.get(i).getEmail();
			final String status = customerList.get(i).getStatus();
			output += String.format("%-10s %-20s %-30s %-10s\n", name, contactNum, email, status);
		}
		return output;
	}

	public static void viewAllCustomer(ArrayList<Customer> customerList) {
		C206_CaseStudy.setHeader("VIEW CUSTOMER");
		String output = String.format("%-10s %-20s %-30s %-10s\n", "NAME", "CONTACT NUMBER", "EMAIL", "STATUS");
		output += retrieveAllCustomer(customerList);
		System.out.println(output);
	}

	public static void addCustomer(ArrayList<Customer> customerList, Customer c) {
		// TODO Auto-generated method stub
		customerList.add(c);
	}

	public static Customer inputCustomer() {
		String name = Helper.readString("Enter customer name > ");
		String contactNum = Helper.readString("Enter customer number > ");
		String email = Helper.readString("Enter customer email > ");
		String status = Helper.readString("Enter customer status > ");

		Customer c = new Customer(name, contactNum, email, status);
		return c;

	}

	// To delete customer user account
	public static void inputDeleteCustomer(ArrayList<Customer> customerList) {
		String nameCust = Helper.readString("Enter the Customer name: ");

		deleteC(customerList, nameCust);
	}

	public static void deleteC(ArrayList<Customer> customerList, String nameCust) {
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getName().equalsIgnoreCase(nameCust)) {
				// String option = Helper.readString("Are you sure that you want to delete (y/n)
				// > ") ;
				// if (option.equalsIgnoreCase("y")) {
				customerList.remove(i);
			} else {
				System.out.println("Delete failed");
			}
		}
	}

//===================================================================Option 2======================================================================
	public static String retrieveAllPackage(ArrayList<Packages> packageList) {
		String output = "";
		for (int i = 0; i < packageList.size(); i++) {
			String code = packageList.get(i).getCode();
			String description = packageList.get(i).getDescription();
			String stDate = packageList.get(i).getStDate();
			String endDate = packageList.get(i).getEndDate();
			String amount = packageList.get(i).getAmount();
			output += String.format("%-10s %-30s %-20s %-20s %-20s\n", code, description, stDate, endDate, amount);
		}
		return output;

	}

	public static void viewAllPackage(ArrayList<Packages> packageList) {
		C206_CaseStudy.setHeader("VIEW PACKAGE");
		String output = String.format("%-10s %-30s %-20s %-20s %-20s\n", "CODE", "DESCRIPTION", "START_DATE",
				"END_DATE", "AMOUNT");
		output += retrieveAllPackage(packageList);
		System.out.println(output);
	}

	public static Packages inputPackages() {
		String code = Helper.readString("Enter code: ");
		String description = Helper.readString("Enter description > ");
		String stDate = Helper.readString("Enter Start Date: ");
		String endDate = Helper.readString("Enter End Date: ");
		String amt = Helper.readString("Enter amt:  ");
		Packages pakg = new Packages(code, description, stDate, endDate, amt);
		;
		return pakg;
	}

	public static void addPackage(ArrayList<Packages> packageList, Packages p) {
		packageList.add(p);
	}

	public static void inputDeletePackages(ArrayList<Packages> packageList) {
		String codePkg = Helper.readString("Enter the Package Code: ");

		deleteP(packageList, codePkg); // call the method
	}

	public static void deleteP(ArrayList<Packages> packageList, String codePkg) {
		for (int i = 0; i < packageList.size(); i++) {
			if (packageList.get(i).getCode().equalsIgnoreCase(codePkg)) {
				String option = Helper.readString("Are you sure that you want to delete (y/n) > ");
				if (option.equalsIgnoreCase("y")) {
					packageList.remove(i);
				} else {
					System.out.println("Delete failed");
				}
			}
		}
	}

//======================================================================Option 3==========================================================================
	public static Quotation requestQuotation(ArrayList<Quotation> quotationList) {
		Quotation q = null;
		// DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyy") ;
		String rID = "r0" + quotationList.size();
		String property_type = Helper.readString("Property type (HDB, Private, Landed)> ");
		Double area_size = Helper.readDouble("Area size > ");
		String name = Helper.readString("Name > ");
		int contactNum = Helper.readInt("Contact number > ");
		String email = Helper.readString("Email > ");
		Double budget = Helper.readDouble("Budget > ");
		String renovation_type = Helper.readString("Renovation type (whole house, room, kitchen, toilet)> ");
		int numRooms = Helper.readInt("Number of rooms to renovate > ");
		int numToilets = Helper.readInt("Number of toilets to renovate > ");
		String renovation_style = Helper.readString("Renovation style (optional) > ");
		String urgent_request = Helper
				.readString("Urgent request (target completion date within 3 months to be indicated as Urgent)> ");

		String cDate1 = Helper.readString("Completion date (YYYY-MM-DD)> ");
		LocalDate cDate = LocalDate.parse(cDate1);

		if (property_type.equals("HDB") || property_type.equals("Private") || property_type.equals("Landed")) {
			// System.out.println("property OK");
			if (renovation_type.equals("whole house") || renovation_type.equals("room")
					|| renovation_type.equals("kitchen") || renovation_type.equals("toilet")) {
				q = new Quotation(rID, property_type, area_size, name, contactNum, email, budget, cDate,
						renovation_type, numRooms, numToilets, renovation_style, urgent_request);
				quotationList.add(q);
				System.out.println("Successfully added quotation request for " + rID);
			}
		} else {
			System.out.println("Unknown property type AND/OR renovation type detected, please try again.");
		}
		return q;
	}

	public static void addQuotation(ArrayList<Quotation> quotationList, Quotation q) {
		// TODO Auto-generated method stub
		// for test
		quotationList.add(q);
	}

	public static void deleteQuotation(ArrayList<Quotation> quotationList, Quotation q) {
		// TODO Auto-generated method stub
		// for test
		quotationList.remove(q);
	}

	public static void viewQuotation(ArrayList<Quotation> quotationList) {
		if (quotationList.size() == 0) {
			System.out.println("Empty list");
		} else {
			for (int i = 0; i < quotationList.size(); i++) {
				String a = quotationList.get(i).get_rID();
				String b = quotationList.get(i).get_property_type();
				String c = Double.toString(quotationList.get(i).get_area_size());
				String d = quotationList.get(i).get_Name();
				String e = String.valueOf(quotationList.get(i).get_contactNum());
				String f = quotationList.get(i).get_email();
				String g = Double.toString(quotationList.get(i).get_budget());
				String h = (quotationList.get(i).get_cDate()).toString();
				String i1 = quotationList.get(i).get_renovation_type();
				String j = String.valueOf(quotationList.get(i).get_numRooms());
				String k = String.valueOf(quotationList.get(i).get_numToilets());
				String l = quotationList.get(i).get_renovation_style();
				String m = quotationList.get(i).get_urgent_request();

				System.out.println("Request ID: " + a);
				System.out.println("Property type: " + b);
				System.out.println("Area Size: " + c);
				System.out.println("Name: " + d);
				System.out.println("Contact Number: " + e);
				System.out.println("Email: " + f);
				System.out.println("Budget: " + g);
				System.out.println("Completion date: " + h);
				System.out.println("Renovation type: " + i1);
				System.out.println("Number of rooms to renovate: " + j);
				System.out.println("Number of toilets to renovate: " + k);
				System.out.println("Renovation style: " + l);
				System.out.println("Urgent request: " + m + "\n");
			}
		}
	}

	public static void deleteQuotation(ArrayList<Quotation> quotationList) {
		String rName = Helper.readString("Enter requestor name to delete > ");
		// System.out.println("user input for rID: " + rID);

		for (int i = 0; i < quotationList.size(); i++) {
			String a = quotationList.get(i).get_rID();
			String b = quotationList.get(i).get_property_type();
			String c = Double.toString(quotationList.get(i).get_area_size());
			String d = quotationList.get(i).get_Name();
			String e = String.valueOf(quotationList.get(i).get_contactNum());
			String f = quotationList.get(i).get_email();
			String g = Double.toString(quotationList.get(i).get_budget());
			String h = (quotationList.get(i).get_cDate()).toString();
			String i1 = quotationList.get(i).get_renovation_type();
			String j = String.valueOf(quotationList.get(i).get_numRooms());
			String k = String.valueOf(quotationList.get(i).get_numToilets());
			String l = quotationList.get(i).get_renovation_style();
			String m = quotationList.get(i).get_urgent_request();
			String n = quotationList.get(i).get_Name();

			if (rName.equals(n)) {
				quotationList.remove(i);
				System.out.println("Successfully deleted request by: " + rName);
			} else {
				System.out.println(rName + " does not exist.");
			}
		}
	}
//=====================================================================Option 4 - incomplete==============================================================================
	/*
	 * public static String retrieveAllManageQuotation(ArrayList<ManageQuotation>
	 * manageList) { // TBD later //
	 * 
	 * String output = "";
	 * 
	 * for (int i = 0; i < manageList.size(); i++) { output +=
	 * String.format("%-103s", manageList.get(i).toString()); } return output; }
	 * 
	 * public static void viewAllManageQuotation(ArrayList<ManageQuotation>
	 * manageList) { C206_CaseStudy.setHeader("Quotation"); String output =
	 * String.format("%-15s%-15s%-13s%-20s%-15s%-15s%-10s\n","REQUEST ID"
	 * ,"QUOTATION ID","CATEGORY","ITEMS IN CATEGORY","DESIGNER","START DATE"
	 * ,"TOTAL AMOUNT");
	 * 
	 * output += retrieveAllManageQuotation(manageList); System.out.println(output);
	 * 
	 * }
	 * 
	 * public static ManageQuotation inputManageQuotation() { int RID =
	 * Helper.readInt("Enter your Request ID > "); int QID =
	 * Helper.readInt("Enter your quotation ID > "); String Category =
	 * Helper.readString("Enter your category(Room, Kitchen, Etc.) > "); String
	 * CategoryItem = Helper.readString("Enter the items for category > "); String
	 * DesignerName = Helper.readString("Enter the name of the designer > "); String
	 * Date = Helper.readString("Enter the start date > "); int amount =
	 * Helper.readInt("Enter the total quotation amount > ");
	 * 
	 * ManageQuotation MQ = new ManageQuotation(RID, QID, Category, CategoryItem,
	 * DesignerName, Date, amount); return MQ; } public static boolean
	 * findManageQuotation(ArrayList<ManageQuotation> ManageQuotationList, int ID) {
	 * boolean found = false; for (int i=0 ; i<ManageQuotationList.size() ; i++) {
	 * if (ID == ManageQuotationList.get(i).getQuotationID()) { found = true; } }
	 * return found; }
	 * 
	 * 
	 * public static void addManageQuotation(ArrayList<ManageQuotation> manageList,
	 * ManageQuotation MQ) { manageList.add(MQ); } public static void
	 * doRemoveManageQuotation(ArrayList<ManageQuotation> ManageQuotationList, int
	 * ID) { for (int i=0 ; i<ManageQuotationList.size() ; i++) { if (ID ==
	 * ManageQuotationList.get(i).getQuotationID()) { ManageQuotationList.remove(i);
	 * } } }
	 * 
	 * public static void removeManageQuotation(ArrayList<ManageQuotation>
	 * ManageQuotationList) { retrieveAllManageQuotation(ManageQuotationList); int
	 * ID = Helper.readInt("Enter your quotation ID > ");
	 * 
	 * boolean found = findManageQuotation(ManageQuotationList, ID);
	 * 
	 * if (found == false) { System.out.println("invalid ID number"); } else {
	 * doRemoveManageQuotation(ManageQuotationList, ID);
	 * System.out.println("quotation ID: " + ID + " successfully deleted!"); } }
	 */
//===================================================================Option 5======================================================================

	public static String retrieveAllAppointment(ArrayList<Appointment> appointmentList) {
		String output = "";
		for (int i = 0; i < appointmentList.size(); i++) {

			String name = appointmentList.get(i).getName();
			output += String.format("%-10s %-20s %-20s %-20s %-10s\n", name, appointmentList.get(i).getDesignerName(),
					appointmentList.get(i).getDate(), appointmentList.get(i).getTime(),
					appointmentList.get(i).getAddress());
		}
		return output;
	}

	public static void viewAllAppointment(ArrayList<Appointment> appointmentList) {
		C206_CaseStudy.setHeader("VIEW APPOINTMNET");
		String output = String.format("%-10s %-20s %-20s %-20s %-10s\n", "NAME", "DESIGNER NAME", "DATE", "TIME",
				"ADDRESS");
		output += retrieveAllAppointment(appointmentList);
		System.out.println(output);
	}

	public static Appointment inputAppointment() {
		String name = Helper.readString("Enter name > ");
		String designer = Helper.readString("Enter designer name > ");

		String date = Helper.readString("Enter date of appointment > ");
		String time = Helper.readString("Enter time > ");
		String address = Helper.readString("Enter address > ");

		Appointment app = new Appointment(name, designer, date, time, address);
		return app;

	}

	public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment app) {
		appointmentList.add(app);
	}

	public static void inputDeleteAppointment(ArrayList<Appointment> appointmentList) {
		String custName = Helper.readString("Enter the Customer name: ");

		deleteAppointment(appointmentList, custName);
	}

	public static void deleteAppointment(ArrayList<Appointment> appointmentList, String app) {
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getName().equalsIgnoreCase(app)) {
				String option = Helper.readString("Are you sure that you want to delete (y/n) > ");
				if (option.equalsIgnoreCase("y")) {
					appointmentList.remove(i);

				} else {
					System.out.println("Delete failed");
				}
			}
		}
	}

}
