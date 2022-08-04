import java.time.LocalDate;

public class Quotation {

	private String property_type;
	private double area_size;
	private String name;
	private int contactNum;
	private String email;
	private double budget;
	private LocalDate cDate; 
	private String renovation_type;
	private int numRooms;
	private int numToilets;
	private String renovation_style;
	private String urgent_request;
	private String rID;
	private String qID;
	private String dName;
	private LocalDate eDate;
	private Double total_quotation_amount;
	private String renovation_category;
	private String category_description;
	
	public Quotation(String rID, String property_type, double area_size, String name, int contactNum, String email, double budget, LocalDate cDate, String renovation_type, int numRooms, int numToilets, String renovation_style, String urgent_request) {
		this.rID = rID;
		this.property_type = property_type;
		this.area_size = area_size;
		this.name = name;
		this.contactNum = contactNum;
		this.email = email;
		this.budget = budget;
		this.cDate = cDate;
		this.renovation_type = renovation_type;
		this.numRooms = numRooms;
		this.numToilets = numToilets;
		this.renovation_style = renovation_style;
		this.urgent_request = urgent_request;
	};

	/**
	public void manage_quotation(String request_id, String quotation_id, String renovation_category, String category_description, String designer_name, LocalDate earliest_quotation_date, double total_quotation_amount) {
		this.request_id = request_id;
		this.quotation_id = quotation_id;
		this.renovation_category = renovation_category;
		this.category_description = category_description;
		this.designer_name = designer_name;
		this.earliest_start_date = earliest_start_date;
		this.total_quotation_amount = total_quotation_amount;
	}
	**/
	
	public String get_property_type() {
		return property_type;
	}
	
	public double get_area_size() {
		return area_size;
	}
	
	public int get_contactNum() {
		return contactNum;
	}
	
	public String get_email() {
		return email;
	}
	
	public double get_budget() {
		return budget;
	}
	
	public LocalDate get_eDate() { 
		return eDate; 
	}
	
	public LocalDate get_cDate() {
		return cDate;
	}
	
	public String get_renovation_type() {
		return renovation_type;
	}
	
	public int get_numRooms() {
		return numRooms;
	}
	
	public int get_numToilets() {
		return numToilets;
	}
	
	public String get_renovation_style() {
		return renovation_style;
	}
	
	public String get_urgent_request() {
		return urgent_request;
	}
	
	public String get_rID() {
		return rID;
	}
	
	private String get_qID() {
		return qID;
	}
	
	public String get_dName() {
		return dName;
	}
	
	public double get_total_quotation_amount() {
		return total_quotation_amount;
	}
	
	public String get_renovation_category() {
		return renovation_category;
	}
	
	public String get_category_description() {
		return category_description;
	}
	
	
	

}
