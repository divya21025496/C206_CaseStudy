import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class C206_CaseStudy {
	
	//private static final int OPTION_PACKAGE = 2;
	public static void main(String[] args) {
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyy") ; 
		//Manage customer <arrayList>
		//Manage Package <arrayList>
		ArrayList<Packages> packageList = new ArrayList<Packages>(); 
		//Request for quotation <arrayList>
		//Manage Quotation <arrayList>
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
		//Manage Appointment <arrayList>
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		
		// 23/2/2023
		
		// DD MM YY -divya
			Packages pl = new Packages("S01", "Renovating Whole Place" ,"10/09/2022","23/02/2023", "15000.00 ") ; 
			Packages p2 = new Packages ("S02", "Renovating Restrooms Only" ,"10/08/2022", "10/11/2022", "6000.00 " ) ;
			//Packages pl = new Packages("S01", "Renovating Whole Place" ,LocalDate.parse("10/09/2022", f1), LocalDate.parse("23/02/2023", f1) , 15000.0  ) ;
			//packageList.add(new Packages("S02", "Renovating Restrooms Only" ,LocalDate.parse("10/08/2022", f1), LocalDate.parse("10/11/2022", f1) , 6000.0  )) ;
			//packageList.add(new Packages("S03", "Renovation Kitchen Only" ,LocalDate.parse("10/06/2022", f1), LocalDate.parse("23/10/2022", f1) , 7000.0  )) ;
			packageList.add(pl) ; 
			packageList.add(p2) ; 
		
		//packageList.add(new Packages("S01", "Renovating Whole Place" ,LocalDate.parse("2022-09-10"), LocalDate.parse("2023-02-23") , 15000.0)) ;
	//	packageList.add(new Packages("S02", "Renovating Restrooms Only" ,LocalDate.parse("2022-08-10"), LocalDate.parse("2022-11-01") , 6000.0)) ;
		//packageList.add(new Packages("S03", "Renovation Kitchen Only" ,LocalDate.parse("2022-06-10"), LocalDate.parse("2022-10-23") , 7000.0)) ;
		// as a admin u can add more packages
		
		int option = 0 ; 
		while(option != 5) { 
			C206_CaseStudy.menu() ; 
			option = Helper.readInt("Enter an option > ") ; 
			if (option == 1) { 
				
			}
			else if (option == 2) {
				int choice = Helper.readInt("Enter Choice > ");
				if (choice == 1) {
					// view package 
					C206_CaseStudy.viewAllPackage(packageList) ;
				} else if (choice == 2) {
					//add package 
					Packages p = inputPackages();
					C206_CaseStudy.addPackage(packageList, p) ; 
					System.out.println("Package Added"); 
				} else if(choice ==3) {
					// delete
				//	C206_CaseStudy.deletePackage(packageList, pp) ; 
				}
				
				
			}
			else if (option == 3) {
				requestQuotation(quotationList);
				
			}
			else if (option == 4) {
				
			}
			else if (option == 5) {
				C206_CaseStudy.viewAllAppointment(appointmentList);
				C206_CaseStudy.retrieveAllAppointment(appointmentList);
				Appointment app = inputAppointment();
				C206_CaseStudy.addAppointment(appointmentList, app);
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
		//===============================================Option 2==================================================
		public static String retrieveAllPackage(ArrayList<Packages> packageList) {
			String output = "" ;
			for (int i = 0; i < packageList.size(); i++) {
				output += String.format("%-10s %-30s %-10s %-10s %-20s\n",
						packageList.get(i).getCode() , packageList.get(i).getDescription(), 
						packageList.get(i).getStDate(), packageList.get(i).getEndDate(), packageList.get(i).getAmount()) ;
				//output += String.format("%-84s\n", packageList.get(i).toString());
			}
			return output; 
			 
		}
		public static void viewAllPackage(ArrayList<Packages> packageList) { 
			C206_CaseStudy.setHeader("VIEW PACKAGE");
			String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "CODE", "DESCRIPTION", "START_DATE", "END_DATE","AMOUNT");
			output += retrieveAllPackage(packageList);
			System.out.println(output);
		}
		public static Packages inputPackages() {
			//DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyy") ; 
			String code = Helper.readString("Enter code") ; 
			String description = Helper.readString("Enter description > ");
			String stDate = Helper.readString("Enter Start Date: ") ; 
			String  endDate = Helper.readString("Enter End Date: ") ; 
			//double amt = Helper.readDouble("Enter amount: " ) ; 
			String amt = Helper.readString("Enter amt> " ) ; 
			//LocalDate st = LocalDate.parse(stDate, f1) ;
			//LocalDate ed = LocalDate.parse(endDate, f1) ;
			Packages pakg= new Packages(code, description, stDate, endDate, amt);
			return pakg ;
		}
		public static void addPackage(ArrayList<Packages> packageList, Packages p) {
			packageList.add(p) ; 
		}
		/*public static Packages outputPackages() {
			String codePkg = Helper.readString("Enter the Package Code: ") ; 
			Packages pakg= new Packages(codePkg) ; 
			return pakg; 
		} */

		public static void deletePackage(ArrayList<Packages> packageList, Packages pp) { 
			String codePkg = Helper.readString("Enter the Package Code: ") ; 
			for (int i = 0 ; i< packageList.size() ; i ++ ) {
			if (packageList.get(i).getCode().equalsIgnoreCase(codePkg)) {
				String option = Helper.readString("Are you sure that you want to delete (y/n) > ") ; 
				if (option.equalsIgnoreCase("y")) { 
					packageList.remove(i) ; 
				} else { 
					System.out.println("Delete failed") ; 
				}
			} else { 
				System.out.println("Code not found in the system") ; 
			}
			}

		}
	
		
//=========================APPOINTMENT option 5
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
		
		public static Appointment inputAppointment() {
			String date = Helper.readString("Enter asset tag > ");
			String description = Helper.readString("Enter description > ");
			String time = Helper.readString("Enter time > ");

			Appointment app = new Appointment(date, description, time);
			return app;
			
		}
		
		public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment app) {
			// TODO Auto-generated method stub
			appointmentList.add(app);
		}
//==================================================================
		
		
		//TBC later
		public static void requestQuotation(ArrayList<Quotation> quotationList) {
			DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyy") ; 
			String rID = "";
			String property_type = Helper.readString("Property type > ");
			Double area_size = Helper.readDouble("Area size > ");
			String name = Helper.readString("Name > ");
			int contactNum = Helper.readInt("Contact number > ");
			String email = Helper.readString("Email > ");
			Double budget = Helper.readDouble("Budget > ");
			String renovation_type = Helper.readString("Renovation type > ");
			int numRooms = Helper.readInt("Number of rooms to renovate > ");
			int numToilets = Helper.readInt("Number of toilets to renovate > ");
			String renovation_style = Helper.readString("Renovation style (optional) > ");
			String urgent_request = Helper.readString("Urgent request > ");
			
			String cDate1 = Helper.readString("Completion date (YYYY-MM-DD)> ");
			LocalDate cDate = LocalDate.parse(cDate1);
			
			Quotation q = new Quotation(rID, property_type, area_size, name, contactNum, email, budget, cDate, renovation_type, numRooms, numToilets, renovation_style, urgent_request);
			System.out.println(q);
			
			// new Quotation(request_id, property_type, area_size, email, budget, completion_date, num_of_rooms_renovate, num_of_toilets_renovate, renovation_style, urgent_request);
			
		}
		
		public static void manageQuotation(ArrayList<Quotation> quotationList) {
			// TBD later //
		}
		
		


}
