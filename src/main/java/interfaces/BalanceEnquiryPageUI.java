package interfaces;

public class BalanceEnquiryPageUI {
	public static final String ACCOUNT_NO_TXT = "//*[@name='accountno']";
	public static final String SUBMIT_BTN = "//*[@name='AccSubmit']";
	public static final String HEADING_MES = "//*[@id='balenquiry']//p[@class='heading3']";
	public static final String BALANCE_TXT = "//*[contains(text(),'Balance')]/following-sibling::td";
}
