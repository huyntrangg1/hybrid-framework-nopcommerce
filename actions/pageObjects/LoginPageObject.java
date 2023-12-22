package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.LoginPageUI;

public class LoginPageObject extends BasePage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
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

}
