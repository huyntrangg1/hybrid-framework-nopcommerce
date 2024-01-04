package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.CustomerInforPageUI;

public class CustomerInforPageObject extends BasePage {
	private WebDriver driver;

	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInforPageObject() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

}
