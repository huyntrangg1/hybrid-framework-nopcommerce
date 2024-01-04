package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.MyProductReviewPageUI;
import pageUI.RewardPointPageUI;

public class MyProductReviewPageObject extends BasePage {
	private WebDriver driver;

	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
