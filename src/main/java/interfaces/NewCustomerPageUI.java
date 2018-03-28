package interfaces;

public class NewCustomerPageUI {
	public static final String CUSTOMER_NAME_TXT = "//input[@name='name']";
	public static final String DAY_OF_BIRTH_TXT = "//input[@name='dob']";
	public static final String ADDRESS_TXT = "//textarea[@name='addr']";
	public static final String CITY_TXT = "//input[@name='city']";
	public static final String STATE_TXT = "//input[@name='state']";
	public static final String PIN_TXT = "//input[@name='pinno']";
	public static final String TELEPHONE_NUMBER_TXT = "//input[@name='telephoneno']";
	public static final String EMAIL_TXT = "//input[@name='emailid']";
	public static final String PASSWORD_TXT = "//input[@name='password']";
	public static final String SUBMIT_BTN = "//input[@name='sub']";
	
	//Customer Registered
	public static final String SUCCESS_MES = "//*[@id='customer']//p[@class='heading3']";
	public static final String CUSTOMER_ID_TXT = "//*[contains(text(),'Customer ID')]/following-sibling::td";
	public static final String CUSTOMER_NAME_CREATED = "//*[contains(text(),'Customer Name')]/following-sibling::td";
	public static final String DAY_OF_BIRTH_CREATED = "//*[contains(text(),'Birthdate')]/following-sibling::td";
	public static final String ADDRESS_CREATED = "//*[contains(text(),'Address')]/following-sibling::td";
	public static final String CITY_CREATED = "//*[contains(text(),'City')]/following-sibling::td";
	public static final String STATE_CREATED = "//*[contains(text(),'State')]/following-sibling::td";
	public static final String PIN_CREATED = "//*[contains(text(),'Pin')]/following-sibling::td";
	public static final String TELEPHONE_NUMBER_CREATED = "//*[contains(text(),'Mobile No.')]/following-sibling::td";
	public static final String EMAIL_CREATED = "//*[contains(text(),'Email')]/following-sibling::td";
	
	//Message validate
	public static final String CUSTOMER_NAME_MES="//*[@id='message']";
	public static final String DAY_OF_BIRTH_MES="//*[@id='message24']";
	public static final String ADDRESS_MES="//*[@id='message3']";
	public static final String CITY_MES="//*[@id='message4']";
	public static final String STATE_MES="//*[@id='message5']";
	public static final String PIN_MES="//*[@id='message6']";
	public static final String TELEPHONE_NUMBER_MES="//*[@id='message7']";
	public static final String EMAIL_MES="//*[@id='message9']";
	public static final String PASSWORD_MES="//*[@id='message18']";
}
