/**
 * 
 */

import java.time.LocalDate; //
/**
 * @author 21025496
 *
 */
public class Packages {
	private String code ;
	private String description ; 
	private String stDate ; 
	private String endDate ; 
	private String amount ; 
	
	public Packages(String code, String description, String stDate, String endDate, String amount) { 
		this.code = code ; 
		this.description = description ; 
		this.stDate = stDate ; 
		this.endDate = endDate ; 
		this.endDate = endDate ; 
		this.amount = amount ; 
		
	}
	public Packages(String code) { 
		this.code = code ; 
	}
	public String getCode() { 
		return code ; 
	}
	public String getDescription() { 
		return description ; 
	}
	public String getStDate() { 
		return stDate ; 
	}
	public String getEndDate() { 
		return endDate ; 
	}
	public String getAmount() { 
		return amount ; 
	}
	/*public LocalDate getStDate() { 
		return stDate ; 
	}
	public LocalDate getEndDate() { 
		return endDate ; 
	}
	public double getAmount() { 
		return amount ; 
	}*/
}
