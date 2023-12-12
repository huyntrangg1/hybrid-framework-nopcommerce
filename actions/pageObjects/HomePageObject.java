package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commons.BasePage;
import pageUI.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	// public void setDriver(WebDriver driver) {
	// this.driver = driver;
	// }

}
