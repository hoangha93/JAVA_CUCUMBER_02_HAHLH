package interfaces;

public class FundTransferPageUI {
	public static final String PAYERS_NO_TXT = "//*[@name='payersaccount']";
	public static final String PAYEES_NO_TXT = "//*[@name='payeeaccount']";
	public static final String AMOUNT_TXT = "//*[@name='ammount']";
	public static final String DESCRIPTION_TXT = "//*[@name='desc']";
	public static final String SUBMIT_BTN = "//*[@name='AccSubmit']";
	
	
	public static final String SUCCESS_MES = "//*[contains(text(),'From Account Number')]/following-sibling::td";
	public static final String AMOUNT_TRANSFER_TXT = "//*[contains(text(),'Amount')]/following-sibling::td";
	public static final String TO_ACCOUNT_NUMBER = "//*[contains(text(),'To Account Number')]/following-sibling::td";
	public static final String DESCRIPTION = "//*[contains(text(),'Description')]/following-sibling::td";
}
