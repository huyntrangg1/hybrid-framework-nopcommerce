package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;

	private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("h_firefox")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			// } else if (browserName.equals("ie")) {
			// WebDriverManager.iedriver().arch32().setup();
			// driver = new InternetExplorerDriver();
			// } else if (browserName.equals("opera")) {
			// WebDriverManager.operadriver().setup();
			// driver = new OperaDriver();
			// } else if (browserName.equals("coccoc")) {
			// WebDriverManager.chromedriver().driverVersion("93.0.4577.63").setup();
			// ChromeOptions options = new ChromeOptions();
			// options.setBinary("");
			// driver = new ChromeDriver(options);
			// } else if (browserName.equals("brave")) {
			// WebDriverManager.chromedriver().driverVersion("95.o.4638.17").setup();
			// driver = new ChromeDriver();
		} else {
			throw new RuntimeException("Browser name invalid.");
		}
		return driver;
	}
}
