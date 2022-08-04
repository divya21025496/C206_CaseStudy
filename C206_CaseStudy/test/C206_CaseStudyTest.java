import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	
	//User
	
	//Appointment
	private Appointment app1;
	private Appointment app2;
	private Appointment app3;
	
	//Package
	
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
		
		appointmentList = new ArrayList<Appointment>();
	}

	

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
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
