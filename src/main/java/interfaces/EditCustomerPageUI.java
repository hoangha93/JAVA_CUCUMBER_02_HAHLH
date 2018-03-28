package interfaces;

public class EditCustomerPageUI {
	public static final String CUSTOMER_ID_TXT = "//input[@name='cusid']";
	public static final String ACCOUNT_SUBMIT_BTN = "//input[@name='AccSubmit']";
	public static final String CUSTOMER_NAME_TXT = "//input[@name='name']";
	public static final String DAY_OF_BIRTH_TXT = "//input[@name='dob']";
	public static final String ADDRESS_TXT = "//textarea[@name='addr']";
	public static final String CITY_TXT = "//input[@name='city']";
	public static final String STATE_TXT = "//input[@name='state']";
	public static final String PIN_TXT = "//input[@name='pinno']";
	public static final String TELEPHONE_NUMBER_TXT = "//input[@name='telephoneno']";
	public static final String EMAIL_TXT = "//input[@name='emailid']";
	public static final String SUBMIT_BTN = "//input[@name='sub']";
	public static final String SUCCESS_MES = "//*[@id='customer']//p[@class='heading3']";
	
	//Edited
	public static final String CUSTOMER_ID_EDITED = "//*[contains(text(),'Customer ID')]/following-sibling::td";
	public static final String CUSTOMER_NAME_EDITED = "//*[contains(text(),'Customer Name')]/following-sibling::td";
	public static final String ADDRESS_EDITED = "//*[contains(text(),'Address')]/following-sibling::td";
	public static final String CITY_EDITED = "//*[contains(text(),'City')]/following-sibling::td";
	public static final String STATE_EDITED = "//*[contains(text(),'State')]/following-sibling::td";
	public static final String PIN_EDITED = "//*[contains(text(),'Pin')]/following-sibling::td";
	public static final String TELEPHONE_NUMBER_EDITED = "//*[contains(text(),'Mobile No.')]/following-sibling::td";
	public static final String EMAIL_EDITED = "//*[contains(text(),'Email')]/following-sibling::td";
}
