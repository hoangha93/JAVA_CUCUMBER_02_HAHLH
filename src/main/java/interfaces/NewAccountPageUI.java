package interfaces;

public class NewAccountPageUI {
	public static final String CUSTOMER_ID_TXT = "//input[@name='cusid']";
	public static final String ACCOUNT_SLC = "//select[@name='selaccount']";
	public static final String INITIAL_DEPOSIT_TXT = "//input[@name='inideposit']";
	public static final String SUBMIT_BTN = "//input[@name='button2']";
	public static final String SUCCESS_MES = "//*[@id='account']//p[@class='heading3']";
	public static final String CURRENT_AMOUNT_TXT = "//*[contains(text(),'Current Amount')]/following-sibling::td";
	public static final String ACCOUNT_ID_TXT = "//*[contains(text(),'Account ID')]/following-sibling::td";
	
	//Verify account created
	public static final String CUSTOMER_ID= "//*[contains(text(),'Customer ID')]/following-sibling::td";
	public static final String CUSTOMER_NAME= "//*[contains(text(),'Customer Name')]/following-sibling::td";
	public static final String CUSTOMER_EMAIL= "//*[contains(text(),'Email')]/following-sibling::td";
	public static final String ACCOUNT_TYPE_CREATED = "//*[contains(text(),'Account Type')]/following-sibling::td";
	public static final String CURRENT_AMOUNT_CREATED = "//*[contains(text(),'Current Amount')]/following-sibling::td";
}
