import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class C206_CaseStudy {

	public static void main(String[] args) {
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyy") ; 
		//Manage customer <arrayList>
		//Manage Package <arrayList>
		ArrayList<Packages> packageList = new ArrayList<Packages>(); 
		//Request for quotation <arrayList>
		//Manage Quotation <arrayList>
		//Manage Appointment <arrayList>
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
		
		packageList.add(new Packages("S01", "Renovating Whole Place" ,LocalDate.parse("10/9/2022", f1), LocalDate.parse("23/2/2023", f1) , 15000.0  )) ;
		packageList.add(new Packages("S02", "Renovating Restrooms Only" ,LocalDate.parse("10/8/2022", f1), LocalDate.parse("1/11/2022", f1) , 6000.0  )) ;
		packageList.add(new Packages("S03", "Renovation Kitchen Only" ,LocalDate.parse("10/6/2022", f1), LocalDate.parse("23/10/2022", f1) , 7000.0  )) ;
		// as a admin u can add more packages
		
		int option = 0 ; 
		while(option != 5) { 
			C206_CaseStudy.menu() ; 
			option = Helper.readInt("Enter an option > ") ; 
			if (option == 1) { 
				
			}
			else if (option == 2) {
				
			}
			else if (option == 3) {
				
			}
			else if (option == 4) {
				
			}
			else if (option == 5) {
				C206_CaseStudy.viewAllAppointment(appointmentList);
				C206_CaseStudy.retrieveAllAppointment(appointmentList);
			}
			else {
				
			}
		}
		}
		public static void menu() {
			C206_CaseStudy.setHeader("Renovation APP");
			System.out.println("1. Manage Customer");
			System.out.println("2. Manage Package");
			System.out.println("3. Request Quotation");
			System.out.println("4. Manage Quotation ");
			System.out.println("5. Manage Appointment");
			System.out.println("6. Quit");
			Helper.line(80, "-");

	}
		private static void setHeader(String header) {
			Helper.line(80, "-");
			System.out.println(header);
			Helper.line(80, "-");

			
		}
		
		public static String retrieveAllAppointment(ArrayList<Appointment> appointmentList) {
			String output = "";
			for(int i  = 0; i < appointmentList.size(); i++) {
				output += String.format("%-84s\n", appointmentList.get(i).toString());
			}
			return output;
		}
		
		public static void viewAllAppointment(ArrayList<Appointment> appointmentList) {
			C206_CaseStudy.setHeader("VIEW APPOINTMENT");
			String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "CODE", "DESCRIPTION", "DATE", "TIME");
			output += retrieveAllAppointment(appointmentList);
			System.out.println(output);
		}
		
		public static void requestQuotation(ArrayList<Quotation> quotationList) {
			// to be done later
		}
		
		public static void manageQuotation(ArrayList<Quotation> quotationList) {
			// to be done later
		}
		
		

}
