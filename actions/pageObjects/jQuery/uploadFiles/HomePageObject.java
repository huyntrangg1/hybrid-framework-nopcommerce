package pageObjects.jQuery.uploadFiles;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.oer.its.etsi102941.SharedAtRequest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.datatable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadByName(String fileName) {
		waitForElementVisible(driver, pageUIs.jQuery.uploadFiles.HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, pageUIs.jQuery.uploadFiles.HomePageUI.FILE_NAME_LOADED, fileName);

	}

	public boolean isFileUploadByName(String fileName) {
		waitForElementVisible(driver, pageUIs.jQuery.uploadFiles.HomePageUI.FILE_NAME_UPLOADED, fileName);
		return isElementDisplayed(driver, pageUIs.jQuery.uploadFiles.HomePageUI.FILE_NAME_UPLOADED, fileName);

	}

	public void clickToStartButton() {

		List<WebElement> startButtons = getElements(driver, pageUIs.jQuery.uploadFiles.HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileImageUploadByName(String fileName) {
		waitForElementVisible(driver, pageUIs.jQuery.uploadFiles.HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, pageUIs.jQuery.uploadFiles.HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}

}
