import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyy") ; 
	
	//User
	
	//Appointment
	private Appointment app1;
	private Appointment app2;
	private Appointment app3;
	
	//Package
	private ArrayList<Packages> packageList ; 
	private Packages pl1 ; 
	private Packages pl2 ; 
	private Packages pl3 ; 
	//Quotation
	
	//Arraylist
	private ArrayList<Appointment> appointmentList;
	
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		//prepare test data
//		app1 = new Appointment("", "", 2022-12-12, true);
		//Package
		pl1 = new Packages("S01", "Renovating Whole Place" ,LocalDate.parse("10/09/2022", f1), LocalDate.parse("23/02/2023", f1) , 15000.0) ; 
		pl2 = new Packages("S02", "Renovating Restrooms Only" ,LocalDate.parse("10/08/2022", f1), LocalDate.parse("10/11/2022", f1) , 6000.0 ) ; 
		pl3 = new Packages("S03", "Renovation Kitchen Only" ,LocalDate.parse("10/06/2022", f1), LocalDate.parse("23/10/2022", f1) , 7000.0 ); 
		
		appointmentList = new ArrayList<Appointment>();
		
	}

	
	//Option 2 (Package)
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	@Test
	public void testAddPackage() { 
		// Pkg list is not null, so that can add a new package - boundary
		assertNotNull("Check if there is valid Package arraylist to add to", packageList);
		//Given an empty list, after adding 1 package, the size of the list is 1 -normal
		C206_CaseStudy.addPackage(packageList, pl1);
		assertEquals("Check that Package arraylist size is 1", 1, packageList.size());
		assertSame("Check that Camcorder is added", pl1, packageList.get(0));
		
		//Add another pkg. test The size of the list is 2? - normal --not added
		C206_CaseStudy.addPackage(packageList, pl2);
		assertEquals("Check that Package arraylist size is 2", 2, packageList.size());
		assertSame("Check that Package is added", pl2, packageList.get(1));
	}
	@Test
	public void testRetrieveAllPackage() {
		// Test if Package list is not null but empty -boundary
		assertNotNull("Test if there is valid Package arraylist to retrieve package", packageList);
		//test if the list of package retrieved from the list is empty - boundary
		String allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		String testOutput = "";
		assertEquals("Check that viewAllPackage", testOutput, allPackage);
		
		//Given an empty list, after adding 2 pkg, test if the size of the list is 2 - normal
		C206_CaseStudy.addPackage(packageList, pl1);
		C206_CaseStudy.addPackage(packageList, pl2);
		assertEquals("Test that Package arraylist size is 2", 2, packageList.size());
		
		//test if the expected output string same as the list of pkg retrieved from the list	
		allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n", "S01", "Renovating Whole Place" ,"10/09/2022", "23/02/2023", "15000.0");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","S02", "Renovating Restrooms Only" ,"10/08/2022", "10/11/2022" ,"6000.0" );
	
		assertEquals("Test that ViewAllPackagelist", testOutput, allPackage);
			
		}
	
//Option 5 (APPOINTMENT) *Still not done*
	@Test
	public void testAddAppointment() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Chromebook arraylist to add to", appointmentList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addAppointment(appointmentList, app1);		
		assertEquals("Test that Chromebook arraylist size is 1", 1, appointmentList.size());
		assertSame("Test that Chromebook is added", app1, appointmentList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addAppointment(appointmentList, app2);
		assertEquals("Test that Chromebook arraylist size is 2", 2, appointmentList.size());
		assertSame("Test that Chromebook is added", app2, appointmentList.get(1));
	}
	
	@Test
	public void testRetrieveAllAppointment() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", appointmentList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty - boundary
		String allAppointment = C206_CaseStudy.retrieveAllAppointment(appointmentList);
		String testOutput = "";
		assertEquals("Check that ViewAllAppointmentlist", testOutput, allAppointment);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addAppointment(appointmentList, app1);
		C206_CaseStudy.addAppointment(appointmentList, app2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, appointmentList);	
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre	
		allAppointment = C206_CaseStudy.retrieveAllAppointment(appointmentList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CC0011", "Nikon HDSLR", "Yes", "", "40");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CC0012", "Sony DSC-RX100M7", "Yes", "", "20" );
	
		assertEquals("Test that ViewAllCamcorderlist", testOutput, allAppointment);
		
	}
//END OF APPOINTMENT CODE
	
	
	@After
	public void tearDown() throws Exception {
	}

}
