import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	//Customer
	private Customer c1;
	//Appointment
	private Appointment app1;
	private Appointment app2;
	//Package
	private Packages pl1 ; 
	private Packages pl2 ; 
	private Packages pl3 ; 
	// Request Quotation
	 private Quotation quotation1;
	 private Quotation quotation2;
	 private Quotation quotation3;
	// Retrieve Quotation
	 private ManageQuotation Q;
	//Arraylist
	private ArrayList<Appointment> appointmentList;
	private ArrayList<Packages> packageList ; 
	private ArrayList<Customer> customerList ; 
	private ArrayList<Quotation> quotationList;
	private ArrayList<ManageQuotation> manageList;
	
	DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyy") ; 
	public C206_CaseStudyTest() {
		super();
	}
	@Test
	public void c206_test() {
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	@Before
	public void setUp() throws Exception {
		//prepare test data
		//Customer - JERSTINE
		c1 = new Customer("Jasmine", "90254666", "jasminele@yahoo.com", "New");
		//Package - DIVYA
		pl1 = new Packages("S01", "Renovating Whole Place" ,"10/09/2022","23/02/2023", "$15000.00 ") ; 
		pl2 = new Packages("S02", "Renovating Restrooms Only" ,"10/08/2022", "10/11/2022", "$6000.00 " ) ;
		pl3 = new Packages("S03", "Renovation Kitchen Only" ,"10/06/2022","23/10/2022", "$7000.0 ") ;
		// Appointment - NURIN 
		app1 = new Appointment("Siti", "Sam", "12-12-2022", "8:30:00", "Pasir Ris ave 8");
		app2 = new Appointment("John", "Andrew", "29-01-2023", "14:45:00", "Woodlands Drive");	
       //Request Quotation - HWEE LIANG
        quotation1 = new Quotation("TEST1", "property type", 1, "name", 1234567890, "email", 999999, LocalDate.parse("1111-11-11"), "whole house", 1, 1, "nil", "urgent request");
        quotation2 = new Quotation("TEST2", "property type", 1, "name", 1234567890, "email", 999999, LocalDate.parse("1111-11-11"), "whole house", 1, 1, "nil", "urgent request");
        quotation3 = new Quotation("TEST3", "property type", 1, "name", 1234567890, "email", 999999, LocalDate.parse("1111-11-11"), "whole house", 1, 1, "nil", "urgent request");
        quotationList.add(quotation1);
        quotationList.add(quotation2);
        quotationList.add(quotation3);
        // Quotation -ASWAN 
        
        
        customerList  =new ArrayList<Customer> () ; 
        packageList = new  ArrayList<Packages>() ; 
        appointmentList = new ArrayList<Appointment>();
		quotationList= new ArrayList<Quotation>();
	}

//Option 1 (Customer) 
	// Customer test
	@Test
	public void testAddCustomer() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Customer arraylist to add to", customerList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addCustomer(customerList, c1);
		assertEquals("Test that Customer arraylist size is 1", 1, customerList.size());
		assertSame("Test that Customer is added", c1, customerList.get(0));
	}

	@Test
	public void testRetrieveAllCustomer() {
		// Test if Customer list is not null but empty -boundary
		assertNotNull("Test if there is valid Customer arraylist to retrieve item", customerList);

		// test if the list of customer retrieved from the CaseStudy is empty - boundary
		String allCustomer = C206_CaseStudy.retrieveAllCustomer(customerList);
		String testOutput = "";
		assertEquals("Check that ViewAllCustomer", testOutput, allCustomer);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addCustomer(customerList, c1);
		assertEquals("Test that Customer arraylist size is 1", 1, customerList.size());
		// test if the expected output string same as the list of customer retrieved
		// from the SourceCentre
		allCustomer = C206_CaseStudy.retrieveAllCustomer(customerList);
		testOutput += String.format("%-10s %-20s %-30s %-10s\n", "Jasmine", "90254666", "jasminele@yahoo.com", "New");

		assertEquals("Test that ViewAllCustomerlist", testOutput, allCustomer);

	}

	@Test
	public void testDeleteCustomer() {
		// Test if Package list is not null but empty -boundary
		assertNotNull("Check if there is valid Package arraylist to delete to", customerList);

		C206_CaseStudy.addCustomer(customerList, c1);
		assertEquals(1, customerList.size());

		C206_CaseStudy.deleteC(customerList, c1.getName());
		assertEquals("Check that Customer arraylist size is 0", 0, customerList.size());
	}
	
	//Option 2 (Package)
	
	@Test
	public void testAddPackage() {
		// Pkg list is not null, so that can add a new package - boundary
		assertNotNull("Check if there is valid Package arraylist to add to", packageList);
		// Given an empty list, after adding 1 package, the size of the list is 1
		// -normal
		C206_CaseStudy.addPackage(packageList, pl1);
		assertEquals("Check that Package arraylist size is 1", 1, packageList.size());
		assertSame("Check that Camcorder is added", pl1, packageList.get(0));

		// Add another package. test The size of the list is 3? - normal
		C206_CaseStudy.addPackage(packageList, pl2);
		C206_CaseStudy.addPackage(packageList, pl3);
		assertEquals("Check that Package arraylist size is 3", 3, packageList.size());
		assertSame("Test that Package is added is same as 3rd package of the list", pl3, packageList.get(2));
	}

	@Test
	public void testRetrieveAllPackage() {
		// Test if Package list is not null but empty -boundary
		assertNotNull("Test if there is valid Package arraylist to retrieve package", packageList);
		// test if the list of package retrieved from the list is empty - boundary
		String allPackage = C206_CaseStudy.retrieveAllPackage(packageList);
		String testOutput = "";
		assertEquals("Check that viewAllPackage", testOutput, allPackage);

		// Given an empty list, after adding 3 package, test if the size of the list is
		// 3 - normal
		C206_CaseStudy.addPackage(packageList, pl1);
		C206_CaseStudy.addPackage(packageList, pl2);
		C206_CaseStudy.addPackage(packageList, pl3);
		assertEquals("Test that Package arraylist size is 3", 3, packageList.size());

		// test if the expected output string same as the list of package retrieved from
		// the list
		allPackage = C206_CaseStudy.retrieveAllPackage(packageList);
		testOutput = String.format("%-10s %-30s %-20s %-20s %-20s\n", "S01", "Renovating Whole Place", "10/09/2022",
				"23/02/2023", "$15000.00");
		testOutput += String.format("%-10s %-30s %-20s %-20s %-20s\n", "S02", "Renovating Restrooms Only", "10/08/2022",
				"10/11/2022", "$6000.00");
		testOutput += String.format("%-10s %-30s %-20s %-20s %-20s\n", "S03", "Renovation Kitchen Only", "10/06/2022",
				"23/10/2022", "$7000.0 ");
		assertEquals("Test that ViewAllPackagelist", testOutput, allPackage);

	}

	@Test
	public void testDeleteP() {
		// Test if Package list is not null but empty -boundary
		assertNotNull("Check if there is valid Package arraylist to delete to", packageList);
		// Given an empty list, after adding 3 package, test if the size of the list is
		// 3 - normal
		C206_CaseStudy.addPackage(packageList, pl1);
		C206_CaseStudy.addPackage(packageList, pl2);
		C206_CaseStudy.addPackage(packageList, pl3);
		assertEquals(3, packageList.size());
		// Delete another package. test The size of the list is 2? - normal
		C206_CaseStudy.deleteP(packageList, pl1.getCode());
		assertEquals("Check that Package arraylist size is 2", 2, packageList.size());

		// Delete another 2 package. test The size of the list is 0?
		C206_CaseStudy.deleteP(packageList, pl2.getCode());
		C206_CaseStudy.deleteP(packageList, pl3.getCode());
		assertEquals("Check that Package arraylist size is 0", 0, packageList.size());

	}
	
	// Option 3 (Request Quotation)
	/*	    public void testAddQuotation() {
	        // Item list is not null, so that can add a new item - boundary
	        assertNotNull("Test if there is valid Quotation arraylist to add to", quotationList);

	        //Given an empty list, after adding 1 item, the size of the list is 1 - normal
	        //The item just added is as same as the first item of the list
	        C206_CaseStudy.addQuotation(quotationList, quotation1);        
	        // Original 3, added 1, now 4
	        assertEquals("Test that Quotation arraylist size is 4", 4, quotationList.size());
	        assertSame("Test that Quotation is added", quotation1, quotationList.get(3));

	        //Add another item. test The size of the list is 2? - normal
	        //The item just added is as same as the second item of the list
	        C206_CaseStudy.addQuotation(quotationList, quotation1);
	        // Original 4, added 1, now 5
	        assertEquals("Test that Quotation arraylist size is 5", 5, quotationList.size());
	        assertSame("Test that Quotation is added", quotation1, quotationList.get(4));

	    }

	    @Test
	    public void testDeleteQuotation() { 
	    // Item list is not null, so that can delete an item - boundary
	    assertNotNull("Check if there is valid Quotation arraylist, so that can delete from the list", quotationList);
	    //Given an empty list, after adding two pgg, the size of the list is 2. 
	    //After removing an pkg, then the size of the list becomes 1.
	    C206_CaseStudy.deleteQuotation(quotationList, quotation1);
	    // Original 3, removed 1, left 2
	    assertEquals("Check that quotation arraylist size is 2", 2, quotationList.size());
//	    assertSame("Check that quotation is added", quotation1, quotationList.get(0));

	    //Add another item. test The size of the list is 2? -normal
	    //The item just added is as same as the second item of the list
	    C206_CaseStudy.deleteQuotation(quotationList, quotation2);
	    assertEquals("Check that Quotation arraylist size is 1", 1, quotationList.size());
	    // assertSame("Check that Quotation is added", quotation1, quotationList.get(1));        
	}

	    @Test
	    public void testRetrieveAllQuotation() {
	        // Item list is not null, so that can add a new item - boundary
	        assertNotNull("Test if there is valid Quotation arraylist to retrieve from", quotationList);

	        //Given an empty list, after adding 1 item, the size of the list is 1 - normal
	        //The item just added is as same as the first item of the list
	        C206_CaseStudy.addQuotation(quotationList, quotation1);        
	        // Original 3, added 1, now 4
	        assertEquals("Test that Quotation arraylist size is 4", 4, quotationList.size());
	        assertSame("Test that Quotation is added", quotation1, quotationList.get(3));

	        //Add another item. test The size of the list is 2? - normal
	        //The item just added is as same as the second item of the list
	        C206_CaseStudy.addQuotation(quotationList, quotation1);
	        // Original 4, added 1, now 5
	        assertEquals("Test that Quotation arraylist size is 5", 5, quotationList.size());
	        assertSame("Test that quotation is in quotationList", quotation1, quotationList.get(4));
	    }*/
	
	// Option 4 (Quotation)
	/*	@Test
	public void testRetrieveAllManageQuotations() {
		// Test if list is not null but empty - boundary
		assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", manageList);

		// test if the list of quotations retrieved from the SourceCentre is empty -
		// boundary
		String allQuotation = C206_CaseStudy.retrieveAllManageQuotation(manageList);
		String output = "";
		assertEquals("Check that manageList", output, allQuotation);

		// Given an empty list, after adding 2 items, test if the size of the is 1 -
		// normal
		C206_CaseStudy.addManageQuotation(manageList, Q);
		assertEquals("check that quotation arraylist is size 1", 1, manageList.size());

		// Test if the expected output string same as the list of timetable retrieved
		allQuotation = C206_CaseStudy.retrieveAllManageQuotation(manageList);
		output = String.format("%-15d%-15d%-13s%-20s%-15s%-15s%-10d\n", Q.getRequestID(), Q.getQuotationID(),
				Q.getCategory(), Q.getCategoryItems(), Q.getDesignerName(), Q.getStartDate(), Q.getTotalAmount());
		assertEquals("Test that viewAllQuotations", output, allQuotation);
	}

	@Test
	public void testAddManageQuotation() {
		// manageList is not null, so that can add new item - boundary
		assertNotNull("Check if there is valid Quotation arraylist to add to", manageList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is the same as the first item of the list
		C206_CaseStudy.addManageQuotation(manageList, Q);
		assertEquals("Check that the Quotation arraylist size is 1", 1, manageList.size());
		assertSame("Check that Quotation is added", Q, manageList.get(0));
	}

	public void testRemoveManageQuotation() {
		// Boundary
		assertNotNull("Check if there is valid Quotation arraylist to add to", manageList);
		C206_CaseStudy.addManageQuotation(manageList, Q);

		// Normal
		boolean found = C206_CaseStudy.findManageQuotation(manageList, Q.getRequestID());
		found = C206_CaseStudy.findManageQuotation(manageList, Q.getQuotationID());
		assertTrue("Check if its found", found);

		// Normal
		C206_CaseStudy.doRemoveManageQuotation(manageList, Q.getRequestID());
		assertEquals("Check that Manage Quotation arraylist size is 0", 0, manageList.size());

		// Error
		found = C206_CaseStudy.findManageQuotation(manageList, Q.getRequestID());
		assertFalse("Check if a non-existent user is found", found);
	}
*/
	    
	// Option 5 (Appointment)
	@Test
	public void testAddAppointment() {
		// Test that the Appointment list is not null, so that can add a new appointment
		assertNotNull("Test if there is valid Appointment arraylist to add to", appointmentList);

		// Given an empty list, after adding new appointment, the size of the list is 1
		// - normal
		// The item just added is as same as the first appointment of the list
		C206_CaseStudy.addAppointment(appointmentList, app1);
		assertEquals("Test that Appointment arraylist size is 1", 1, appointmentList.size());
		assertSame("Test that Appointment is added", app1, appointmentList.get(0));

		// Add another appointment. test The size of the list is 2? - normal
		// The item just added is as same as the second appointment of the list
		C206_CaseStudy.addAppointment(appointmentList, app2);
		assertEquals("Test that Appointment arraylist size is 2", 2, appointmentList.size());
		assertSame("Test that Appointment is added", app2, appointmentList.get(1));
	}

	@Test
	public void testRetrieveAllAppointment() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Appointment arraylist to retrieve item", appointmentList);

		// test if the list of camcorders retrieved from the SourceCentre is empty -
		// boundary
		String allAppointment = C206_CaseStudy.retrieveAllAppointment(appointmentList);
		String testOutput = "";
		assertEquals("Check that ViewAllAppointmentlist", testOutput, allAppointment);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addAppointment(appointmentList, app1);
		C206_CaseStudy.addAppointment(appointmentList, app2);
		assertEquals("Test that Appointment arraylist size is 2", 2, appointmentList.size());

		// test if the expected output string same as the list of appointments retrieved
		// from the caseStudy
		allAppointment = C206_CaseStudy.retrieveAllAppointment(appointmentList);
		// testOutput = String.format("%-10s %-20s %-20s %-20s %-10s\n", "NAME",
		// "DESIGNER NAME", "DATE", "TIME", "ADDRESS");
		testOutput += String.format("%-10s %-20s %-20s %-20s %-10s\n", "Siti", "Sam", "12-12-2022", "8:30:00",
				"Pasir Ris ave 8");
		testOutput += String.format("%-10s %-20s %-20s %-20s %-10s\n", "John", "Andrew", "29-01-2023", "14:45:00",
				"Woodlands Drive");

		assertEquals("Test that ViewAllAppointmentlist", testOutput, allAppointment);

	}

	@Test
	public void testDeleteAppointment() {
		// Test if appointment list is not null but empty -boundary
		assertNotNull("Check if there is valid Appointment arraylist to delete to", appointmentList);

		C206_CaseStudy.addAppointment(appointmentList, app1);
		C206_CaseStudy.addAppointment(appointmentList, app2);
		assertEquals(2, appointmentList.size());

		C206_CaseStudy.deleteAppointment(appointmentList, app1.getName());
		assertEquals("Check that Appointment arraylist size is 1", 1, appointmentList.size());

		C206_CaseStudy.deleteAppointment(appointmentList, app2.getName());
		assertEquals("Check that Appointment arraylist size is 0", 0, appointmentList.size());

	}


	    @After
	    public void tearDown() throws Exception {
	      /*quotation1 = null; - hwee liang
	        quotation2 = null;
	        quotation3 = null;*/
	    }

	

}
