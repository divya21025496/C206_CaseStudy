/**
 * 
 */

/**
 * @author 21025496
 *
 */
public class ManageQuotation {
	private int RequestID;
	 private int QuotationID;
	 private String category;
	 private String categoryItems;
	 private String DesignerName;
	private String startDate;
	 private int TotalAmount;

	

	 public ManageQuotation(int requestID, int quotationID, String category, String categoryItems, String designerName,
			String startDate, int totalAmount) {

		RequestID = requestID;
		QuotationID = quotationID;
		this.category = category;
		this.categoryItems = categoryItems;
		DesignerName = designerName;
		this.startDate = startDate;
		TotalAmount = totalAmount;
	}

	public int getRequestID() {
	 return RequestID;
	 }

	 public int getQuotationID() {
	 return QuotationID;
	 }

	 public String getCategory() {
	 return category;
	 }

	 public String getCategoryItems() {
	 return categoryItems;
	 }

	 public String getDesignerName() {
	 return DesignerName;
	 }

	 public String getStartDate() {
	 return startDate;
	 }

	 public int getTotalAmount() {
	 return TotalAmount;
	 }
}
