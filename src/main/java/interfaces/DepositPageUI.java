package interfaces;

public class DepositPageUI {
	public static final String ACCOUNT_NO_TXT = "//*[@name='accountno']";
	public static final String AMOUNT_TXT = "//*[@name='ammount']";
	public static final String DESCRIPTION_TXT = "//*[@name='desc']";
	public static final String SUBMIT_BTN = "//*[@name='AccSubmit']";

	// Verify Transfer money into a current account
	public static final String SUCCESS_MES = "//*[@id='deposit']//p[@class='heading3']";
	public static final String CURRENT_BALANCE = "//*[contains(text(),'Current Balance')]/following-sibling::td";
	public static final String ACCOUNT_NO = "//*[contains(text(),'Account No')]/following-sibling::td";
	public static final String AMOUNT_CREDITED = "//*[contains(text(),'Amount Credited')]/following-sibling::td";
	public static final String TYPE_TRANSACSION = "//*[contains(text(),'Type of Transaction')]/following-sibling::td";
	public static final String DESCRIPTION_TRANSACTION = "//*[contains(text(),'Description')]/following-sibling::td";
}
