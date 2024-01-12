package pageObjects.portal.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopcommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {

	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.loginButton);
		clickToElement(driver, LoginPageUI.loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.errorMessageAtEmailTextbox);
		return getTextElement(driver, LoginPageUI.errorMessageAtEmailTextbox);

	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.emailTextbox);
		sendkeyToElement(driver, LoginPageUI.emailTextbox, email);
	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, LoginPageUI.errorMessageUnsuccessful);
		return getTextElement(driver, LoginPageUI.errorMessageUnsuccessful);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.passwordTextbox);
		sendkeyToElement(driver, LoginPageUI.passwordTextbox, password);
	}

	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		clickToLoginButton();
		return PageGeneratorManager.getUserHomePage(driver);
	}
}
