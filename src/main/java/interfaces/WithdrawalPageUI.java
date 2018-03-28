package interfaces;

public class WithdrawalPageUI {
	public static final String ACCOUNT_NO_TXT = "//*[@name='accountno']";
	public static final String AMOUNT_TXT = "//*[@name='ammount']";
	public static final String DESCRIPTION_TXT = "//*[@name='desc']";
	public static final String SUBMIT_BTN = "//*[@name='AccSubmit']";
	
	public static final String SUCCESS_MES = "//*[@id='withdraw']//p[@class='heading3']";
	public static final String CURRENT_BALANCE = "//*[contains(text(),'Current Balance')]/following-sibling::td";
	public static final String ACCOUNT_NO = "//*[contains(text(),'Account No')]/following-sibling::td";
	public static final String AMOUNT_DEBITED = "//*[contains(text(),'Amount Debited')]/following-sibling::td";
	public static final String DESCRIPTION = "//*[contains(text(),'Description')]/following-sibling::td";
}
