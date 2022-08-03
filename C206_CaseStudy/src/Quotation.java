import java.time.LocalDate;

public class Quotation {

	private String property_type;
	private double area_size;
	private String name;
	private int contactNum;
	private String email;
	private double budget;
	private LocalDate completion_date; 
	private String renovation_type;
	private int num_of_rooms_renovate;
	private int num_of_toilets_renovate;
	private String renovation_style;
	private String urgent_request;
	private String request_id;
	private String quotation_id;
	private String designer_name;
	private LocalDate earliest_start_date;
	private Double total_quotation_amount;
	private String renovation_category;
	private String category_description;
	
	public Quotation(String request_id, String property_type, double area_size, String name, int contactNum, String email, double budget, LocalDate completion_date, String renovation_type, int num_of_rooms_renovate, int num_of_toilets_renovate, String renovation_style, String urgent_request) {
		this.request_id = request_id;
		this.property_type = property_type;
		this.area_size = area_size;
		this.name = name;
		this.contactNum = contactNum;
		this.email = email;
		this.budget = budget;
		this.completion_date = completion_date;
		this.renovation_type = renovation_type;
		this.num_of_rooms_renovate = num_of_rooms_renovate;
		this.num_of_toilets_renovate = num_of_toilets_renovate;
		this.renovation_style = renovation_style;
		this.urgent_request = urgent_request;
	};

	// for admin/designer to update 
	public void manage_quotation(String request_id, String quotation_id, String renovation_category, String category_description, String designer_name, LocalDate earliest_quotation_date, double total_quotation_amount) {
		this.request_id = request_id;
		this.quotation_id = quotation_id;
		this.renovation_category = renovation_category;
		this.category_description = category_description;
		this.designer_name = designer_name;
		this.earliest_start_date = earliest_start_date;
		this.total_quotation_amount = total_quotation_amount;
	}
	
	
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
	
	public LocalDate get_earliest_start_date() { 
		return earliest_start_date; 
	}
	
	}
	
	public LocalDate get_completion_date() {
		return completion_date;
	}
	
	public String get_renovation_type() {
		return renovation_type;
	}
	
	public int get_num_of_rooms_renovate() {
		return num_of_rooms_renovate;
	}
	
	public int get_num_of_toilets_renovate() {
		return num_of_toilets_renovate;
	}
	
	public String get_renovation_style() {
		return renovation_style;
	}
	
	public String get_urgent_request() {
		return urgent_request;
	}
	
	public String get_request_id() {
		return request_id;
	}
	
	private String get_quotation_id() {
		return quotation_id;
	}
	
	public String designer_name() {
		return designer_name;
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
