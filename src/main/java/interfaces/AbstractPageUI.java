package interfaces;

public class AbstractPageUI {
	public static final String DYNAMIC_MENU_PAGE = "//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX = "//input[@name='%s']";
	public static final String DYNAMIC_TEXTAREA = "//textarea[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_DROPDOWN_LIST = "//select[@name='%s']";
	public static final String DYNAMIC_BTN = "//input[@name='%s']";
	public static final String DYNAMIC_DATA_NEW_CREATED = "//*[contains(text(),'%s')]/following-sibling::td";
	public static final String CHECK_DYNAMIC_NEW_EDIT_CUSTOMER_DISPLAY = "//p[contains(text(),'%s')]";
	public static final String CUSTOMER_ID = "//input[@name='accountno']";
}
