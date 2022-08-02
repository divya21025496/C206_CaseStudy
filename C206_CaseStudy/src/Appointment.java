import java.sql.Time;
import java.time.LocalDate;

public class Appointment {
	private String code ;
	private String description ; 
	private LocalDate date ; 
	private Time time;
	
	public Appointment(String code, String description, LocalDate date,  Time time) { 
		this.code = code ; 
		this.description = description ; 
		this.date = date ; 
		this.time = time ; 
		
	}
	public String getCode() { 
		return code ; 
	}
	public String getDescription() { 
		return description ; 
	}
	public LocalDate getDate() { 
		return date ; 
	}
	private Time getTime() {
		return time;
	}

}
