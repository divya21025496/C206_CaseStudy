/**
 * 
 */

import java.time.LocalDate;
/**
 * @author 21025496
 *
 */
public class Packages {
	private String code ;
	private String description ; 
	private LocalDate stDate ; 
	private LocalDate endDate ; 
	private double amount ; 
	
	public Packages(String code, String description, LocalDate stDate, LocalDate endDate, double amount) { 
		this.code = code ; 
		this.description = description ; 
		this.stDate = stDate ; 
		this.endDate = endDate ; 
		this.endDate = endDate ; 
		this.amount = amount ; 
		
	}
	public String getCode() { 
		return code ; 
	}
	public String getDescription() { 
		return description ; 
	}
	public LocalDate getStDate() { 
		return stDate ; 
	}
	public LocalDate getEndDate() { 
		return endDate ; 
	}
	private double getAmount() { 
		return amount ; 
	}
}
